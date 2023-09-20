import banco.*;

import java.util.ArrayList;
import java.util.Scanner;

public class executavel {
    private static Banco banco = new Banco();
    private static Scanner sc = new Scanner(System.in);
    private static ContaBancaria contaLogada;

    public static void main(String[] args) {
        do {
            menuInicial();
        } while (true);
    }

    public static void criarConta() {
        System.out.println("""
                ===== Ecolha a conta =====
                1- Poupança
                2- Corrente
                """);
        switch (sc.nextInt()) {
            case 1 -> System.out.println(poupanca());
            case 2 -> System.out.println(corrente());
        }
    }

    private static void menuInicial() {
        System.out.println("""
                ===== Menu Inicial
                1- Criar conta
                2- Selecionar conta
                3- Remover
                4- Gerar relatório
                5- Sair""");
        switch (sc.nextInt()) {
            case 1 -> criarConta();
            case 2 -> {
                System.out.println("digite o numero da conta: ");
                int numero = sc.nextInt();
                contaLogada = banco.procurarConta(numero);
                if (contaLogada != null) {
                    selecionarConta();
                } else {
                    System.out.println("Valor não encontrado");
                }
            }
            case 3 -> {
                System.out.println("Digite o número da conta: ");
                remover(sc.nextInt());
            }
            case 4 -> System.out.println(banco.mostrarDados());
            case 5 -> System.exit(0);
        }
    }

    private static ArrayList<String> valoresComum() {
        ArrayList<String> valores = new ArrayList<>();
        System.out.println("Qual o número da conta: ");
        valores.add(sc.next());
        System.out.println("Qual o saldo da conta: ");
        valores.add(sc.next());
        return valores;
    }

    private static String poupanca() {
        ArrayList<String> valores = valoresComum();
        System.out.println("Defina o limite da conta: ");
        double limite = sc.nextDouble();
        int numero = Integer.parseInt(valores.get(0));
        double saldo = Double.parseDouble(valores.get(1));
        return banco.inserir(new ContaPoupanca(numero, saldo, limite)) ? "Conta poupança criada com sucesso!" : "Erro!";
    }

    private static String corrente() {
        ArrayList<String> valores = valoresComum();
        System.out.println("Defina a taxa de operação: ");
        double taxaDeOperacao = sc.nextDouble();
        int numero = Integer.parseInt(valores.get(0));
        double saldo = Double.parseDouble(valores.get(1));
        return banco.inserir(new ContaCorrente(numero, saldo, taxaDeOperacao)) ? "Conta corrente criada com sucesso!" : "Erro!";
    }

    private static void selecionarConta() {
        do {
            System.out.println("""
                    ===== Bem Vindo =====
                    1- Depositar
                    2- Sacar
                    3- Transferir
                    4- Gerar relatório
                    5- Retornar ao menu""");

            switch (sc.nextInt()) {
                case 1 -> depositar(valor());
                case 2 -> sacar(valor());
                case 3 -> {
                    System.out.println("Informe o número da conta: ");
                    int numero = sc.nextInt();
                    transferir(valor(), numero);
                }
                case 4 -> banco.mostrarDados();
                case 5 -> contaLogada = null;
            }
        } while (contaLogada != null);
    }

    private static double valor() {
        System.out.println("Digite o valor");
        return sc.nextDouble();
    }

    private static void depositar(double valor) {
        if (contaLogada.depositar(valor)) {
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Erro!");
        }
    }

    private static void sacar(double valor) {
        if (contaLogada.sacar(valor)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Erro!");
        }
    }

    private static void transferir(double valor, int numeroDaConta) {
        ContaBancaria contaTrasferencia = banco.procurarConta(numeroDaConta);
        if (contaTrasferencia != null) {
            if (contaLogada.trasnferir(valor, contaTrasferencia)) {
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Erro");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void gerarRelatorio() {
        System.out.println(contaLogada.mostrarDados());
    }

    private static void remover(int numero) {
        ContaBancaria contaRemover = banco.procurarConta(numero);
        if (contaRemover != null) {
            if (banco.remover(contaRemover)) {
                System.out.println("Conta removida com sucesso!");
            } else {
                System.out.println("Erro!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }
}