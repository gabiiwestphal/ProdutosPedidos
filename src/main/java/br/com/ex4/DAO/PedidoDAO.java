/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.DAO;

import br.com.ex4.Model.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cauel
 */
public class PedidoDAO {
    
    private List<Pedido> pedidos = new ArrayList<>();
    
    public void salvarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public List<Pedido> recuperarPedidos() {
        return pedidos;
    }
}
