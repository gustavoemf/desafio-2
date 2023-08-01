package org.example;

import java.util.List;
import java.util.Scanner;

public class Function {
    static Scanner scanner = new Scanner(System.in);

    public static int menu(List<Cliente> clienteList, List<Pedido> pedidoList){
        int option;
        System.out.println("\t\tSISTEMA DE VENDAS");
        System.out.println("1 - Clientes");
        System.out.println("2 - Pedidos");
        System.out.println("3 - Sair");
        System.out.print("\nSelecione a opção desejada: ");
        option = scanner.nextInt();

        switch (option){
            case 1 -> menuCliente(clienteList);
            case 2 -> menuPedido(clienteList, pedidoList);
            case 3 -> {
                System.out.print("\nSaindo...\n");
                System.exit(0);
            }
            default -> System.out.println("\nOpção inválida, tente novamente\n");
        }

        return option;
    }

    public static void menuCliente(List<Cliente> clienteList){
        int option;
        System.out.println("\t\tCLIENTES");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Buscar");
        System.out.println("3 - Editar");
        System.out.println("4 - Voltar");
        System.out.print("\nSelecione a opção desejada: ");
        option = scanner.nextInt();

        switch (option){
            case 1 -> System.out.println("Cadastrar");
            case 2 -> System.out.println("Buscar");
            case 3 -> System.out.println("Editar");
            case 4 -> System.out.println("Voltar");
            default -> System.out.println("\nOpção inválida, tente novamente\n");
        }
    }
    public static void menuPedido(List<Cliente> clienteList, List<Pedido> pedidoList){
        int option;
        System.out.println("\t\tPEDIDOS");
        System.out.println("1 - Realizar pedido");
        System.out.println("2 - Visualizar pedidos");
        System.out.println("3 - Voltar");
        System.out.print("\nSelecione a opção desejada: ");
        option = scanner.nextInt();

        switch (option){
            case 1 -> System.out.println("Realizar pedido");
            case 2 -> System.out.println("Visualizar pedidos");
            case 3 -> System.out.println("Voltar");
            default -> System.out.println("\nOpção inválida, tente novamente\n");
        }
    }
    public static void buscarPedidos(List<Pedido> pedidoList){

    }
}
