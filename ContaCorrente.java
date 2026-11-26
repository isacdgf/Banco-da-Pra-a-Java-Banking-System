public class ContaCorrente extends Conta {
    public ContaCorrente(int chavePix, String senha, Agencia agencia, Cliente titular) {
        super(chavePix, senha, agencia, titular);
    }

    @Override
    public void tipo() {
        System.out.println("Conta corrente");
    }
}