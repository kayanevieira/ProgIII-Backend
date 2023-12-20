/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;

/**
 *
 * @author nxrtxn
 */
public class Produtos {
    private int id;
    private String nome;
    private String descricao;
    private String unidade;
    private float preco_unitario;

    public Produtos(String nome, String unidade, float preco_unitario) {
        this.nome = nome;
        this.descricao = "";
        this.unidade = unidade;
        this.preco_unitario = preco_unitario;
    }

    public Produtos(int id, String nome, String descricao, String unidade, float preco_unitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.preco_unitario = preco_unitario;
    }
    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    
}
