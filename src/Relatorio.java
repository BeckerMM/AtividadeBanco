import banco.ContaBancaria;

public class Relatorio {

    public String gerarRealtorio(ContaBancaria conta ){
        return conta.mostrarDados();
    }
}
