package br.unitins.topicos1.ewine.resource.outros;

import java.util.List;

import br.unitins.topicos1.ewine.dto.OthersDTO.MarcaDTO;
import br.unitins.topicos1.ewine.dto.OthersDTO.MarcaDTOResponse;
import br.unitins.topicos1.ewine.service.others.MarcaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/marcas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService service;

    // POST /marcas
    @POST
    public Response create(MarcaDTO dto) {
        MarcaDTOResponse response = service.create(dto);
        // Retorna 201 Created
        return Response.status(Status.CREATED).entity(response).build();
    }

    // PUT /marcas/{id}
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MarcaDTO dto) {
        MarcaDTOResponse response = service.update(id, dto);
        // Retorna 200 OK
        return Response.ok(response).build();
    }

    // DELETE /marcas/{id}
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        // Retorna 204 No Content
        return Response.noContent().build();
    }

    // GET /marcas/{id}
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        MarcaDTOResponse response = service.findById(id);
        // Retorna 200 OK
        return Response.ok(response).build();
    }

    // GET /marcas
    @GET
    public List<MarcaDTOResponse> findAll() {
        return service.findAll();
    }

    // GET /marcas/search/nome/{nome}
    @GET
    @Path("/search/nome/{nome}")
    public List<MarcaDTOResponse> findByNome(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }
}