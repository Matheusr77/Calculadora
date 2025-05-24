public class Operacoes {

    public double adicao(double a, double b){
        return a + b;
    }

    public double subtracao(double a, double b){
        return a - b;
    }

    public double multiplicacao(double a, double b){
        return a * b;
    }

    public double divisao(double a, double b){
        return a / b;
    }

    public double raiz(double a){
        return Math.sqrt(a);
    }

    public double exponencial(double base, double expoente){
        return Math.pow(base, expoente);
    }

    public double exponecialDois(double base){
        return Math.pow(base, 2);
    }

    public double exponencialTres(double base){
        return Math.pow(base, 3);
    }

    public double exponencialBaseDez(double expoente){
        return Math.pow(10, expoente);
    }

    public int fatorial(int a){
        int fatorial = 1;
        for (int i = 1; i <= a; i++){
            fatorial = fatorial * i;
        };
        return fatorial;
    }

    public double porcentagem(double a, double percentual){
        double resultado = (a * percentual) / 100;
        return a - resultado;
    }

    public double trocaSinal(double a){
        return -a;
    }
}
