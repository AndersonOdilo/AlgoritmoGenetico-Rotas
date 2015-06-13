/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Time;

/**
 *
 * @author anderson
 */
public class Turno {
    private Time entrada;
    private Time saida;
    
    private Escola escola;

    public Turno() {
    }

    public Turno(Time entrada, Time saida, Escola escola) {
        this.entrada = entrada;
        this.saida = saida;
        this.escola = escola;
    }

    public Time getEntrada() {
        return entrada;
    }

    public void setEntrada(Time entrada) {
        this.entrada = entrada;
    }

    public Time getSaida() {
        return saida;
    }

    public void setSaida(Time saida) {
        this.saida = saida;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
    
    
}
