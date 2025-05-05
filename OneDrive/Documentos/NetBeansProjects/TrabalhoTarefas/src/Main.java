import controller.TarefaController;
import view.ListaTarefasView;
import javax.swing.*;
/**
 *
 * @author marco
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TarefaController controlador = new TarefaController();
            ListaTarefasView listaView = new ListaTarefasView(controlador);
            listaView.setVisible(true);
        });
    }
}
