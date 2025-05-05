
package view;

import controller.TarefaController;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marco
 */
public class AdicionarTarefaView extends JFrame {
    private final TarefaController controlador;
    private final JTextField campoDescricao;
    private final JComboBox<String> comboCategoria;

    public AdicionarTarefaView(TarefaController controlador) {
        this.controlador = controlador;
        setTitle("Adicionar Nova Tarefa");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        painel.add(new JLabel("Descrição:"));
        campoDescricao = new JTextField();
        painel.add(campoDescricao);

        painel.add(new JLabel("Categoria:"));
        String[] categorias = {"Trabalho", "Pessoal", "Estudo", "Outros"};
        comboCategoria = new JComboBox<>(categorias);
        painel.add(comboCategoria);

        JButton botaoAdicionar = new JButton("Adicionar Tarefa");
        botaoAdicionar.addActionListener(e -> adicionarTarefa());
        painel.add(botaoAdicionar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> dispose());
        painel.add(botaoCancelar);

        add(painel);
    }

    private void adicionarTarefa() {
        String descricao = campoDescricao.getText().trim();
        String categoria = (String) comboCategoria.getSelectedItem();

        if (descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A descrição não pode estar vazia.");
            return;
        }

        controlador.adicionarTarefa(descricao, categoria);
        dispose();
    }
}
