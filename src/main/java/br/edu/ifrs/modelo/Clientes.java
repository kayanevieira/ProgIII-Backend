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
public class Clientes {
    private int id;
    private String nome;
    private Date data_nascimento;
    private String cpf;
    private String rg;
    private String orgao_emissor;
    private String sexo;
    private String email;
    private String telefone;
    private int whats;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Clientes(String nome, Date data_nascimento, String cpf, String sexo, String email, String telefone) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.rg = "";
        this.orgao_emissor = "";
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.cep = "";
    }

    public Clientes(int id, String nome, Date data_nascimento, String cpf, String rg, String orgao_emissor, String sexo, String email, String telefone, int whats, String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.orgao_emissor = orgao_emissor;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    public Clientes(){
        
    }
    
    public void inserir() throws Exception{
        Connection con = null;
        PreparedStatement p = null;
        
        try{
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("insert into clientes(nome, data_nascimento, cpf, "
                    + "rg, orgao_emissor, sexo, email, telefone, whats, logradouro,"
                    + "numero, bairro, cidade, estado, cep) values (?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        
            p.setString(1, this.nome);
            p.setDate(2, this.data_nascimento);
            p.setString(3, this.cpf);
            p.setString(4, this.rg);
            p.setString(5, this.orgao_emissor);
            p.setString(6, this.sexo);
            p.setString(7, this.email);
            p.setString(8, this.telefone);
            p.setInt(9, this.whats);
            p.setString(10, this.logradouro);
            p.setString(11, this.numero);
            p.setString(12, this.bairro);
            p.setString(13, this.cidade);
            p.setString(14, this.estado);
            p.setString(15, this.cep);
            
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
            p = con.prepareStatement("update clientes set nome = ?, data_nascimento = ?, cpf = ? "
                    + "rg = ?, orgao_emissor = ?, sexo = ?, email = ?, telefone = ?, whats = ?, logradouro = ?,"
                    + "numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ? where id = ?");
            
            
            p.setString(1, this.nome);
            p.setDate(2, this.data_nascimento);
            p.setString(3, this.cpf);
            p.setString(4, this.rg);
            p.setString(5, this.orgao_emissor);
            p.setString(6, this.sexo);
            p.setString(7, this.email);
            p.setString(8, this.telefone);
            p.setInt(9, this.whats);
            p.setString(10, this.logradouro);
            p.setString(11, this.numero);
            p.setString(12, this.bairro);
            p.setString(13, this.cidade);
            p.setString(14, this.estado);
            p.setString(15, this.cep);
            
            
             p.execute();
        } catch(Exception e){
            throw new Exception("Falha ao executar o comando.");
        } finally {
            if(p != null) p.close();
            if(con != null) con.close();
        }
    }
    
    public Clientes[] selecionar() {
        Connection con = null;
        PreparedStatement p = null;
        List<Clientes> lista = new ArrayList();
        
        try {
            con = Conexao.pegarConexao();
            p = con.prepareStatement("select * from clientes");
            
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Clientes c = new Clientes();
                
                c.setNome(rs.getString("nome"));
                c.setData_nascimento(rs.getDate("data_nascimento"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setOrgao_emissor(rs.getString("orgao_emissor"));
                c.setSexo(rs.getString("sexo"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setWhats(rs.getInt("whats"));
                c.setLogradouro(rs.getString("logradouro"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                c.setCep(rs.getString("cep"));
                
                lista.add(c);
            }
             
        } catch(Exception e){
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista.toArray(new Clientes[0]);
    }
    
    public void selecionarId() {
        Connection con = null;
        PreparedStatement p = null;
        
        try {
            con = Conexao.pegarConexao();
            
            p = con.prepareStatement("select * from clientes where id = ?");
                        
            p.setInt(1, this.id);
            
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                this.setNome(rs.getString("nome"));
                this.setData_nascimento(rs.getDate("data_nascimento"));
                this.setCpf(rs.getString("cpf"));
                this.setRg(rs.getString("rg"));
                this.setOrgao_emissor(rs.getString("orgao_emissor"));
                this.setSexo(rs.getString("sexo"));
                this.setEmail(rs.getString("email"));
                this.setTelefone(rs.getString("telefone"));
                this.setWhats(rs.getInt("whats"));
                this.setLogradouro(rs.getString("logradouro"));
                this.setNumero(rs.getString("numero"));
                this.setBairro(rs.getString("bairro"));
                this.setCidade(rs.getString("cidade"));
                this.setEstado(rs.getString("estado"));
                this.setCep(rs.getString("cep"));
            }
            
            rs.close();
            p.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return the data_nascimento
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the orgao_emissor
     */
    public String getOrgao_emissor() {
        return orgao_emissor;
    }

    /**
     * @param orgao_emissor the orgao_emissor to set
     */
    public void setOrgao_emissor(String orgao_emissor) {
        this.orgao_emissor = orgao_emissor;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    public void setWhats(int whats) {
        this.whats = whats;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
