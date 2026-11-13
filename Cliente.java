public class Cliente { 
    private static int codigo = 1000;
    private String nome;
    private Conta conta;

    Cliente(String nome){
        this.nome = nome;
        this.codigo = codigo;

        codigo++;
    }
    public void setConta(Conta conta){
        this.conta = conta; 
    }

    public int getcodigo(){
        return this.codigo;
    }
    public String getnome(){
        return this.nome;
    }
    public Conta getconta(){
        return this.conta;
    }
}
