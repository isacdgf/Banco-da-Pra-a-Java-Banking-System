public class Cliente { 
    static int codigo = 999;
    String nome;
    Conta conta;

    Cliente(String nome){
        this.nome = nome;
        this.codigo = codigo;

        codigo++;
    }
}
