import java.util.ArrayList;
import java.util.Scanner;
public class main{
    public static Scanner scanner = new Scanner(System.in);

    static ArrayList<Conta> ListaDeContas = new ArrayList<>();
    static ArrayList<Cliente> ListaDeClientes = new ArrayList<>(); 

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void PrimeiroMenu(){
        System.out.println("--------------------------");
        System.out.println("      Banco Sigmador      ");
        System.out.println("--------------------------");
        System.out.println("1.CADATRAR");
        System.out.println("2.ENTRAR");
        System.out.println("3.SAIR");
    }

    public static void criarConta(){
        //CRIAR CLIENTE
        String nome;
        int codigo;
        String senha;

        System.out.println("--------------------------");
        System.out.println("     Criando Cliente      ");
        System.out.println("--------------------------");

        while(true){
            System.out.println("Digite seu nome:");
            nome = scanner.nextLine();

            if(nome.isEmpty()){
                System.out.println("Digite um nome valido!!");
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("Digite seu codigo:");
            codigo = scanner.nextInt();

            if(codigo <= 0){
                System.out.println("Digite um valor valido!!!");
            }
            else{
                break;
            }
        }


        //CLIENTE CRIADO;

        System.out.println("---Cliente Criado---");
        System.out.println("====================");

        int numero;
        int Chavepix;


        while(true){
            System.out.println("Digite o numero da conta:");
            numero = scanner.nextInt();

            if(numero <= 0){
                System.out.println("Numero invalido!!");
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("Digite a chave pix:");
            System.out.println("(Aviso: A chave pix deve conter 5 digitos)");
            Chavepix = scanner.nextInt();

            if(Chavepix <= 0 || Chavepix < 9999 || Chavepix > 99999 ){
                System.out.println("Chave invalida!!");
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("Digite a senha:");
            senha = scanner.nextLine();

            if(senha.isEmpty()){
                System.out.println("Digite uma senha valida!!");
            }
            else{
                break;
            }

        }

        String confirmacaoSenha;

        while(true){
            System.out.println("Confirme a senha:");
            confirmacaoSenha = scanner.nextLine();

            if(senha.equals(confirmacaoSenha)){
                break;
            }
            else{
                System.out.println("Digite senhas iguais!!");
            }
        }

        Cliente NovoCliente = new Cliente(nome, codigo);
        Agencia AgenciaDoBanco = new Agencia(1234);

        Conta NovaConta = new Conta(numero, Chavepix, senha, AgenciaDoBanco, NovoCliente);


        NovoCliente.conta = NovaConta;

        ListaDeClientes.add(NovoCliente);
        ListaDeContas.add(NovaConta);

        System.out.println("Conta cadastrada!!");

    }

    public static void EntrarNaConta(){
        if(ListaDeContas.isEmpty()){
            System.out.println("Nem uma conta cadastrada!!");
            return;
        }

        System.out.println("Digite o numero da conta:");
        int numeroDeBuscaDaConta = scanner.nextInt();

        Conta contaAtual = null;

        for (int i = 0; i < ListaDeContas.size(); i++) {
            Conta conta = ListaDeContas.get(i);

            if (conta.numero == numeroDeBuscaDaConta) {
                contaAtual = conta;
                break;
            }

        }

        if(contaAtual == null){
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Digite a senha:");
        String senhaDigitada = scanner.next();

        if (!contaAtual.senha.equals(senhaDigitada)) {
            System.out.println("Senha incorreta!");
            return;
        }

        System.out.println("Login realizado com sucesso!");

        menuDaConta(contaAtual);


    }

    public static void menuPricipal(){
        System.out.println("--------------------------");
        System.out.println("      Banco Sigmador      ");
        System.out.println("--------------------------");
        System.out.println("1.CONSULTAR SALDO");
        System.out.println("2.SACAR");
        System.out.println("3.RECARGA");
        System.out.println("4.DEPOSITAR");
        System.out.println("5.TROCAR DE CONTA");
        System.out.println("6.TRANSFERENCIA");
        System.out.println("7.SAIR");
    }

    public static void menuDaConta(Conta contaAtual){
        boolean SistemaAtivo = true;

        do{
            menuPricipal();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    contaAtual.consultar_saldo();
                    break;
                case 2:
                    System.out.println("Quanto deseja sacar?");
                    int sacar = scanner.nextInt();
                    if(sacar > 0 && sacar <= contaAtual.saldo){
                        contaAtual.sacar(sacar);
                        contaAtual.consultar_saldo();
                    } else {
                        System.out.println("Valor invalido ou saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor da recarga:");
                    int valor = scanner.nextInt();
                    if(valor > 0 && valor <= contaAtual.saldo){
                        contaAtual.recarga(valor);
                        contaAtual.consultar_saldo();
                    } else {
                        System.out.println("Valor invalido ou saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.println("Quanto deseja depositar?");
                    int deposito = scanner.nextInt();
                    if(deposito > 0){
                        contaAtual.depositar(deposito);
                        contaAtual.consultar_saldo();
                    } else {
                        System.out.println("Digite um valor valido!!");
                    }
                    break;
                case 5:
                    SistemaAtivo = false;
                    break;
                case 6:
                    System.out.println("Digite o numero da conta de destino:");
                    int numeroDestino = scanner.nextInt();
                    Conta contaDestino = null;
                    for(Conta conta : ListaDeContas){
                        if(conta.numero == numeroDestino){
                            contaDestino = conta;
                            break;
                        }
                    }
                    if(contaDestino == null){
                        System.out.println("Conta de destino nao encontrada.");
                    } else {
                        System.out.println("Digite o valor da transferencia:");
                        int transferencia = scanner.nextInt();
                        if(transferencia > 0 && transferencia <= contaAtual.saldo){
                            contaAtual.sacar(transferencia);
                            contaDestino.depositar(transferencia);
                            System.out.println("Transferencia realizada.");
                        } else {
                            System.out.println("Valor invalido ou saldo insuficiente.");
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }while(SistemaAtivo);
    }
    
    public static void main(String[] args) throws Exception {
        boolean SistemaAtivo = true;

        do{
            PrimeiroMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    EntrarNaConta();
                    break;
                case 3:
                    SistemaAtivo = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opcao valida.");
            }
        }while(SistemaAtivo);
    }
}
