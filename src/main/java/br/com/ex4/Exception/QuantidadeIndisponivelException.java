/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ex4.Exception;

/**
 *
 * @author cauel
 */
public class QuantidadeIndisponivelException extends Exception {
    
    public QuantidadeIndisponivelException() {
        super("Quantidade indisponível no estoque");
    }
}
