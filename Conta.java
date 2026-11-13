public class Conta {
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
    public double getsaldo(){
        return this.saldo;
    }
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

    void setsacar(double valordesaque){
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
    void setdepositar(double valordedeposito){
        this.saldo = this.saldo + valordedeposito;
    }

}
