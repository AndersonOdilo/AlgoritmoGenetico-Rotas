/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import models.Roteiro;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
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

    public void executar() throws InvalidConfigurationException {

        //inicia configuração do algoritimo padrao
        Configuration conf = new DefaultConfiguration();

        //Seta operador genetico criado
        OperadorGenetico operador = new OperadorGenetico(roteiro);
        conf.addGeneticOperator(operador);

        //cria objeto fitness
        FitnessFunction fitness = new Fitness(roteiro);

        // seta a classe de fitness na configuracao
        conf.setFitnessFunction(fitness);

        // cria um array de genes tamanho quantia de enderecos
        Gene[] genes = new Gene[roteiro.getItensRoteiros().size()];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = new IntegerGene(conf, i, i);
        }

        //cria um cromosomo com os genes definidos
        Chromosome chromosome = new Chromosome(conf, genes);

        //adiciona o cromosomoa configuracao
        conf.setSampleChromosome(chromosome);

        //seta o numero da populacao 
        conf.setPopulationSize(60);

        //inicia uma populacao randomicamente apartir do cromosomo criado
        Genotype populacao = Genotype.randomInitialGenotype(conf);

        //evolui a populacao o numero maximo de vezes
        for (int i = 0; i < nMaxEvolucoes; i++) {
            populacao.evolve();
        }

        //pega a melhor solucao da populacao
        IChromosome melhor_solucao = populacao.getFittestChromosome();

        //imprime os genes da solucao
        for (Gene gene : melhor_solucao.getGenes()) {
            System.out.println(gene);
            System.out.println(roteiro.getItensRoteiros().get(((Integer) gene.getAllele())).getDescricao());
        }
    }

}
