/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Endereco;
import models.Escola;
import models.Estudante;
import models.ItemRoteiro;
import models.PontoPartida;
import models.Roteiro;
import models.Turno;
import org.jgap.InvalidConfigurationException;

/**
 *
 * @author anderson
 */
public class AlgoritmoGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Roteiro roteiro = new Roteiro();
        roteiro.setTipo(0);

        List<ItemRoteiro> pontos = new ArrayList<>();

        // Ponto de partida
        Endereco endereco = new Endereco();
        endereco.setDescricao("Ponto de partida");
        endereco.setLatitude(-26.0721902741625);
        endereco.setLongitude(-53.0387778306884);
        PontoPartida pontoPartida = new PontoPartida(endereco);
        roteiro.setPontoPartida(pontoPartida);

        
        Turno turno = new Turno();
        Time time = new Time(13, 30, 00);
        turno.setEntrada(time);
        time = new Time(17, 00, 00);
        turno.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Colégio Vida e Ensino");
        endereco.setLatitude(-26.0822311);
        endereco.setLongitude(-53.0596453);
        Escola escola = new Escola();
        escola.setTurno(turno);
        escola.setNome("Colégio Vida e Ensino");
        escola.setEndereco(endereco);

        pontos.add(escola);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Laura Meneghini Ribeiro");
        endereco.setLatitude(-26.0900245);
        endereco.setLongitude(-53.046525);
        Estudante aluno = new Estudante("Laura Meneghini Ribeiro", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Murilo Grieber Niclote");
        endereco.setLatitude(-26.0779448);
        endereco.setLongitude(-53.05199);
        aluno = new Estudante("Murilo Grieber Niclote", endereco, escola, 0);

        pontos.add(aluno);

        
        
        turno = new Turno();
        time = new Time(13, 10, 00);
        turno.setEntrada(time);
        time = new Time(17, 40, 00);
        turno.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Escola Maria Basso Dellani");
        endereco.setLatitude(-26.0753378);
        endereco.setLongitude(-53.0488986);
        escola = new Escola();
        escola.setTurno(turno);
        escola.setNome("Escola Maria Basso Dellani");
        escola.setEndereco(endereco);

        pontos.add(escola);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Ana Leticia Duda");
        endereco.setLatitude(-26.0929109);
        endereco.setLongitude(-53.0454143);
        aluno = new Estudante("Ana Leticia Duda", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Alana Becker");
        endereco.setLatitude(-26.0660256);
        endereco.setLongitude(-53.0362711);
        aluno = new Estudante("Alana Becker", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Cezar Augusto Duda");
        endereco.setLatitude(-26.0929109);
        endereco.setLongitude(-53.0454143);
        aluno = new Estudante("Cezar Augusto Duda", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Milena G. Lopes");
        endereco.setLatitude(-26.0704443);
        endereco.setLongitude(-53.0407322);
        aluno = new Estudante("Milena G. Lopes", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Aizhis Linda Boaventura Luz");
        endereco.setLatitude(-26.0967336);
        endereco.setLongitude(-53.0534838);
        aluno = new Estudante("Aizhis Linda Boaventura Luz", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Emanuelli V. Brugalli Gonçalves");
        endereco.setLatitude(-26.0764669);
        endereco.setLongitude(-53.0336043);
        aluno = new Estudante("Emanuelli V. Brugalli Gonçalves", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Bianca Fernandes Senhor");
        endereco.setLatitude(-26.0961676945385);
        endereco.setLongitude(-53.0482038179016);
        aluno = new Estudante("Bianca Fernandes Senhor", endereco, escola, 0);

        pontos.add(aluno);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Leticia Bortoli Noel");
        endereco.setLatitude(-26.0759659);
        endereco.setLongitude(-53.0244152);
        aluno = new Estudante("Leticia Bortoli Noel", endereco, escola, 0);

        pontos.add(aluno);
        
        
        
        turno = new Turno();
        time = new Time(13, 15, 00);
        turno.setEntrada(time);
        time = new Time(17, 10, 00);
        turno.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Colégio Pedro Algeri");
        endereco.setLatitude(-26.0728823);
        endereco.setLongitude(-53.0393801);
        escola = new Escola();
        escola.setTurno(turno);
        escola.setNome("Colégio Pedro Algeri");
        escola.setEndereco(endereco);

        pontos.add(escola);
        
        
        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac");
        endereco.setLatitude(-26.0759596421615);
        endereco.setLongitude(-53.0279252207184);
        aluno = new Estudante("João Augusto Budinhac", endereco, escola, 0);

        pontos.add(aluno);
        
        
        
        turno = new Turno();
        time = new Time(13, 25, 00);
        turno.setEntrada(time);
        time = new Time(17, 40, 00);
        turno.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Escola Eduardo Virmond Suplicy");
        endereco.setLatitude(-26.078588);
        endereco.setLongitude(-53.0544819);
        escola = new Escola();
        escola.setTurno(turno);
        escola.setNome("Escola Eduardo Virmond Suplicy");
        escola.setEndereco(endereco);

        pontos.add(escola);
        
        
        endereco = new Endereco();
        endereco.setDescricao("Mateus Antônio Meneghini Ribeiro");
        endereco.setLatitude(-26.0900245);
        endereco.setLongitude(-53.046525);
        aluno = new Estudante("Mateus Antônio Meneghini Ribeiro", endereco, escola, 0);

        pontos.add(aluno);
        
        
        roteiro.setItensRoteiros(pontos);

        Algoritmo algoritmo = new Algoritmo(roteiro, 190, 15);
        try {
            algoritmo.executar();
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
