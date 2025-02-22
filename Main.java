package Restaurant;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();

        System.out.println("Mesa para quantos?");
        int clientes = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        while (true) {
            System.out.println("O que deseja fazer? (PP - pesar prato / P - pedir / F - fechar conta / A - adicionar pessoas à mesa)");
            String op = scanner.nextLine().trim(); // Remover espaços extras

            if (op.equalsIgnoreCase("PP")) { // Corrigindo para permitir "pp" minúsculo também
                System.out.println("Informe o peso do prato em kg:");
                if (scanner.hasNextDouble()) {
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consumir quebra de linha
                    check.addValorPeso(weight);
                    System.out.println("Prato pesado! Valor adicionado à conta.");
                } else {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar buffer
                }
            } 
            else if (op.equalsIgnoreCase("P")) {
                System.out.println("Deseja pedir algo? (Sobremesa / Refrigerante / Cerveja)");
                String pedido = scanner.nextLine().trim();
                
                if (pedido.equalsIgnoreCase("Sobremesa")) {
                    System.out.println("Pedido feito! Valor: R$ 6,00");
                    check.addSobremesa();
                } 
                else if (pedido.equalsIgnoreCase("Refrigerante")) {
                    System.out.println("Pedido feito! Valor: R$ 5,00");
                    check.addRefrigerante();
                } 
                else if (pedido.equalsIgnoreCase("Cerveja")) {
                    System.out.println("Pedido feito! Valor: R$ 10,00");
                    check.addCerveja();
                } 
                else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } 
            else if (op.equalsIgnoreCase("A")) {
                System.out.println("Quantas pessoas se juntaram à mesa?");
                if (scanner.hasNextInt()) {
                    int novosClientes = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha
                    clientes = check.addClientes(clientes, novosClientes);
                    System.out.println(novosClientes + " pessoas adicionadas à mesa.");
                } else {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar buffer
                }
            } 
            else if (op.equalsIgnoreCase("F")) {
                System.out.println("Valor total da conta: R$ " + check.getConta());
                System.out.println("Valor por pessoa: R$ " + check.dividirConta(clientes));
                break; // Sai do loop
            } 
            else {
                System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
        
        scanner.close();
    }
}
