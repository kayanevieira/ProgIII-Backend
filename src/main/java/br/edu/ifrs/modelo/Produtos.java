/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Produtos(){
        
    }
    
    public void inserir() throws Exception{
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("insert into produtos(id, nome, descricao, "
                    + "unidade, preco_unitario) values (?, ?, ?, ?, ?)");
                        
            p.setInt(1, this.id);
            p.setString(2, this.nome);
            p.setString(3, this.descricao);
            p.setString(4, this.unidade);
            p.setFloat(5, this.preco_unitario);
            
            
            p.execute();
        } catch(Exception e){
            throw new Exception("Falha ao executar o comando.");
        } finally {
            if(p != null) p.close();
            if(con != null) con.close();
        }
        
    }
    
    public void atualizar() throws Exception {
        Connection con = null;
        PreparedStatement p = null;
        
        try {
            con = Conexao.pegarConexao();
            p = con.prepareStatement("update produtos set nome = ?, descricao = ?, unidade = ? "
                    + "preco_unitario = ? where id = ?");
            
            
            p.setString(1, this.nome);
            p.setString(2, this.descricao);
            p.setString(3, this.unidade);
            p.setFloat(4, this.preco_unitario);
            p.setInt(5, this.id);           
                      
            p.execute();
        } catch(Exception e){
            throw new Exception("Falha ao executar o comando.");
        } finally {
            if(p != null) p.close();
            if(con != null) con.close();
        }
    }
    
    public Produtos[] selecionar() {
        Connection con = null;
        PreparedStatement p = null;
        List<Produtos> lista = new ArrayList();
        
        try {
            con = Conexao.pegarConexao();
            p = con.prepareStatement("select * from produtos");
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Produtos produtos = new Produtos();
                
                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setDescricao(rs.getString("descricao"));
                produtos.setUnidade(rs.getString("unidade"));
                produtos.setPreco_unitario(rs.getFloat("preco_unitario"));
                
                
                
                
                lista.add(produtos);
            }
             
        } catch(Exception e){
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista.toArray(new Produtos[0]);
    }
    
    public void selecionarId() {
        Connection con = null;
        PreparedStatement p = null;
        
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("select * from produtos where id = ?");
                        
            p.setInt(1, this.id);
            
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                this.setId(rs.getInt("id"));
                this.setNome(rs.getString("nome"));
                this.setDescricao(rs.getString("descricao"));
                this.setUnidade(rs.getString("unidade"));
                this.setPreco_unitario(rs.getFloat("preco_unitario"));
                
            }
            
            rs.close();
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir() {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("delete from produtos where id = ?");
                        
            p.setInt(1, this.id);
           
            p.execute();           
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
