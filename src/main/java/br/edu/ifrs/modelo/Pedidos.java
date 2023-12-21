/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Produtos produto;
    
    public Pedidos(int numero, Date data_emissao, float valor_frete, int clientes_id, Produtos produto) {
        this.numero = numero;
        this.data_emissao = data_emissao;
        this.valor_frete = valor_frete;
        this.clientes_id = clientes_id;
        this.produto = produto;
    }

    public Pedidos(int numero, Date data_emissao, float valor_frete, Date data_entrega, int clientes_id, Produtos produto) {
        this.numero = numero;
        this.data_emissao = data_emissao;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.clientes_id = clientes_id;
        this.produto = produto;
    }
    
    public Pedidos(){
        
    }
    
    public void inserir() throws Exception{
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("insert into pedidos(numero, data_emissao, valor_frete, "
                    + "data_entrega, clientes_id) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                        
            p.setInt(1, this.numero);
            p.setDate(2, this.data_emissao);
            p.setFloat(3, this.valor_frete);
            p.setDate(4, this.data_entrega);
            p.setInt(5, this.clientes_id);
            
            
            p.execute();
            
            ResultSet resultSet = p.getGeneratedKeys();
            if(resultSet.next()){
                // Inserir os produtos associados ao pedido na tabela PedidosHasProdutos
                p = con.prepareStatement("insert into produtos_has_pedidos(produtos_id, pedidos_numero, quantidade,"
                        + "preco_unitario, unidade) values (?, ?, ?, ?, ?)");

                p.setInt(1, this.produto.getId());
                p.setInt(2, this.numero);
                p.setInt(3, 1);
                p.setFloat(4,this.produto.getPreco_unitario());
                p.setString(5,this.produto.getUnidade());

                p.executeUpdate();
            }
            
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
            p = con.prepareStatement("update pedidos set numero = ?, data_emissao = ?, valor_frete = ? "
                    + "data_entrega = ?, clientes_id = ? where numero = ?");
            
            
            
            p.setDate(1, this.data_emissao);
            p.setFloat(2, this.valor_frete);
            p.setDate(3, this.data_entrega);
            p.setInt(4, this.clientes_id);
            p.setInt(5, this.numero);
            
            
             p.execute();
        } catch(Exception e){
            throw new Exception("Falha ao executar o comando.");
        } finally {
            if(p != null) p.close();
            if(con != null) con.close();
        }
    }
    
    public Pedidos[] selecionar() {
        Connection con = null;
        PreparedStatement p = null;
        List<Pedidos> lista = new ArrayList();
        
        try {
            con = Conexao.pegarConexao();
            p = con.prepareStatement("select * from pedidos");
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Pedidos pedidos = new Pedidos();
                
                pedidos.setNumero(rs.getInt("numero"));
                pedidos.setData_emissao(rs.getDate("data_emissao"));
                pedidos.setValor_frete(rs.getFloat("valor_frete"));
                pedidos.setData_entrega(rs.getDate("data_entrega"));
                pedidos.setClientes_id(rs.getInt("clientes_id"));
                
                
                
                lista.add(pedidos);
            }
             
        } catch(Exception e){
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista.toArray(new Pedidos[0]);
    }
    
    public void selecionarNumero() {
        Connection con = null;
        PreparedStatement p = null;
        
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("select * from pedidos where numero = ?");
                        
            p.setInt(1, this.numero);
            
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                this.setNumero(rs.getInt("numero"));
                this.setData_emissao(rs.getDate("data_emissao"));
                this.setValor_frete(rs.getFloat("valor_frete"));
                this.setData_entrega(rs.getDate("data_entrega"));
                this.setClientes_id(rs.getInt("clientes_id"));
                
            }
            
            rs.close();
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir() {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("delete from pedidos where numero = ?");
                        
            p.setInt(1, this.numero);
           
            p.execute();           
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
