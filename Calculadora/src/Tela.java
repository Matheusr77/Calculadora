import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {
    private JPanel painelPrincipal;
    private JPanel painelCentro;
    private JTextArea visor;
    private JButton[] botoes;

    public Tela() {
        painelPrincipal = new JPanel(new BorderLayout());
        painelCentro = new JPanel(new GridLayout(5, 5, 5, 5));
        visor = new JTextArea(2, 20);
        botoes = new JButton[25];

        String[] textosBotoes = {
                "AC/C", "+/-", "%", "RAIZ Q", "/",
                "7", "8", "9", "x^Y", "*",
                "4", "5", "6", "x^2", "-",
                "1", "2", "3", "x^3", "+",
                "0", ".", "X!", "10^X", "="
        };

        for (int i = 0; i < botoes.length; i++) {
            botoes[i] = new JButton(textosBotoes[i]);
            painelCentro.add(botoes[i]);
        }
    }

    public void configurarJanela() {
        setTitle("Calculadora");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        configurarPainel();

        add(painelPrincipal);
        setVisible(true);
    }

    private void configurarPainel() {
        // Configurar o visor
        visor.setFont(new Font("Arial", Font.BOLD, 24));
        visor.setEditable(false);
        visor.setBackground(Color.WHITE);
        visor.setLineWrap(true);
        JScrollPane scrollVisor = new JScrollPane(visor);

        // Adiciona visor ao norte e painelCentro ao centro
        painelPrincipal.add(scrollVisor, BorderLayout.NORTH);
        painelPrincipal.add(painelCentro, BorderLayout.CENTER);
    }

}
