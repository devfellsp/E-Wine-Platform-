package br.unitins.topicos1.ewine.resource.location;

import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTO;
import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTOResponse;
import br.unitins.topicos1.ewine.service.location.CidadeService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/cidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {

    @Inject
    CidadeService cidadeService;

    @POST
    public CidadeDTOResponse create(CidadeDTO dto) {
        return cidadeService.create(dto);
    }

    @PUT
    @Path("/{id}")
    public CidadeDTOResponse update(@PathParam("id") Long id, CidadeDTO dto) {
        return cidadeService.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        cidadeService.delete(id);
    }

    @GET
    @Path("/{id}")
    public CidadeDTOResponse findById(@PathParam("id") Long id) {
        return cidadeService.findById(id);
    }

    @GET
    public List<CidadeDTOResponse> findAll() {
        return cidadeService.findAll();
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<CidadeDTOResponse> findByNome(@PathParam("nome") String nome) {
        return cidadeService.findByNome(nome);
    }

    @GET
    @Path("/search/estado/{idEstado}")
    public List<CidadeDTOResponse> findByEstadoId(@PathParam("idEstado") Long idEstado) {
        return cidadeService.findByEstadoId(idEstado);
    }
}
