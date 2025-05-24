// Calculadora.java
public class Calculadora {
    private Tela tela;
    private Operacoes operacoes = new Operacoes();
    private double primeiroNumero = 0;
    private String operadorAtual = "";
    private boolean aguardandoSegundoNumero = false;
    private boolean operadorUsado = false;
    private boolean acClicado = false;

    public Calculadora() {
        this.tela = new Tela(this);
        tela.configurarJanela();
    }

    public void processarComando(String comando) {
        String textoVisor = tela.getVisor().getText();

        try {
            switch (comando) {
                case "0":
                    if (aguardandoSegundoNumero || operadorUsado) {
                        tela.getVisor().setText("0");
                        aguardandoSegundoNumero = false;
                        operadorUsado = false;
                    } else {
                        if (!textoVisor.equals("0")) {
                            tela.getVisor().append("0");
                        }
                    }
                    break;

                case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9": case ".":
                    if (aguardandoSegundoNumero || operadorUsado) {
                        tela.getVisor().setText("");
                        aguardandoSegundoNumero = false;
                        operadorUsado = false;
                    }
                    tela.getVisor().append(comando);
                    break;

                case "+": case "-": case "*": case "/": case "x^Y":
                    primeiroNumero = Double.parseDouble(textoVisor);
                    operadorAtual = comando;
                    aguardandoSegundoNumero = true;
                    break;

                case "=":
                    double segundoNumero = Double.parseDouble(textoVisor);
                    double resultado = 0;
                    switch (operadorAtual) {
                        case "+":
                            resultado = operacoes.adicao(primeiroNumero, segundoNumero);
                            break;
                        case "-":
                            resultado = operacoes.subtracao(primeiroNumero, segundoNumero);
                            break;
                        case "*":
                            resultado = operacoes.multiplicacao(primeiroNumero, segundoNumero);
                        ;
                        case "/":
                            resultado = operacoes.divisao(primeiroNumero, segundoNumero);
                            break;
                        case "x^Y":
                            resultado = operacoes.exponencial(primeiroNumero, segundoNumero);
                            break;
                    }
                    tela.getVisor().setText(String.valueOf(resultado));
                    operadorAtual = "";
                    aguardandoSegundoNumero = false;
                    operadorUsado = true;
                    break;

                case "AC/C":
                    if (!acClicado) {
                        tela.getVisor().setText("");
                        acClicado = true;
                    } else {
                        tela.getVisor().setText("");
                        primeiroNumero = 0;
                        operadorAtual = "";
                        aguardandoSegundoNumero = false;
                        operadorUsado = false;
                        acClicado = false;
                    }
                    break;

                case "+/-":
                    double valor = Double.parseDouble(textoVisor);
                    tela.getVisor().setText(String.valueOf(operacoes.trocaSinal(valor)));
                    break;

                case "%":
                    double val = Double.parseDouble(textoVisor);
                    tela.getVisor().setText(String.valueOf(val / 100.0));
                    break;

                case "RAIZ Q":
                    double raiz = Double.parseDouble(textoVisor);
                    tela.getVisor().setText(String.valueOf(operacoes.raiz(raiz)));
                    break;

                case "x^2":
                    double base2 = Double.parseDouble(textoVisor);
                    tela.getVisor().setText(String.valueOf(operacoes.exponecialDois(base2)));
                    break;

                case "x^3":
                    double base3 = Double.parseDouble(textoVisor);
                    tela.getVisor().setText(String.valueOf(operacoes.exponencialTres(base3)));
                    break;

                case "X!":
                    int n = Integer.parseInt(textoVisor);
                    tela.getVisor().setText(String.valueOf(operacoes.fatorial(n)));
                    break;

                case "10^X":
                    double exp = Double.parseDouble(textoVisor);
                    tela.getVisor().setText(String.valueOf(operacoes.exponencialBaseDez(exp)));
                    break;
            }
        } catch (Exception ex) {
            tela.getVisor().setText("Erro");
        }
    }
}
