package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Function {
    static Scanner scanner = new Scanner(System.in);

    public static int menu(List<Cliente> clienteList, List<Pedido> pedidoList){
        int option;
        System.out.println("\n\t\tSISTEMA DE VENDAS");
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
            default -> System.out.println("\nOpção inválida, tente novamente");
        }

        return option;
    }

    public static void menuCliente(List<Cliente> clienteList){
        int option;
        System.out.println("\n\t\tCLIENTES");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Buscar");
        System.out.println("3 - Editar");
        System.out.println("4 - Voltar");
        System.out.print("\nSelecione a opção desejada: ");
        option = scanner.nextInt();

        switch (option){
            case 1 -> {
                System.out.print("\nInsira o nome do cliente: ");
                String nomeCliente = scanner.next();
                System.out.print("Insira a quantidade de endereços do cliente: ");
                int quantEnderecos = scanner.nextInt();
                List<Endereco> enderecoList = new ArrayList<>();

                for (int i = 0; i < quantEnderecos; i++) {
                    System.out.println("Endereço " + (i + 1));
                    System.out.print("\tInsira o nome da rua: ");
                    String rua = scanner.next();
                    System.out.print("\tInsira o número da residência: ");
                    int numero = scanner.nextInt();
                    enderecoList.add(new Endereco(rua, numero));
                }
                clienteList.add(new Cliente(nomeCliente, enderecoList));
            }
            case 2 -> {
                if (clienteList.isEmpty()){
                    System.out.println("\nAinda não existem clientes cadastrados no sistema");
                } else {
                    System.out.print("\nInsira o nome do cliente que deseja buscar: ");
                    String nomeCliente = scanner.next();

                    for (Cliente cliente : clienteList) {
                        if (cliente.getNome().equals(nomeCliente)) {
                            System.out.println("\nNome: " + cliente.getNome());

                            List<Endereco> enderecoList = cliente.getEndereco();
                            System.out.println("Endereços:");
                            for (Endereco endereco : enderecoList) {
                                System.out.print("\tRua " + endereco.getRua() + ", " + endereco.getNumero() + "\n");
                            }
                        } else {
                            System.out.println("\nNão existem clientes cadastrados com esse nome");
                        }
                    }
                }
            }
            case 3 -> {
                if (clienteList.isEmpty()){
                    System.out.println("\nAinda não existem clientes cadastrados no sistema");
                } else {
                    System.out.print("\nInsira o nome do cliente que deseja editar: ");
                    String nomeCliente = scanner.next();

                    for (Cliente cliente : clienteList) {
                        if (nomeCliente.equals(cliente.getNome())) {
                            System.out.println("1 - Nome");
                            System.out.println("2 - Endereço(s)");
                            System.out.print("Selecione quais dados deseja editar: ");
                            int optionEditar = scanner.nextInt();

                            switch (optionEditar) {
                                case 1 -> {
                                    System.out.println("\n\tEdição de NOME");

                                    System.out.print("Insira o novo nome do cliente: ");
                                    String novoNome = scanner.next();

                                    cliente.setNome(novoNome);

                                    System.out.println("Sucesso!");
                                }

                                case 2 -> {
                                    System.out.println("\n\tEdição de ENDEREÇO(S)");

                                    for (int j = 0; j < cliente.getEndereco().size(); j++) {
                                        System.out.println("\t" + (j + 1) + " - Rua " + cliente.getEndereco().get(j).getRua() + ", " + cliente.getEndereco().get(j).getNumero());
                                    }
                                    System.out.print("\nSelecione qual endereço gostaria de editar: ");
                                    int endereco = scanner.nextInt();

                                    if (endereco < 1 || endereco > cliente.getEndereco().size()) {
                                        System.out.println("\nEndereço selecionado inválido, tente novamente");
                                    } else {
                                        System.out.print("Insira o novo nome da rua: ");
                                        String rua = scanner.next();

                                        System.out.print("Insira o novo número da residência: ");
                                        int numero = scanner.nextInt();

                                        cliente.getEndereco().get(endereco - 1).setRua(rua);
                                        cliente.getEndereco().get(endereco - 1).setNumero(numero);

                                        System.out.println("Sucesso!");
                                    }
                                }
                            }
                        } else {
                            System.out.println("\nNão existem clientes cadastrados com esse nome");
                        }
                    }
                }
            }
            case 4 -> {}
            default -> System.out.println("\nOpção inválida, tente novamente");
        }
    }
    public static void menuPedido(List<Cliente> clienteList, List<Pedido> pedidoList){
        int option;
        System.out.println("\n\t\tPEDIDOS");
        System.out.println("1 - Realizar pedido");
        System.out.println("2 - Visualizar pedidos");
        System.out.println("3 - Voltar");
        System.out.print("\nSelecione a opção desejada: ");
        option = scanner.nextInt();

        switch (option){
            case 1 -> {
                System.out.print("\nInsira o nome do cliente que deseja realizar o pedido: ");
                String nomeCliente = scanner.next();

                Cliente selecionado = null;
                for (Cliente cliente : clienteList) {
                    if (cliente.getNome().equals(nomeCliente)) {
                        selecionado = cliente;
                    }
                }

                if (selecionado == null) {
                    System.out.println("\nNão existem clientes cadastrados com esse nome");
                } else {
                    System.out.print("\nQual a quantidade de produtos a serem adicionados? ");
                    int quantidade = scanner.nextInt();
                    List<Produto> produtoList = new ArrayList<>();
                    for (int i = 0; i < quantidade; i++) {
                        System.out.print("Nome do produto " + (i + 1) + ": ");
                        String nomeProduto = scanner.next();

                        System.out.print("Quantidade do produto " + (i + 1) + ": ");
                        int quantidadeProduto = scanner.nextInt();

                        System.out.print("Preço do produto " + (i + 1) + ": ");
                        double preco = scanner.nextDouble();

                        produtoList.add(new Produto(nomeProduto, quantidadeProduto, preco));
                    }

                    System.out.println("\nGostaria de finalizar o pedido agora?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.print("\nSelecione a opção desejada: ");
                    boolean situacao = scanner.nextInt() == 1;

                    pedidoList.add(new Pedido(produtoList, selecionado, situacao));
                }
            }
            case 2 -> buscarPedidos(pedidoList);
            case 3 -> {}
            default -> System.out.println("\nOpção inválida, tente novamente1");
        }
    }
    public static void buscarPedidos(List<Pedido> pedidoList){

    }
}
