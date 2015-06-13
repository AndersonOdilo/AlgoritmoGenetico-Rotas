/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author anderson
 */
public abstract class ItemRoteiro {
    
    private int posicao;
    
    private Roteiro roteiro;

    public ItemRoteiro() {
    }

    public ItemRoteiro(int posicao, Roteiro roteiro) {
        this.posicao = posicao;
        this.roteiro = roteiro;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
    }
    
    public abstract Endereco getEndereco();
    
    public abstract String getDescricao();
    
    
}
