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

    public Tela(Calculadora calculadora){
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
            String texto = botoesTexto[i];
            botoes[i] = new JButton(texto);
            botoes[i].setBackground(Color.lightGray);
            botoes[i].setForeground(Color.black);
            botoes[i].setFont(botoes[i].getFont().deriveFont(15f));
            botoes[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(60, 60, 60), Color.DARK_GRAY));

            final String comando = texto;
            botoes[i].addActionListener(evento -> calculadora.processarComando(comando));

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
        visor.setFont(visor.getFont().deriveFont(20f));

        painelBotoes.setBackground(Color.darkGray);

        painel.add(scrollVisor, BorderLayout.NORTH);
        painel.add(painelBotoes, BorderLayout.CENTER);

    }

    public JTextArea getVisor() {
        return visor;
    }

}
