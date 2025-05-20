import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.Font;

public class Tela extends JFrame{
    private JPanel painel;
    private JPanel painelBotoes;
    private JTextArea visor;
    private JButton[] botoes;
    private JScrollPane scrollVisor;

    public Tela(){
        painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        visor = new JTextArea(2, 25);
        scrollVisor = new JScrollPane(visor);
        painelBotoes = new JPanel(new GridLayout(5, 5, 5, 5));

        //Criação dos Botões
        botoes = new JButton[25];
        String[] botoesTexto = {
                "AC/C", "+/-", "%", "RAIZ Q", "/",
                "7", "8", "9", "x^Y", "*",
                "4", "5", "6", "x^2", "-",
                "1", "2", "3", "x^3", "+",
                "0", ".", "X!", "10^X", "="};


        for (int i = 0; i < botoes.length; i++){
            botoes[i] = new JButton(botoesTexto[i]);
            botoes[i].setBackground(Color.lightGray);
            botoes[i].setForeground(Color.black);
            botoes[i].setFont(botoes[i].getFont().deriveFont(15f));
            botoes[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(60, 60, 60), Color.DARK_GRAY));
            painelBotoes.add(botoes[i]);
        }

    }


    public void configurarJanela(){
        setVisible(true);
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
        setLocation(600,500);
        add(painel);
        configurarPainel();
    }
    public void configurarPainel(){
        painel.setBackground(new Color(30, 30, 30));

        visor.setBackground(Color.white);
        visor.setForeground(Color.black);
        visor.setLineWrap(true);
        visor.setWrapStyleWord(true);
        visor.setEditable(false);
        painelBotoes.setBackground(Color.darkGray);

        painel.add(scrollVisor, BorderLayout.NORTH);
        painel.add(painelBotoes, BorderLayout.CENTER);

    }
}
