/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import models.ItemRoteiro;
import models.Roteiro;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author anderson
 */
public class Fitness extends FitnessFunction {

    private Roteiro roteiro;

    public Fitness() {
    }
    
    public Fitness(Roteiro roteiro) {
        this.roteiro = roteiro;
    }

    @Override
    protected double evaluate(IChromosome ic) {
        double fitness;
        fitness = calcularDistancia(ic);
        return 1000000 - fitness;
    }

    public double calcularDistancia(IChromosome ic) {
        double distanciaTotal = 0;
        ItemRoteiro item1, item2;
        
        item1 = roteiro.getItensRoteiros().get((Integer) ic.getGene(0).getAllele());
        
        //calcula discancia do ponto de partida para o primeiro gene
        distanciaTotal += distance(roteiro.getPontoPartida().getEndereco().getLatitude(),
                roteiro.getPontoPartida().getEndereco().getLongitude(),
                item1.getEndereco().getLatitude(), item1.getEndereco().getLongitude());
        
        //calcula distancia de um gene ao outro
        for (int i = 1; i < ic.getGenes().length; i++) {
            item1 = roteiro.getItensRoteiros().get(((Integer) ic.getGene(i - 1).getAllele()));
            item2 = roteiro.getItensRoteiros().get(((Integer) ic.getGene(i).getAllele()));
            
            distanciaTotal += distance(item1.getEndereco().getLatitude(), item1.getEndereco().getLongitude(), 
                    item2.getEndereco().getLatitude(), item2.getEndereco().getLongitude());
        }
        item1 = roteiro.getItensRoteiros().get((Integer) ic.getGene(ic.getGenes().length - 1).getAllele());
        
        //calcula a distancia do ultimo gene para o ponto de partoda
        distanciaTotal += distance(roteiro.getPontoPartida().getEndereco().getLatitude(),
                roteiro.getPontoPartida().getEndereco().getLongitude(),
                item1.getEndereco().getLatitude(), item1.getEndereco().getLongitude());

        return distanciaTotal;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
