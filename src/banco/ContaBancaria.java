package banco;

import interfaces.Imprimivel;

public abstract class ContaBancaria implements Imprimivel {
    private int numero;
    private double saldo;

    public ContaBancaria(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public abstract boolean sacar(double valor);

    public abstract boolean depositar(double valor);

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean trasnferir(double valor, ContaBancaria conta) {
        if (this instanceof ContaPoupanca) {
            if (valor <= ((ContaPoupanca) this).getLimite()) {
                this.sacar(valor);
                conta.depositar(valor);
                return true;
            }
            return false;
        } else {
            if (valor <= this.saldo) {
                if (this.sacar(valor)) {
                    conta.depositar(valor);
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}

