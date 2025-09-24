package br.unitins.topicos1.ewine.resource.location;

import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.PaisDTO;
import br.unitins.topicos1.ewine.dto.locationdto.PaisDTOResponse;
import br.unitins.topicos1.ewine.service.location.PaisService;
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

@Path("/paises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaisResource {

    @Inject
    PaisService service;

    @GET
    public List<PaisDTOResponse> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public PaisDTOResponse buscarPorId(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/find/{nome}")
    public List<PaisDTOResponse> buscarPorNome(@PathParam("nome") String nome) {
        return service.findByName(nome);
    }

    @POST
    public PaisDTOResponse incluir(PaisDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public PaisDTOResponse alterar(@PathParam("id") Long id, PaisDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id") Long id) {
        service.delete(id);
    }
}
