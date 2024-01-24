import java.math.BigDecimal;
import java.util.Scanner;

public class ProjetoBanco {
        public static void main(String[] args) {

            // Dados do usuário
            System.out.println("Por favor, preencha os campos abaixo");
            Scanner leitura = new Scanner(System.in);
            System.out.print("Digite um nome: "); // nome
            String nome = leitura.nextLine();

            // Tipo de conta
            String menuTipoDeConta = """
                    Escolha o tipo de Conta
                    1. Conta Corrente
                    2. Conta Poupança
                    """;
            int opcaoTipodeConta = 0;
            while (opcaoTipodeConta != 1 && opcaoTipodeConta != 2) {
                System.out.println(menuTipoDeConta);
                opcaoTipodeConta = leitura.nextInt();
            }

            String tipoDeConta;
            if (opcaoTipodeConta == 1) {
                tipoDeConta = "Conta Corrente";
            } else if (opcaoTipodeConta == 2) {
                tipoDeConta = "Conta Poupança";
            } else tipoDeConta = "Escolha inválida";
            leitura.nextLine();

            // Valor
            System.out.print("Digite o valor da conta: ");
            BigDecimal valorConta = new BigDecimal(leitura.nextLine());

            // Situação da conta
            String situacaoConta;
            if (valorConta.compareTo(BigDecimal.ZERO) >= 0) {
                situacaoConta = "Positiva";
            } else {
                situacaoConta = "Negativa";
            }
//
//            // Visor dos dados
//            System.out.println("****************************************");
//            System.out.println("DADOS DA CONTA");
//            System.out.println("\nNome do Cliente:" + nome);
//            System.out.println("Tipo de conta: " + tipoDeConta);
//            System.out.println("O valor da sua conta é: " + valorConta);
//            System.out.println("Situação da conta: " + situacaoConta);
//            System.out.println("Tenha uma vida farta!");
//            System.out.println("****************************************");

            // Menus
            String menu = """
                    ************Digite sua Opção************
                    1 - Consultar Saldo
                    2 - Transferir Valor
                    3 - Receber Valor
                    4 - Sair
                    """;

            int opcao = 0;
            while (opcao != 4) {
                System.out.println("****************************************");
                System.out.println("DADOS DA CONTA");
                System.out.println("Nome do Cliente:" + nome);
                System.out.println("Tipo de conta: " + tipoDeConta);
                System.out.println("O valor da sua conta é: " + valorConta);
                System.out.println("Situação da conta: " + situacaoConta + "\n");
                System.out.println(menu);
                opcao = leitura.nextInt();
                if (opcao == 1) {
                    System.out.println("O saldo atualizado é " + valorConta);
                } else if (opcao == 2) {
                    System.out.println("Qual o valor que deseja transferir?");
                    BigDecimal valor = new BigDecimal(leitura.next());
                    if (valor.compareTo(valorConta) > 0) {
                        System.out.println("Não há saldo para realizar a transferência.");
                    } else {
                        valorConta = valorConta.subtract(valor);
                        System.out.println("Novo saldo: " + valorConta);
                    }
                } else if (opcao == 3) {
                    System.out.println("Valor recebido: ");
                    BigDecimal valor = new BigDecimal(leitura.next());
                    valorConta = valorConta.add(valor);
                    System.out.println("Novo saldo: " + valorConta);
                }
                if (opcao == 4) {
                    System.out.println("Obrigado por ter usado nosso sistema!");
                    System.out.println("tenha uma vida farta!");
                } else if (opcao != 4) {
                    System.out.println("Opção inválida!");
                }
            }
        }
}