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
public class Usuarios {
    private String cpf;
    private String nome;
    private Date data_nascimento;
    private String email;
    private String telefone;
    private int whats;
    private String username;
    private String senha;

    public Usuarios(String cpf, String nome, String email, String username, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = new Date(0,0,0);
        this.email = email;
        this.telefone = "";
        this.whats = 0;
        this.username = username;
        this.senha = senha;
    }

    public Usuarios(String cpf, String nome, Date data_nascimento, String email, String telefone, int whats, String username, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.username = username;
        this.senha = senha;
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
