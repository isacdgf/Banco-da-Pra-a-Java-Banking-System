public class Conta {
    String nome;
    int numero;
    double saldo;
    String pix;
    Agencia agencia;
    Cliente titular;

    Conta(int numero, double saldo, String pix){
        this.numero = numero;
        this.saldo = saldo;
        this.pix = pix;
    }

    void sacar(double valordesaque){
        this.saldo = this.saldo - valordesaque;
    }
    void consultar_saldo(){
        System.out.println("--------------------------");
        System.out.println("Saldo: R$"+this.saldo);
        System.out.println("--------------------------");
    }
    void recarga(double valor){

        this.saldo = this.saldo - valor;
    }
    void recarga(){
        this.saldo = this.saldo - 20;
    }
    void depositar(double valordedeposito){
        this.saldo = this.saldo + valordedeposito;
    }

}
