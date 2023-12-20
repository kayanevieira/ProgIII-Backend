/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.resources;

import br.edu.ifrs.modelo.Usuarios;
import com.google.gson.Gson;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author nxrtxn
 */
@Path("Usuarios")
@RequestScoped
public class UsuariosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuariosResource
     */
    public UsuariosResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.resources.UsuariosResource
     * @return an instance of java.lang.String
     */
    @Path("all")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        //TODO return proper representation object
        Gson g = new Gson();
        
        Usuarios usuarios[];
        
        try {
            Usuarios u = new Usuarios();
            usuarios = u.selecionar();
        } catch (Exception e){
            usuarios = new Usuarios[0];
        }
        
        return g.toJson(usuarios);
    }
    
    
    @Path("{cpf}")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getUsuarioByCpf(@PathParam("cpf") String cpf) {
        Gson g = new Gson();
        
        Usuarios u = new Usuarios();
        u.setCpf(cpf);
        
        try{
            u.selecionarCpf();
        } catch (Exception e){
            u = new Usuarios();
        }
        
        return g.toJson(u);
    }

    /**
     * PUT method for updating or creating an instance of ClientesResource
     * @param content representation for the resource
     */
    @Path("inserir")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson g = new Gson();
        
        Usuarios u = g.fromJson(content, Usuarios.class);
        try {
            u.inserir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Path("atualizar")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        Usuarios u = g.fromJson(content, Usuarios.class);
        try {
            u.atualizar();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Path("excluir")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(String content) {
        Gson g = new Gson();
        
        Usuarios u = g.fromJson(content, Usuarios.class);
        try {
            u.excluir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
