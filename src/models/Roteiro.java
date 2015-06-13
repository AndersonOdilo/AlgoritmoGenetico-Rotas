/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.List;

/**
 *
 * @author anderson
 */
public class Roteiro {
    
    private int tipo;
    
    private PontoPartida pontoPartida;
    
    private List<ItemRoteiro> itensRoteiros;

    public Roteiro() {
    }

    public Roteiro(int tipo, PontoPartida pontoPartida, List<ItemRoteiro> itensRoteiros) {
        this.tipo = tipo;
        this.pontoPartida = pontoPartida;
        this.itensRoteiros = itensRoteiros;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public PontoPartida getPontoPartida() {
        return pontoPartida;
    }

    public void setPontoPartida(PontoPartida pontoPartida) {
        this.pontoPartida = pontoPartida;
    }

    public List<ItemRoteiro> getItensRoteiros() {
        return itensRoteiros;
    }

    public void setItensRoteiros(List<ItemRoteiro> itensRoteiros) {
        this.itensRoteiros = itensRoteiros;
    }
    
    
    
}
