/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.*;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "tbl_carta")
        
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;
    @Column(name = "car_nome", nullable = false)
    private String nome;
    @Column(name = "car_ataque", nullable = false)
    private int ataque;
    @Column(name = "car_defesa", nullable = false)
    private int defesa;
    @Enumerated(EnumType.STRING)
    @Column(name = "car_categoria" , nullable = true)
    private Categoria categoria;
    @Column(name = "car_raridade", nullable = true)
    private int raridade;

    public Carta(int id, String nome, int ataque, int defesa, Categoria categoria, int raridade) {
        this.id = id;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.categoria = categoria;
        this.raridade = raridade;
    }

    public Carta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getRaridade() {
        return raridade;
    }

    public void setRaridade(int raridade) {
        this.raridade = raridade;
    }
    
    
}
