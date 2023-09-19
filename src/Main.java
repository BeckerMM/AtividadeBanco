import banco.ContaBancaria;
import banco.ContaCorrente;
import banco.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente(123,1000.0,10);
        ContaPoupanca conta2 = new ContaPoupanca(1234, 10000, 100000);
        conta.depositar(100);
        System.out.println(conta.sacar(100000));
        conta2.depositar(1000);
        System.out.println(conta2.sacar(10000000));
        Relatorio relatorio = new Relatorio();

        System.out.println(relatorio.gerarRealtorio(conta));
    }
}
