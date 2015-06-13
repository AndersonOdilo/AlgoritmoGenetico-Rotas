/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Escola;
import models.Estudante;
import models.ItemRoteiro;
import models.Roteiro;
import org.jgap.Gene;
import org.jgap.GeneticOperator;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;

/**
 *
 * @author anderson
 */
public class OperadorGenetico implements GeneticOperator {

    Roteiro roteiro;

    public OperadorGenetico(Roteiro roteiro) {
        this.roteiro = roteiro;
    }

    @Override
    public void operate(Population pltn, List list) {
        IChromosome chromosome;
        for (int i = 0; i < pltn.getChromosomes().size(); i++) {
            chromosome = pltn.getChromosome(i);
            if (roteiro.getTipo() == 1) {
                pltn.setChromosome(i, ordenarEscolasHorarioEntrada(chromosome));
                pltn.setChromosome(i, ordenarEstudantesHorarioEntrada(chromosome));
            } else {
                pltn.setChromosome(i, ordenarEscolasHorarioSaida(chromosome));
                pltn.setChromosome(i, ordenarEstudantesHorarioSaida(chromosome));
            }
        }
    }

    public IChromosome ordenarEscolasHorarioEntrada(IChromosome iChromosome) {
        int oldPosition;
        ItemRoteiro item;
        Escola escolaAtual, escola;
        Gene old;
        Gene[] genes = iChromosome.getGenes();
        for (int i = 0; i < genes.length; i++) {
            item = roteiro.getItensRoteiros().get((Integer) genes[i].getAllele());
            if (item instanceof Escola) {
                escolaAtual = (Escola) item;
                oldPosition = -1;
                for (int j = 0; j <= i; j++) {
                    item = roteiro.getItensRoteiros().get((Integer) genes[j].getAllele());
                    if (item instanceof Escola) {
                        escola = (Escola) item;
                        if (!escolaAtual.equals(escola)) {
                            if (escolaAtual.getTurno().getEntrada().getTime() < escola.getTurno().getEntrada().getTime()) {
                                oldPosition = j;
                                break;
                            }
                        }
                    }
                }
                if (oldPosition > -1 && oldPosition < i) {
                    old = genes[i];
                    genes[i] = genes[oldPosition];
                    genes[oldPosition] = old;
                }
            }
        }
        try {
            iChromosome.setGenes(genes);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(OperadorGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iChromosome;
    }

    public IChromosome ordenarEstudantesHorarioEntrada(IChromosome iChromosome) {
        int newPosition = -2;
        ItemRoteiro item;
        Escola escola;
        Estudante estudante;
        Gene old;
        Gene[] genes = iChromosome.getGenes();
        for (int i = 0; i < genes.length; i++) {
            item = roteiro.getItensRoteiros().get((Integer) genes[i].getAllele());
            if (item instanceof Estudante) {
                estudante = (Estudante) item;
                newPosition = -2;
                for (int j = i - 1; j >= 0; j--) {
                    item = roteiro.getItensRoteiros().get((Integer) genes[j].getAllele());
                    if (item instanceof Escola) {
                        escola = (Escola) item;
                        if (estudante.getEscola().getNome().equals(escola.getNome())) {
                            newPosition = j - 1;
                            break;
                        }
                    }
                }
                if (newPosition > -2) {
                    if (newPosition == -1) {
                        old = genes[0];
                        genes[0] = genes[i];
                        for (int j = i; j >= newPosition + 2; j--) {
                            genes[j] = genes[j - 1];
                        }
                        genes[newPosition + 2] = old;
                    } else {
                        old = genes[newPosition];
                        genes[newPosition] = genes[i];
                        for (int j = i; j >= newPosition + 1; j--) {
                            genes[j] = genes[j - 1];
                        }
                        genes[newPosition + 1] = old;
                    }

                }
            }
        }
        try {
            iChromosome.setGenes(genes);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(OperadorGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iChromosome;
    }

    public IChromosome ordenarEscolasHorarioSaida(IChromosome iChromosome) {
        ItemRoteiro item;
        Escola escolaAtual, escola;
        Gene old;
        Gene[] genes = iChromosome.getGenes();
        for (int i = 0; i < genes.length; i++) {
            item = roteiro.getItensRoteiros().get((Integer) genes[i].getAllele());
            if (item instanceof Escola) {
                escolaAtual = (Escola) item;
                int oldPosition = -1;
                for (int j = 0; j <= i; j++) {
                    item = roteiro.getItensRoteiros().get((Integer) genes[j].getAllele());
                    if (item instanceof Escola) {
                        escola = (Escola) item;
                        if (!escolaAtual.equals(escola)) {
                            if (escolaAtual.getTurno().getSaida().getTime() < escola.getTurno().getSaida().getTime()) {
                                oldPosition = j;
                                break;
                            }
                        }
                    }
                }
                if (oldPosition > -1 && oldPosition < i) {
                    old = genes[i];
                    genes[i] = genes[oldPosition];
                    genes[oldPosition] = old;
                }
            }
        }
        try {
            iChromosome.setGenes(genes);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(OperadorGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iChromosome;
    }

    public IChromosome ordenarEstudantesHorarioSaida(IChromosome iChromosome) {
        int newPosition = -1;
        ItemRoteiro item;
        Escola escola;
        Estudante estudante;
        Gene old;
        Gene[] genes = iChromosome.getGenes();
        for (int i = 0; i < genes.length; i++) {
            item = roteiro.getItensRoteiros().get((Integer) genes[i].getAllele());
            if (item instanceof Estudante) {
                estudante = (Estudante) item;
                newPosition = -1;
                for (int j = i + 1; j < genes.length; j++) {
                    item = roteiro.getItensRoteiros().get((Integer) genes[j].getAllele());
                    if (item instanceof Escola) {
                        escola = (Escola) item;
                        if (estudante.getEscola().getNome().equals(escola.getNome())) {
                            newPosition = j + 1;
                            break;
                        }
                    }
                }
                if (newPosition > -1) {
                    if (newPosition == genes.length) {
                        old = genes[genes.length -1];
                        genes[genes.length -1] = genes[i];
                        for (int j = i; j <= newPosition -2; j++) {
                            genes[j] = genes[j + 1];
                        }
                        genes[newPosition - 2] = old;
                    } else {
                        old = genes[newPosition];
                        genes[newPosition] = genes[i];
                        for (int j = i; j <= newPosition - 1; j++) {
                            genes[j] = genes[j + 1];
                        }
                        genes[newPosition - 1] = old;
                    }

                }
            }
        }
        try {
            iChromosome.setGenes(genes);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(OperadorGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iChromosome;
    }

}
