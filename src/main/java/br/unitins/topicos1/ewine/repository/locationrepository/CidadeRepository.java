package br.unitins.topicos1.ewine.repository.locationrepository;

import java.util.List;

import br.unitins.topicos1.ewine.model.locationentities.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade>{
 // Busca por nome (usando PanacheQL com LIKE)
    public List<Cidade> findByNome(String nome) {
        return find("nome like ?1", "%" + nome + "%").list();
    }

    // Método para buscar todas as cidades de um estado específico
    public List<Cidade> findByEstado(Long idEstado) {
        // Assume que a entidade Cidade tem um campo chamado 'estado'
        return find("estado.id = ?1", idEstado).list();
    }

}
