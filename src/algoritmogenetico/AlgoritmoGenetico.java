/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

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
    public static void main(String[] args) {
        Roteiro roteiro = new Roteiro();
        roteiro.setTipo(1);

        List<ItemRoteiro> pontos = new ArrayList<>();

        Endereco endereco = new Endereco();
        endereco.setDescricao("Ponto de partida");
        endereco.setLatitude(32.9697);
        endereco.setLongitude(-96.80322);
        PontoPartida pontoPartida = new PontoPartida(endereco);
        roteiro.setPontoPartida(pontoPartida);

        Turno manha = new Turno();
        Time time = new Time(7, 0, 00);
        manha.setEntrada(time);
        time = new Time(11, 32, 00);
        manha.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Escola");
        endereco.setLatitude(28.11786);
        endereco.setLongitude(-96.88506);
        Escola escola = new Escola();
        escola.setTurno(manha);
        escola.setNome("Tancredo neves");
        escola.setEndereco(endereco);

        pontos.add(escola);

        endereco = new Endereco();
        endereco.setDescricao("Aluno");
        endereco.setLatitude(25.20786);
        endereco.setLongitude(-95.10506);
        Estudante aluno = new Estudante("Anderson", endereco, escola, 0);

        pontos.add(aluno);

        endereco = new Endereco();
        endereco.setDescricao("Aluno");
        endereco.setLatitude(29.67786);
        endereco.setLongitude(-98.99506);
        aluno = new Estudante("Odilo", endereco, escola, 0);

        pontos.add(aluno);

        manha = new Turno();
        time = new Time(7, 10, 00);
        manha.setEntrada(time);
        time = new Time(11, 34, 00);
        manha.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Escola");
        endereco.setLatitude(28.11786);
        endereco.setLongitude(-96.88506);
        escola = new Escola();
        escola.setTurno(manha);
        escola.setNome("Tancredo neves 2");
        escola.setEndereco(endereco);

        pontos.add(escola);

        endereco = new Endereco();
        endereco.setDescricao("Aluno");
        endereco.setLatitude(29.46786);
        endereco.setLongitude(-98.53506);
        aluno = new Estudante("Vasconcelos", endereco, escola, 0);

        pontos.add(aluno);

        manha = new Turno();
        time = new Time(7, 9, 00);
        manha.setEntrada(time);
        time = new Time(11, 31, 00);
        manha.setSaida(time);

        endereco = new Endereco();
        endereco.setDescricao("Escola");
        endereco.setLatitude(28.11786);
        endereco.setLongitude(-96.88506);
        escola = new Escola();
        escola.setTurno(manha);
        escola.setNome("Tancredo neves 3");
        escola.setEndereco(endereco);

        pontos.add(escola);

        endereco = new Endereco();
        endereco.setDescricao("Aluno");
        endereco.setLatitude(23.46786);
        endereco.setLongitude(-91.53506);
        aluno = new Estudante("veiga", endereco, escola, 0);

        pontos.add(aluno);

        roteiro.setItensRoteiros(pontos);

        Algoritmo algoritmo = new Algoritmo(roteiro, 800, 15);
        try {
            algoritmo.executar();
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
