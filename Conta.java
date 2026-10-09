public class Conta {
    int numero;
    double saldo = 0;
    int ChavePix;
    String senha;
    Agencia agencia;
    Cliente titular;
    static int codigo = 1000;

    Conta(int ChavePix, String senha, Agencia agencia, Cliente titular){
        this.numero = codigo;
        this.ChavePix = ChavePix;
        this.senha =senha;
        this.agencia = agencia;
        this.titular = titular;

        codigo++;
    }

    void sacar(double valordesaque){
        this.saldo = this.saldo - valordesaque;
    }
    void consultar_saldo(){
        System.out.println("--------------------------");
        System.out.println("Saldo: R$"+this.saldo);
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
