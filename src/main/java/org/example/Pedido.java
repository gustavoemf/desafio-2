package org.example;

import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private Cliente cliente;
    private boolean finalizado;

    public Pedido() {
    }

    public Pedido(List<Produto> produtos, Cliente cliente, boolean finalizado) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.finalizado = finalizado;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
