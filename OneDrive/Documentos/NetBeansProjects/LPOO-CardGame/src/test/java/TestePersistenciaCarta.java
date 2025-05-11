/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import control.PersistenciaJPA;
import java.util.ArrayList;
import model.Carta;
import model.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class TestePersistenciaCarta {
    
    private PersistenciaJPA jpa;

    @Before
    public void setUp() {
        jpa = new PersistenciaJPA();
        System.out.println("Iniciando teste de conexão...");
    }

    @After
    public void tearDown() {
        if (jpa != null && jpa.conexaoAberta()) {
            jpa.fecharConexao();
            System.out.println("Conexão fechada com sucesso.");
        }
    }

    @Test
    public void cadastroCartas(){
        try {
            Carta c = new Carta();
            c.setNome("Escudo Ferro");
            c.setAtaque(0);
            c.setDefesa(50);
            c.setCategoria(Categoria.ARMADURA);
            jpa.persist(c);
        } catch (Exception ex) {
            System.err.println("Erro ao persistir Carta: "+ex);   
        }
        ArrayList<Carta> listaCartas = (ArrayList)jpa.getCartas();
        if(listaCartas.isEmpty()){
            System.out.println("Não há cartas cadastradas");
        }
        for(Carta c: listaCartas){
            System.out.println(c.getNome() +"- ataque: "+c.getAtaque()+" - defesa: "+c.getDefesa());
        }
    }
}
