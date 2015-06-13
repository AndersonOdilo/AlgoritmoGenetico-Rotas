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
public class Endereco {
    
    private double latitude;
    private double longitude;
    private String nome;
    private String descricao;
    
    private Estudante estudante;
    
    private Escola escola;

    public Endereco() {
    }

    public Endereco(double latitude, double longitude, String nome, String descricao, Estudante estudante, Escola escola) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nome = nome;
        this.descricao = descricao;
        this.estudante = estudante;
        this.escola = escola;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
    
    
    
    
}
