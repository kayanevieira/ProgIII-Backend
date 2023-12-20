/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.resources;

import br.edu.ifrs.modelo.Pedidos;
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
@Path("Pedidos")
@RequestScoped
public class PedidosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidosResource
     */
    public PedidosResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.resources.PedidosResource
     * @return an instance of java.lang.String
     */
    @Path("all")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        //TODO return proper representation object
        Gson g = new Gson();
        
        Pedidos pedidos[];
        
        try {
            Pedidos p = new Pedidos();
            pedidos = p.selecionar();
        } catch (Exception e){
            pedidos = new Pedidos[0];
        }
        
        return g.toJson(pedidos);
    }
    
    @Path("{numero}")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getPedidoByNumero(@PathParam("numero") int numero) {
        Gson g = new Gson();
        
        Pedidos p = new Pedidos();
        p.setNumero(numero);
        
        try{
            p.selecionarNumero();
        } catch (Exception e){
            p = new Pedidos();
        }
        
        return g.toJson(p);
    }

    /**
     * PUT method for updating or creating an instance of PedidosResource
     * @param content representation for the resource
     */
    @Path("inserir")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson g = new Gson();
        
        Pedidos p = g.fromJson(content, Pedidos.class);
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
        
        Pedidos p = g.fromJson(content, Pedidos.class);
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
        
        Pedidos p = g.fromJson(content, Pedidos.class);
        try {
            p.excluir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

