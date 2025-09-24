package br.unitins.topicos1.ewine.repository.locationrepository;

import java.util.List;

import br.unitins.topicos1.ewine.model.locationentities.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository <Estado> {
   
   
    public List<Estado> findByNome(String nome) {
        return find("nome like ?1", "%" + nome + "%").list();
    }

    public List<Estado> findBySigla(String sigla) {
        return find("sigla like ?1", "%" + sigla + "%").list();
    }

    public List<Estado> findByPais(Long idPais) {
        // Assume que a entidade Estado tem um campo chamado 'pais'
        return find("pais.id = ?1", idPais).list();
    }


}

