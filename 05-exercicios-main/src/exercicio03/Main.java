package exercicio03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[10];
    static Scanner sc = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("[1] - Cadastrar bilhete");
            System.out.println("[2] - Recarregar bilhete");
            System.out.println("[3] - Consultar saldo");
            System.out.println("[4] - Passar na catraca");
            System.out.println("[5] - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> recarregar();
                case 3 -> consultarSaldo();
                case 4 -> passarNaCatraca();
                case 5 -> System.out.println("Até breve!");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 5);
    }

    private static void cadastrar() {
        if (index < bilhete.length) {
            System.out.println("Nome do usuário:");
            String nome = sc.next();

            System.out.println("CPF:");
            long cpf = sc.nextLong();

            System.out.println("Tipo (comum / estudante / professor):");
            String tipoTarifa = sc.next();

            bilhete[index] = new BilheteUnico(new Usuario(cpf, nome, tipoTarifa));
            index++;

            System.out.println("Bilhete cadastrado com sucesso!");
        } else {
            System.out.println("Limite de bilhetes atingido!");
        }
    }

    private static void recarregar() {
        BilheteUnico bilheteUnico = pesquisar();

        if (bilheteUnico != null) {
            System.out.println("Valor da recarga:");
            double valor = sc.nextDouble();

            bilheteUnico.carregar(valor);

            System.out.println("Novo saldo: " + bilheteUnico.saldo);
        }
    }

    private static void consultarSaldo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null) {
            System.out.println("Saldo atual R$ " +df.format(bilheteUnico.saldo) );
        }
    }

    private static void passarNaCatraca() {
        BilheteUnico bilheteUnico = pesquisar();

        if (bilheteUnico != null) {
            if (bilheteUnico.passarNaCatraca()) {
                System.out.println("Passagem liberada!");
                System.out.println("Saldo restante: " + bilheteUnico.saldo);
            } else {
                System.out.println("Saldo insuficiente!");
            }
        }
    }

    public static BilheteUnico pesquisar() {
        System.out.println("Qual o CPF para pesquisa?");
        long cpf = sc.nextLong();

        for (int i = 0; i < index; i++) {
            if (bilhete[i] != null &&
                    bilhete[i].usuario.cpf == cpf) {
                return bilhete[i];
            }
        }

        System.out.println("CPF não encontrado");
        return null;
    }
}