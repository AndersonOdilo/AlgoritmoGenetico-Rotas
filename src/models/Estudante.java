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
public class Estudante extends ItemRoteiro {

    private String nome;
    private Endereco endereco;
    private int turno;

    private Escola escola;

    public Estudante() {
    }

    public Estudante(String nome, Endereco endereco, Escola escola, int turno) {
        this.nome = nome;
        this.endereco = endereco;
        this.escola = escola;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getDescricao() {
        return nome + ", " + escola.getNome();
    }

}
