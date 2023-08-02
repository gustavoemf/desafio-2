package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        int option;

        do {
            option = Function.menu(clientes, pedidos);
        } while (option != 3);
    }
}