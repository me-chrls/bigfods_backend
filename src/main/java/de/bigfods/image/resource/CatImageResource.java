package de.bigfods.image.resource;

import de.bigfods.image.model.Image;
import de.bigfods.image.model.MultipartBody;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/api")
public class CatImageResource {

  @Inject
  ImageService imageService;

  @GET
  @Path("cats/{id}/images")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public byte[] showImage(@PathParam("id") long id){
    return imageService.showImage(id).getData();
  }

  @POST
  @Path("cats/{catId}/images")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Image addImage(@PathParam("catId") Long catId, @MultipartForm MultipartBody body){
    return imageService.addImage(catId, body);
  }
}

/*
 Image image = imageService.showImage(id);

    URI uri = UriBuilder.fromUri("cats/" + id + "/images/" + image.id).build();

    return Response.created(uri).entity(image.getData()).build();
 */
