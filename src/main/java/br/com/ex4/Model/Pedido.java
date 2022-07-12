/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cauel
 */
public class Pedido {

    private int id;
    private static int geradorID = 0;

    private List<Produto> produtos;
    private Map<Produto, Integer> produtoQuantidade;
    private int quantidadeProduto;

    public Pedido() {
        this.produtos = new ArrayList<>();
        this.produtoQuantidade = new HashMap<>();
        this.id = gerarID();
    }

    private int gerarID() {
        return ++geradorID;
    }
    
    public void addProdutoQuantidadeMap(Produto p, Integer qtd) {
        produtoQuantidade.put(p, qtd);
    }

    public Map<Produto, Integer> getProdutoQuantidade() {
        return produtoQuantidade;
    }
    
    

    public int getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public String textoFormatado() {
        String msg = "";

        for(Produto p : produtoQuantidade.keySet()) {
            msg += p.getNome() + ", quantidade: " + produtoQuantidade.get(p) + "\n";
        }

        return msg;
    }

    @Override
    public String toString() {
        return "ID do pedido: " + id + ", Produtos: \n" + textoFormatado();
    }

}
