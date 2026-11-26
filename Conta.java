import java.util.ArrayList;
import java.util.Scanner;

public abstract class Conta {
    private int numero;
    private double saldo = 0;
    private int ChavePix;
    private String senha;
    private Agencia agencia;
    private Cliente Titular;
    private static int codigo = 1000;

    Conta(int ChavePix, String senha, Agencia agencia, Cliente titular){
        this.numero = codigo;
        this.ChavePix = ChavePix;
        this.senha =senha;
        this.agencia = agencia;
        this.Titular = titular;

        codigo++;
    }
    //------------------------------------------------//
    public int getnumero(){
        return this.numero;
    }
    public synchronized double getsaldo(){
        return this.saldo;
    }

    public abstract void tipo();

    public int getChavePix(){
        return this.ChavePix;
    }

    public String getsenha(){
        return this.senha;
    }
    public Agencia getagencia(){
        return this.agencia;
    }
    public Cliente getCliente(){
        return this.Titular;
    }
    public int getcodigo(){
        return this.codigo;
    }

    synchronized void setsacar(double valordesaque){
        this.saldo = this.saldo - valordesaque;
    }
    void getconsultar_saldo(){
        System.out.println("--------------------------");
        System.out.println("Saldo: R$"+this.saldo);
    }
    void setrecarga(double valor){

        this.saldo = this.saldo - valor;
    }
    void getrecarga(){
        this.saldo = this.saldo - 20;
    }
    synchronized void setdepositar(double valordedeposito){
        this.saldo = this.saldo + valordedeposito;
    }

    protected synchronized void aplicarRendimento(double taxa){
        this.saldo += this.saldo * taxa;
    }    

    public void transferirPix(ArrayList<Conta> listaDeContas, Scanner scanner){
        System.out.println("Digite a chave Pix de destino:");
        tipo();
        int chavePixDestino = scanner.nextInt();
        
        Conta contaDestino = null;
        for (Conta conta : listaDeContas) {
            if (conta.getChavePix() == chavePixDestino) {
                contaDestino = conta;
                break;
            }
        }

        if (contaDestino == null) {
            System.out.println("Chave Pix não encontrada.");
            return;
        }

        if (contaDestino == this) {
            System.out.println("Essa chave Pix pertence à sua conta.");
            return;
        }

        System.out.println("--------------------------");
        System.out.println("Informações do receptor:");
        System.out.println("Código: " + contaDestino.getnumero());
        System.out.println("Nome: " + contaDestino.getCliente().getnome());
        System.out.print("Tipo da conta do receptor: ");
        contaDestino.tipo();
        System.out.println("Chave Pix: " + contaDestino.getChavePix());
        System.out.println("--------------------------");
        System.out.println("Digite o valor da transferência (R$):");

        double transferencia = scanner.nextDouble();
        if (transferencia > 0 && transferencia <= this.getsaldo()) {
            this.setsacar(transferencia);
            contaDestino.setdepositar(transferencia);
            System.out.println("Transferência realizada.");
        } else {
            System.out.println("Valor inválido ou saldo insuficiente.");
        }
    }

}


