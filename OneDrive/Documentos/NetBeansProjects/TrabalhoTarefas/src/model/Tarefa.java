/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author marco
 */
public class Tarefa {
    private String descricao;
    private String categoria;
    private boolean concluida;

    public Tarefa(String descricao, String categoria) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return descricao + " (" + categoria + ")" + (concluida ? "   ---   [TAREFA CONCLUÍDA]" : "");
    }
}
