/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.*;


/**
 *
 * @author marco
 */
@Entity
@Table(name = "tbl_carta")
public class Jogador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "level", nullable = false)
    private int level;
    private List<Carta> baralho;

    public Jogador(int id, String nickname, int level, List<Carta> baralho) {
        this.id = id;
        this.nickname = nickname;
        this.level = level;
        this.baralho = baralho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(List<Carta> baralho) {
        this.baralho = baralho;
    }
    
    
}


