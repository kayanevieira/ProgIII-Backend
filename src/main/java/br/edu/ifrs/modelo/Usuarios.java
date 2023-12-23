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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nxrtxn
 */
public class Usuarios {
    private String nome;
    private String data_nascimento;
    private String cpf;
    private String email;
    private String telefone;
    private byte whats;
    private String username;
    private String senha;

    public Usuarios() {
        this.nome = "";
        this.data_nascimento = "";
        this.cpf = "";
        this.email = "";
        this.telefone = "";
        this.username = "";
        this.senha = "";
    }
    
    public void inserir() throws Exception{
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("insert into usuarios(cpf,nome,data_nascimento,"
                    + "email,telefone,whats,username,senha) values (?, ?, ?, "
                    + "?, ?, ?, ?, ?)");
            
            p.setString(1, this.cpf);
            p.setString(2, this.nome);
            p.setString(3, this.data_nascimento);
            p.setString(4, this.email);
            p.setString(5, this.telefone);
            p.setInt(6, this.whats);
            p.setString(7, this.username);
            p.setString(8, this.senha);
                      
            p.execute();
        } catch(Exception e){
            throw new Exception("Falha ao executar o comando.", e);
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
            p = con.prepareStatement("update usuarios set nome = ?, data_nascimento = ? "
                    + "email = ?, telefone = ?, whats = ?, username = ?, senha = ? where cpf = ?");
                   
            
            p.setString(1, this.nome);
            p.setString(2, this.data_nascimento);
            p.setString(3, this.email);
            p.setString(4, this.telefone);
            p.setInt(5, this.whats);
            p.setString(6, this.username);
            p.setString(7, this.senha);
            p.setString(8, this.telefone);
            p.setInt(9, this.whats);
                      
            
             p.execute();
        } catch(Exception e){
            throw new Exception("Falha ao executar o comando.");
        } finally {
            if(p != null) p.close();
            if(con != null) con.close();
        }
    }
    
    public Usuarios[] selecionar() {
        Connection con = null;
        PreparedStatement p = null;
        List<Usuarios> lista = new ArrayList();
        
        try {
            con = Conexao.pegarConexao();
            p = con.prepareStatement("select * from usuarios");
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Usuarios u = new Usuarios();
                                
                u.setCpf(rs.getString("cpf"));
                u.setNome(rs.getString("nome"));
                u.setData_nascimento(rs.getString("data_nascimento"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setWhats(rs.getByte("whats"));
                u.setUsername(rs.getString("username"));
                u.setSenha(rs.getString("senha"));
                                
                lista.add(u);
            }
             
        } catch(Exception e){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista.toArray(new Usuarios[0]);
    }
    
    public void selecionarCpf() {
        Connection con = null;
        PreparedStatement p = null;
        
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("select * from usuarios where cpf = ?");
                        
            p.setString(1, this.cpf);
            
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                this.setCpf(rs.getString("cpf"));
                this.setNome(rs.getString("nome"));
                this.setData_nascimento(rs.getString("data_nascimento"));
                this.setEmail(rs.getString("email"));
                this.setTelefone(rs.getString("telefone"));
                this.setWhats(rs.getByte("whats"));
                this.setUsername(rs.getString("username"));
                this.setSenha(rs.getString("senha"));  
            }
            
            rs.close();
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir() {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("delete from usuarios where cpf = ?");
                        
            p.setString(1, this.cpf);
           
            p.execute();           
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return the data_nascimento
     */
    public String getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the whats
     */
    public int getWhats() {
        return whats;
    }

    /**
     * @param whats the whats to set
     */
    public void setWhats(byte whats) {
        this.whats = whats;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
