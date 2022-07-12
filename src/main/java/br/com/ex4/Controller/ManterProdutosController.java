/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.Controller;

import br.com.ex4.DAO.ProdutoDAO;
import br.com.ex4.Model.Produto;
import br.com.ex4.View.ManterProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cauel
 */
public class ManterProdutosController {
    
    private Produto produto;
    private ManterProdutoView mpv;

    public ManterProdutosController(ManterProdutoView mpv) {
        this.mpv = mpv;
        inicializarAcaoBotoes();
    }
    
    public void inicializarAcaoBotoes() {
        mpv.adicionarAcaoBotaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto p = recuperarProduto();
                
                salvarProduto(p);
                
                atualizarDadosNaTela();
            }
        });
        
        mpv.adicionarAcaoLimparTela(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mpv.exibirListagem("");
            }
        });
    }
    
    public void salvarProduto(Produto p) {
        ProdutoDAO pDAO = new ProdutoDAO();
        
        pDAO.salvarProduto(p);
    }
    
    public Produto recuperarProduto() {
        Produto p = new Produto(); 
           
        p.setNome(mpv.getNome());
        p.setPreco(mpv.getPreco());
        p.setQuantidadeEstoque(mpv.getQtd());
        
        return p;
    }
    
    public void atualizarDadosNaTela() {
        ProdutoDAO pDAO = new ProdutoDAO();
        String msg = "";
        
        for(Produto p : pDAO.recuperarProdutos()) {
            msg += p.toString() + "\n";
        }
        
         mpv.exibirListagem(msg);
    }
    
    public void exibirTela() {
        mpv.exibir();
    }
}
