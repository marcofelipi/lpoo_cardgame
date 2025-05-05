
package controller;

import model.Tarefa;
import view.ListaTarefasView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class TarefaController {
    private List<Tarefa> tarefas;
    private ListaTarefasView listaView;

    public TarefaController() {
        tarefas = new ArrayList<>();
    }

    // Associa a view ao controlador
    public void setListaView(ListaTarefasView listaView) {
        this.listaView = listaView;
    }

    // Adiciona uma nova tarefa
    public void adicionarTarefa(String descricao, String categoria) {
        Tarefa tarefa = new Tarefa(descricao, categoria);
        tarefas.add(tarefa);
        atualizarListaView();
    }

    // Marca uma tarefa como concluída
    public void marcarTarefaComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).setConcluida(true);
            atualizarListaView();
        }
    }
    // exclui uma tarefa
    public void excluirTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice); // Remove o item da lista
            atualizarListaView();   // Atualiza a JList na View
        }
    }


    // Retorna a lista de tarefas
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    // Atualiza a visualização da lista
    private void atualizarListaView() {
        if (listaView != null) {
            listaView.atualizarListaTarefas();
        }
    }
}
