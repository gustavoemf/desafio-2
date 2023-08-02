package org.example;

import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private Cliente cliente;
    private boolean situacao;

    public Pedido() {
    }

    public Pedido(List<Produto> produtos, Cliente cliente, boolean situacao) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.situacao = situacao;
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

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
