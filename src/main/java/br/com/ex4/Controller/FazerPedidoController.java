/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.Controller;

import br.com.ex4.DAO.ProdutoDAO;
import br.com.ex4.Exception.QuantidadeIndisponivelException;
import br.com.ex4.Model.Pedido;
import br.com.ex4.Model.Produto;
import br.com.ex4.View.FazerPedidoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cauel
 */
public class FazerPedidoController {

    private Pedido pedido;
    private FazerPedidoView fpv;

    public FazerPedidoController(FazerPedidoView fpv) {
        this.fpv = fpv;
        this.pedido = new Pedido();
        inicializarAcaoBotoes();
        atualizarComboBox();
    }

    public void inicializarAcaoBotoes() {
        fpv.adicionarAcaoAdicionarProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produtoSelecionado = (Produto) fpv.getProdutoSelecionado();
                int quantidadeSelecionada = (Integer) fpv.getQtd();

                try {
                    validarQuantidade(produtoSelecionado, quantidadeSelecionada);
                    adicionarProdutoNoPedido(produtoSelecionado, pedido, quantidadeSelecionada);
                    atualizarProdutoTaListagem(produtoSelecionado, quantidadeSelecionada);
                    atualizarTaTotal(pedido, quantidadeSelecionada);
                } catch (QuantidadeIndisponivelException ex) {
                    fpv.exibirMensagem(ex.getMessage());
                }
            }
        });

        fpv.adicionarAcaoFinalizarPedido(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutoDAO pDAO = new ProdutoDAO();
                
                if(!(validarProdutoNoPedido())) {
                    return;
                }
                
                for(Produto prod : pDAO.recuperarProdutos()) {
                    for(Produto p : pedido.getProdutoQuantidade().keySet()) {                 
                        if(prod.getId() == p.getId()) {
                            int qtdProdutos = pedido.getProdutoQuantidade().get(p);
                            prod.setQuantidadeEstoque(prod.getQuantidadeEstoque() - qtdProdutos);
                        }
                    }
                }
                
                fpv.exibirMensagem(pedido.toString());
                fpv.limparTela();
                
                pedido = new Pedido();
            }
        });
    }

    private boolean validarQuantidade(Produto produto, int qtd) throws QuantidadeIndisponivelException {

        if (!(produto.getQuantidadeEstoque() >= qtd) || qtd <= 0) {
            throw new QuantidadeIndisponivelException();
        }

        return true;
    }

    private void adicionarProdutoNoPedido(Produto produto, Pedido pedido, int qtd) {
        pedido.getProdutos().add(produto);
        
        pedido.getProdutoQuantidade().put(produto, qtd);
    }

    private void atualizarProdutoTaListagem(Produto p, int qtd) {
        fpv.exibirListagem(qtd + "x " + p.getNome() + "-R$" + p.getPreco() + "\n");
        
        
    }

    private boolean validarProdutoNoPedido() {
        if(pedido.getProdutos() == null) {
            fpv.exibirMensagem("Selecione um produto");
            return false;
        }
        
        return true;
    }
    
    private void atualizarTaTotal(Pedido pedido, int qtd) {
        double total = 0;

        for (Produto p : pedido.getProdutos()) {
            total += p.getPreco() * qtd;
        }

        fpv.exibirTotal(String.valueOf(total));
    }

    public void atualizarComboBox() {
        ProdutoDAO pDAO = new ProdutoDAO();

        fpv.popularComboBox(pDAO.recuperarProdutos());
    }

    public void exibirTela() {
        fpv.exibir();
    }

}
