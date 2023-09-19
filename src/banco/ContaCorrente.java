package banco;

import interfaces.Imprimivel;

public class ContaCorrente extends ContaBancaria {
    private double taxaDeOperacao;

    public ContaCorrente(int numero, double saldo, double taxaDeOperacao) {
        super(numero, saldo);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor + (valor * this.taxaDeOperacao)) {
            this.setSaldo(this.getSaldo() - valor - (valor * this.taxaDeOperacao));
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor - (valor * this.taxaDeOperacao));
            return true;
        }
        return false;
    }

    @Override
    public String mostrarDados() {
        return "Número: " + getNumero()
                + "Saldo: " + getSaldo()
                + "Taxa de operação: " + this.taxaDeOperacao;
    }
}
