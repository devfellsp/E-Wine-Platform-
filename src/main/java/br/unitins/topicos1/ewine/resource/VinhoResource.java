package br.unitins.topicos1.ewine.resource;

import java.util.List;
import br.unitins.topicos1.ewine.model.Vinho;
import br.unitins.topicos1.repository.VinhoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/vinhos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VinhoResource {

    @Inject
    VinhoRepository repository;

    @GET
    public List<Vinho> buscarTodos() {
        return repository.listAll();
    }

    @GET
    @Path("/find/{nome}")
    public List<Vinho> buscarPorNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

    @POST
    @Transactional
    public Vinho incluir(Vinho vinho) {
        repository.persist(vinho);
        return vinho;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void alterar(@PathParam("id") Long id, Vinho vinho) {
        Vinho edicaoVinho = repository.findById(id);
        if (edicaoVinho != null) {
            edicaoVinho.setNome(vinho.getNome());
            edicaoVinho.setTipo(vinho.getTipo());
            edicaoVinho.setSafra(vinho.getSafra());
            edicaoVinho.setPais(vinho.getPais());
            edicaoVinho.setUva(vinho.getUva());
            edicaoVinho.setPreco(vinho.getPreco());
            edicaoVinho.setQuantEstoque(vinho.getQuantEstoque());
            edicaoVinho.setDescricao(vinho.getDescricao());
            edicaoVinho.setImagem(vinho.getImagem());
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}