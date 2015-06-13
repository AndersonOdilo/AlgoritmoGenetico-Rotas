/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Time;
import java.util.List;

/**
 *
 * @author anderson
 */
public class Escola extends ItemRoteiro {
    
    private String nome;
    private Endereco endereco;

    private Turno turno;

    public Escola() {
    }

    public Escola(String nome, Endereco endereco, Turno turno) {
        this.nome = nome;
        this.endereco = endereco;
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

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getDescricao() {
        return nome;
    }

}
