/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.resources;

import br.edu.ifrs.modelo.Produtos;
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
 * @author norton.wolff
 */
@Path("Produtos")
@RequestScoped
public class ProdutosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutosResource
     */
    public ProdutosResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.resources.ProdutosResource
     * @return an instance of java.lang.String
     */
    @Path("all")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        //TODO return proper representation object
        Gson g = new Gson();
        
        Produtos produtos[];
        
        try {
            Produtos p = new Produtos();
            produtos = p.selecionar();
        } catch (Exception e){
            produtos = new Produtos[0];
        }
        
        return g.toJson(produtos);
    }
    
    @Path("{id}")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getPedidoById(@PathParam("id") int id) {
        Gson g = new Gson();
        
        Produtos p = new Produtos();
        p.setId(id);
        
        try{
            p.selecionarId();
        } catch (Exception e){
            p = new Produtos();
        }
        
        return g.toJson(p);
    }

    /**
     * PUT method for updating or creating an instance of ProdutosResource
     * @param content representation for the resource
     */
    @Path("inserir")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson g = new Gson();
        
        Produtos p = g.fromJson(content, Produtos.class);
        try {
            p.inserir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Path("atualizar")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        Produtos p = g.fromJson(content, Produtos.class);
        try {
            p.atualizar();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Path("excluir")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(String content) {
        Gson g = new Gson();
        
        Produtos p = g.fromJson(content, Produtos.class);
        try {
            p.excluir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
