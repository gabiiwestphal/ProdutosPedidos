/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.Model;

/**
 *
 * @author cauel
 */
public class Produto {
    
    private int id;
    private static int geradorID = 0; 
    
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto() {
        this.id = gerarId();
    }
    
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.id = gerarId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    private static int gerarId() {
        return ++geradorID;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Nome=" + nome + "-R$" + String.format("%.2f", preco);
    }
    
    
}
