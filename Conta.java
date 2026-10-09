public class Conta {
    int numero;
    double saldo = 0;
    int ChavePix;
    String senha;
    Agencia agencia;
    Cliente titular;

    Conta(int numero, int ChavePix, String senha, Agencia agencia, Cliente titular){
        this.numero = numero;
        this.ChavePix = ChavePix;
        this.senha = senha;
        this.agencia = agencia;
        this.titular = titular;
        
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
