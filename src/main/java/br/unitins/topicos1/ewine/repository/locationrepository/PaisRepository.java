package br.unitins.topicos1.ewine.repository.locationrepository;

import java.util.List;

import br.unitins.topicos1.ewine.model.locationentities.Pais;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
    
@ApplicationScoped
public class PaisRepository implements PanacheRepository<Pais> {

    public List<Pais> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}
