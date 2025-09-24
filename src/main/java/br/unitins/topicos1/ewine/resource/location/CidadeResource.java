package br.unitins.topicos1.ewine.resource.location;


import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTO;
import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTOResponse;
import br.unitins.topicos1.ewine.service.location.CidadeService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {

    @Inject
    CidadeService cidadeService;

    @POST
    public Response create(CidadeDTO dto) {
        CidadeDTOResponse response = cidadeService.create(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CidadeDTO dto) {
        CidadeDTOResponse response = cidadeService.update(id, dto);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        cidadeService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        CidadeDTOResponse response = cidadeService.findById(id);
        return Response.ok(response).build();
    }

    @GET
    public Response findAll() {
        List<CidadeDTOResponse> list = cidadeService.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<CidadeDTOResponse> list = cidadeService.findByNome(nome);
        return Response.ok(list).build();
    }

    @GET
    @Path("/search/estado/{idEstado}")
    public Response findByEstadoId(@PathParam("idEstado") Long idEstado) {
        List<CidadeDTOResponse> list = cidadeService.findByEstadoId(idEstado);
        return Response.ok(list).build();
    }
}
