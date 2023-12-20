/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.resources;

import br.edu.ifrs.modelo.Clientes;
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
@Path("Clientes")
@RequestScoped
public class ClientesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientesResource
     */
    public ClientesResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.resources.ClientesResource
     * @return an instance of java.lang.String
     */
    
    @Path("all")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        //TODO return proper representation object
        Gson g = new Gson();
        
        Clientes clientes[];
        
        try {
            Clientes c = new Clientes();
            clientes = c.selecionar();
        } catch (Exception e){
            clientes = new Clientes[0];
        }
        
        return g.toJson(clientes);
    }
    
    
    @Path("{id}")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getClienteById(@PathParam("id") int id) {
        Gson g = new Gson();
        
        Clientes c = new Clientes();
        c.setId(id);
        
        try{
            c.selecionarId();
        } catch (Exception e){
            c = new Clientes();
        }
        
        return g.toJson(c);
    }

    /**
     * PUT method for updating or creating an instance of ClientesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
