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
        }

        return option;
    }

    public static void menuCliente(List<Cliente> clienteList){

    }
    public static void menuPedido(List<Cliente> clienteList, List<Pedido> pedidoList){

    }

    public static void buscarPedidos(List<Pedido> pedidoList){

    }
}
