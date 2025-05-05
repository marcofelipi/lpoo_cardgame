
package view;

import controller.TarefaController;
import model.Tarefa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author marco
 */
public class ListaTarefasView extends JFrame {
    private TarefaController controlador;
    private JList<Tarefa> listaTarefas;
    private DefaultListModel<Tarefa> modeloLista;

    public ListaTarefasView(TarefaController controlador) {
        this.controlador = controlador;
        controlador.setListaView(this);
        setTitle("Gerenciador de Tarefas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar barraMenu = new JMenuBar();
        JMenu menuTarefas = new JMenu("Tarefas");
        JMenuItem itemAdicionarTarefa = new JMenuItem("Adicionar Tarefa");
        itemAdicionarTarefa.addActionListener(e -> abrirJanelaAdicionarTarefa());
        menuTarefas.add(itemAdicionarTarefa);
        barraMenu.add(menuTarefas);
        setJMenuBar(barraMenu);

        modeloLista = new DefaultListModel<>();
        listaTarefas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaTarefas);
        add(scrollPane, BorderLayout.CENTER);

        
        JPanel painelBotoes = new JPanel();
        JButton botaoAdicionar = new JButton("Adicionar Tarefa");
        botaoAdicionar.addActionListener(e -> abrirJanelaAdicionarTarefa());
        painelBotoes.add(botaoAdicionar);
        
        JButton botaoConcluir = new JButton("Marcar como Concluída");
        botaoConcluir.addActionListener(e -> marcarTarefaComoConcluida());
        painelBotoes.add(botaoConcluir);
        add(painelBotoes, BorderLayout.SOUTH);
        
        JButton botaoExcluir = new JButton("Excluir Tarefa");
        botaoExcluir.addActionListener(e -> excluirTarefaSelecionada()); 
        painelBotoes.add(botaoExcluir);

        atualizarListaTarefas();
    }

    public void atualizarListaTarefas() {
        modeloLista.clear();
        for (Tarefa tarefa : controlador.getTarefas()) {
            modeloLista.addElement(tarefa);
        }
    }

    private void abrirJanelaAdicionarTarefa() {
        new AdicionarTarefaView(controlador).setVisible(true);
    }

    private void marcarTarefaComoConcluida() {
        int indiceSelecionado = listaTarefas.getSelectedIndex();
        if (indiceSelecionado != -1) {
            controlador.marcarTarefaComoConcluida(indiceSelecionado);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para marcar como concluída.");
        }
    }
    
    private void excluirTarefaSelecionada() {
        int indiceSelecionado = listaTarefas.getSelectedIndex();
        if (indiceSelecionado != -1) {
            int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir a tarefa selecionada?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                controlador.excluirTarefa(indiceSelecionado);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para excluir.");
        }
    }
}
