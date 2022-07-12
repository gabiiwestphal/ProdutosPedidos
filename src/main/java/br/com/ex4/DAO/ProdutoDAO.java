/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.DAO;

import br.com.ex4.Model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cauel
 */
public class ProdutoDAO {
    
    private static List<Produto> produtos = new ArrayList<>();
    
    public void salvarProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public List<Produto> recuperarProdutos() {
        return produtos;
    }
}
