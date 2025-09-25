package br.unitins.topicos1.ewine.repository.othersrepository;

import java.util.List;

import br.unitins.topicos1.ewine.model.others.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

 @ApplicationScoped
public class MarcaRepository implements PanacheRepository <Marca> {
    public List<Marca> findByNome(String nome) {
        return find("nome like ?1", "%" + nome + "%").list();
    }
    
}
