/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;
import java.sql.Date;

/**
 *
 * @author nxrtxn
 */
public class Pedidos {
    private int numero;
    private Date data_emissao;
    private float valor_frete;
    private Date data_entrega;
    private int clientes_id;

    public Pedidos(int numero, Date data_emissao, float valor_frete, int clientes_id) {
        this.numero = numero;
        this.data_emissao = data_emissao;
        this.valor_frete = valor_frete;
        this.clientes_id = clientes_id;
    }

    public Pedidos(int numero, Date data_emissao, float valor_frete, Date data_entrega, int clientes_id) {
        this.numero = numero;
        this.data_emissao = data_emissao;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.clientes_id = clientes_id;
    }
    
    
    

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the data_emissao
     */
    public Date getData_emissao() {
        return data_emissao;
    }

    /**
     * @param data_emissao the data_emissao to set
     */
    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    /**
     * @return the valor_frete
     */
    public float getValor_frete() {
        return valor_frete;
    }

    /**
     * @param valor_frete the valor_frete to set
     */
    public void setValor_frete(float valor_frete) {
        this.valor_frete = valor_frete;
    }

    /**
     * @return the data_entrega
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * @return the clientes_id
     */
    public int getClientes_id() {
        return clientes_id;
    }

    /**
     * @param clientes_id the clientes_id to set
     */
    public void setClientes_id(int clientes_id) {
        this.clientes_id = clientes_id;
    }
}
