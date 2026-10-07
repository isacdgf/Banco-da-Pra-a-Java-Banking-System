import java.util.ArrayList;
import java.util.Scanner;
public class main{

    static ArrayList<Conta> ListaDeContas = new ArrayList<>();
    static ArrayList<Cliente> ListaDeClientes = new ArrayList<>(); 

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void PrimeioMenu(){
        System.out.println("--------------------------");
        System.out.println("      Banco Sigmador      ");
        System.out.println("--------------------------");
        System.out.println("1.CADATRAR");
        System.out.println("2.ENTRAR");
        System.out.println("3.SAIR");
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
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String simOuNao;

        boolean SistemaAtivo = true;
        boolean repetirDeNovo = false;

        Conta conta1 = new Conta(123, 3000, "1234567");
        Cliente cliente1 = new Cliente("Isac", "123");
        //INFORMAÇÕES DA CONTA


        //IMPLEMENTAÇÃO
        cliente1.conta = conta1;

    
        //PRINTAR E SACAR
        do{
            menuPricipal();
            int escolha = scanner.nextInt();
            limparTela();

            switch (escolha) {
                case 1:
                    conta1.consultar_saldo();
                    break;
                case 2:
                    do{
                        if(conta1.saldo <= 0){
                            System.out.println("Voce não tem saldo na conta");
                            repetirDeNovo = false;
                        }
                        else{
                            conta1.consultar_saldo();

                            System.out.println("Quanto deseja sacar?");
                            int sacar = scanner.nextInt();

                            if(sacar <= 0){
                                limparTela();
                                System.out.println("Digite um valor valido");
                            }
                            else{
                                conta1.sacar(sacar);

                                limparTela();
                                conta1.consultar_saldo();

                                System.out.println("Sacar novamente?(S/N)");
                                simOuNao = scanner.next();

                                if(simOuNao.equals("S") || simOuNao.equals("s") ){
                                    repetirDeNovo = true;
                                }
                                else if(simOuNao.equals("N") || simOuNao.equals("n")){
                                    repetirDeNovo = false;
                                }
                                else{
                                    System.out.println("Erro...");
                                }
                                limparTela();
                            }
                            
                        }
                            
                    }while(repetirDeNovo);
                    break;
                case 3:
                    if(conta1.saldo <= 0){
                        System.out.println("Voce não tem saldo disponievel!!");
                    }
                    else{
                        System.out.println("Quando voce deseja recerregar?");
                        do{
                            System.out.println("[1]Recarga padrão(20R$)");
                            System.out.println("[2]Regarca customizada");
                            int padraooucustomizada = scanner.nextInt();
                            if(padraooucustomizada == 1){
                                conta1.recarga();
                                limparTela(); 
                                System.out.println("Recarga feita!!");   
                                repetirDeNovo = false;                  
                            }
                            else if(padraooucustomizada == 2){

                                System.out.println("Digite o valor da regarga(R$):");
        
                                int valor = scanner.nextInt();
                                limparTela();
                                conta1.recarga(valor);
                                System.out.println("Recarga feita!!");
                                repetirDeNovo = false;
                            }
                            else{
                                limparTela();
                                System.out.println("Digite uma opção valida!!");
                                repetirDeNovo = true;

                            }
                            
                            conta1.consultar_saldo();
                        }while (repetirDeNovo);
                    }
                    break;

                case 4:
                    do{ 
                        conta1.consultar_saldo();

                        System.out.println("Quanto deseja depositar?");
                        int deposito = scanner.nextInt();

                        if(deposito <= 0){
                            System.out.println("Digite um valor valido!!");
                            repetirDeNovo = true;

                        }
                        else{
                            conta1.depositar(deposito);
                            conta1.consultar_saldo();

                            System.out.println("Sacar novamente?(S/N)");
                            simOuNao = scanner.next();

                            if(simOuNao.equals("S") || simOuNao.equals("s") ){
                                repetirDeNovo = true;
                            }
                            else if(simOuNao.equals("N") || simOuNao.equals("n") ){
                                repetirDeNovo = false;
                            }
                            else{
                                System.out.println("Erro...");
                            }
                            limparTela();

                        }
                    }while (repetirDeNovo);    
                break;

                case 7:
                    System.out.println("Saindo...");
                    SistemaAtivo = false;



            }
                    
        }while(SistemaAtivo);
    }
}
