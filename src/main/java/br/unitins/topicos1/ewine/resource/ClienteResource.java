package br.unitins.topicos1.ewine.resource;

import java.util.List;

import br.unitins.topicos1.ewine.model.Cliente;
import br.unitins.topicos1.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteRepository repository;

    @GET
    public List<Cliente> buscarTodos() {
        return repository.listAll();
    }

    @GET
    @Path("/nome/{nome}")
    public List<Cliente> buscarPorNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

    @POST @Transactional public List<Cliente> incluir(Cliente cliente)
     { Cliente novoCliente = new Cliente(); novoCliente.setNome(cliente.getNome()); 
        repository.persist(novoCliente); return repository.listAll(); }
    @PUT
    @Path("/{id}") // Corrigido
    @Transactional
    public void alterar(Long id, Cliente cliente){
        Cliente edicaoCliente = repository.findById(id);
        edicaoCliente.setNome(cliente.getNome());
    }
     @DELETE
    @Path("/{id}") 
    @Transactional
    public void deletar(long id) {
        repository.deleteById(id);
        
    }
}
