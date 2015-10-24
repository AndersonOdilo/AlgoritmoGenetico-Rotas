/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import models.Roteiro;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author anderson
 */
public class Algoritmo {

    Roteiro roteiro;
    int nMaxEvolucoes;
    int capacidadeMaxVeiculo;

    public Algoritmo(Roteiro roteiro, int nMaxEvolucoes, int capacidadeMaxVeiculo) {
        this.roteiro = roteiro;
        this.nMaxEvolucoes = nMaxEvolucoes;
        this.capacidadeMaxVeiculo = capacidadeMaxVeiculo;
    }

    public void executar() throws InvalidConfigurationException, IOException {

        //inicia configuração do algoritimo padrao
        Configuration conf = new DefaultConfiguration();

        //Seta operador genetico criado
        OperadorGenetico operadorGenetico = new OperadorGenetico(roteiro);
        conf.addGeneticOperator(operadorGenetico);

        //cria objeto fitness
        FitnessFunction fitness = new Fitness(roteiro);
        conf.setFitnessFunction(fitness);

        // criar um seletor que nao permite duplicações
        conf.getNaturalSelectors(false).clear();
        BestChromosomesSelector bcs = new BestChromosomesSelector(conf, 1.0d);
        bcs.setDoubletteChromosomesAllowed(false);
        conf.addNaturalSelector(bcs, false);

        // cria um array de genes tamanho quantia de enderecos
        Gene[] genes = new Gene[roteiro.getItensRoteiros().size()];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = new IntegerGene(conf, 0, roteiro.getItensRoteiros().size() - 1);
            genes[i].setAllele(i);
        }

        //cria um cromosomo com os genes definidos
        Chromosome chromosome = new Chromosome(conf, genes);

        //adiciona o cromosomoa configuracao
        conf.setSampleChromosome(chromosome);

        //seta o numero da populacao 
        conf.setPopulationSize(80);

        //inicia uma populacao randomicamente apartir do cromosomo criado
        Genotype populacao = Genotype.randomInitialGenotype(conf);

        //evolui a populacao o numero maximo de vezes
        for (int i = 0; i < nMaxEvolucoes; i++) {
            populacao.evolve();
        }

        //pega a melhor solucao da populacao
        IChromosome melhor_solucao = populacao.getFittestChromosome();

        //Abre arquivo txt
        PrintWriter gravarArq = new PrintWriter(new FileOutputStream("C:\\Users\\Anderson\\Desktop\\roteiro2.txt", true), true);

        //imprime os genes da solucao
        for (Gene gene : melhor_solucao.getGenes()) {
            System.out.println(roteiro.getItensRoteiros().get(((Integer) gene.getAllele())).getDescricao());
            gravarArq.println(roteiro.getItensRoteiros().get(((Integer) gene.getAllele())).getDescricao());
        }

        Fitness f = new Fitness(roteiro);
        System.out.println("\nDistancia total a percoerer " + f.calcularDistancia(melhor_solucao) + " Km");

        gravarArq.println();
        gravarArq.println("Distancia total a percoerer " + f.calcularDistancia(melhor_solucao) + " Km");
        gravarArq.println("--------------------------------------------------------------------------");
        gravarArq.println();

        gravarArq.close();
    }

}
