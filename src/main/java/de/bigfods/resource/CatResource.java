package de.bigfods.resource;

import de.bigfods.data.Cat;
import de.bigfods.repository.CatRepository;
import de.bigfods.service.CatService;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class CatResource {

    @Inject
    CatService catService;


    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(){
        return "hello";
    }


    @GET
    @Path("/cats")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cat> showCats(){
        return catService.showCats();
    }

    @GET
    @Path("/cat/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cat showCats(@PathParam("id") long id){
        System.out.println("Ich werde ausgeführt");
        return catService.showCat(id);
    }

    @POST
    @Path("/cat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cat addCat(Cat cat){
        return catService.addCat(cat);
    }

    @Path("cat/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cat updateCat(@PathParam("id") Long id, Cat cat){
        return catService.updateCat(id, cat);
    }

    @Path("cat/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public boolean deleteCat(@PathParam("id") Long id){
        return catService.deleteCat(id);
    }
}