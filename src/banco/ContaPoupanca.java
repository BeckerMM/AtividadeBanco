package banco;

import interfaces.Imprimivel;

public class ContaPoupanca extends ContaBancaria {

    private double limite;

    public ContaPoupanca(int numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.limite >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
         if (valor> 0){
             this.setSaldo(this.getSaldo() + valor);
             return true;
         }
            return false;
    }

    @Override
    public String mostrarDados() {
        return " Número: " + getNumero() +
                "\n Saldo: " + getSaldo()
                + "\n Limite:" + this.limite;
    }

    public double getLimite() {




















        return limite;
    }
}
