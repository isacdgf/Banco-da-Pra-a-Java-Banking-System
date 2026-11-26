import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ContaPoupanca extends Conta {
    // Taxa demonstrativa: 1% por minuto.
    private static final double TAXA_RENDIMENTO_POR_MINUTO = 0.01;
    private static final ScheduledExecutorService ATUALIZADOR =
        Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "atualizador-poupanca");
            thread.setDaemon(true);
            return thread;
        });

    public ContaPoupanca(int chavePix, String senha, Agencia agencia, Cliente titular) {
        super(chavePix, senha, agencia, titular);
        ATUALIZADOR.scheduleAtFixedRate(
            () -> aplicarRendimento(TAXA_RENDIMENTO_POR_MINUTO),
            1,
            1,
            TimeUnit.MINUTES
        );
    }

    @Override
    public void tipo() {
        System.out.println("Conta poupança");
    }
}