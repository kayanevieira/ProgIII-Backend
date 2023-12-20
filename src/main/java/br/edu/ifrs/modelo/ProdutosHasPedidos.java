/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;

/**
 *
 * @author nxrtxn
 */
public class ProdutosHasPedidos {
    private int produtos_id;
    private int pedidos_numero;
    private int quantidade;
    private float preco_unitario;
    private String unidade;

    public ProdutosHasPedidos(int produtos_id, int pedidos_numero, int quantidade) {
        this.produtos_id = produtos_id;
        this.pedidos_numero = pedidos_numero;
        this.quantidade = quantidade;
    }
    
    
    /**
     * @return the produtos_id
     */
    public int getProdutos_id() {
        return produtos_id;
    }

    /**
     * @param produtos_id the produtos_id to set
     */
    public void setProdutos_id(int produtos_id) {
        this.produtos_id = produtos_id;
    }

    /**
     * @return the pedidos_numero
     */
    public int getPedidos_numero() {
        return pedidos_numero;
    }

    /**
     * @param pedidos_numero the pedidos_numero to set
     */
    public void setPedidos_numero(int pedidos_numero) {
        this.pedidos_numero = pedidos_numero;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the preco_unitario
     */
    public float getPreco_unitario() {
        return preco_unitario;
    }

    /**
     * @param preco_unitario the preco_unitario to set
     */
    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
