package banco;

import interfaces.Imprimivel;

import java.util.ArrayList;

public class Banco  implements Imprimivel {
    private ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();


    public boolean inserir(ContaBancaria conta ){
        return this.contasBancarias.add(conta);
    }
    public boolean remover(ContaBancaria conta){
        return this.contasBancarias.remove(conta);
    }
    public ContaBancaria procurarConta(int numeroDaConta){
        for (ContaBancaria conta: this.contasBancarias) {
            if (numeroDaConta == conta.getNumero()){
                return conta;
            }
        }
        return null;
    }

    @Override
    public String mostrarDados() {
        String contas = "";
        for (ContaBancaria conta : this.contasBancarias) {
            contas += "\n" + conta.mostrarDados();
        }
        return contas;
    }
}
