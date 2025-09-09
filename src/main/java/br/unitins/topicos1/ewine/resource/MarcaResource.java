package br.unitins.topicos1.ewine.resource;
import br.unitins.topicos1.ewine.model.Marca;
import br.unitins.topicos1.repository.MarcaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;



@Path("/marcas")
@Produces("application/json")
@Consumes("application/json")
public class MarcaResource {

  @Inject
    MarcaRepository repository;
  @GET
    public List<br.unitins.topicos1.ewine.model.Marca> buscarTodos() {
        return repository.listAll();
    }
  @GET
    @Path("/nome/{nome}")
    public List<br.unitins.topicos1.ewine.model.Marca> buscarPorNome(@jakarta.ws.rs.PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

  @POST @Transactional public List<Marca> incluir(Marca marca)
     { Marca novaMarca = new Marca(); novaMarca.setNome(marca.getNome()); 
        repository.persist(novaMarca); return repository.listAll(); }


}
