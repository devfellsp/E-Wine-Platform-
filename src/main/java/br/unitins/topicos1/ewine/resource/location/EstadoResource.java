package br.unitins.topicos1.ewine.resource.location;


import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.EstadoDTO;
import br.unitins.topicos1.ewine.dto.locationdto.EstadoDTOResponse;
import br.unitins.topicos1.ewine.service.location.EstadoService;

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

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService service;

    @GET
    public List<EstadoDTOResponse> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public EstadoDTOResponse buscarPorId(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/find/{nome}")
    public List<EstadoDTOResponse> buscarPorNome(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @GET
    @Path("/pais/{idPais}")
    public List<EstadoDTOResponse> buscarPorPais(@PathParam("idPais") Long idPais) {
        return service.findByPaisId(idPais);
    }

    @POST
    public EstadoDTOResponse incluir(EstadoDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public EstadoDTOResponse alterar(@PathParam("id") Long id, EstadoDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id") Long id) {
        service.delete(id);
    }
}
