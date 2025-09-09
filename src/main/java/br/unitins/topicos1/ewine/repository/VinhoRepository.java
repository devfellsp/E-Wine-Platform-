package br.unitins.topicos1.repository;
import java.util.List;
import br.unitins.topicos1.ewine.model.Vinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VinhoRepository implements PanacheRepository<Vinho> {

    public List<Vinho> findByNome(String nome) {
        return find("SELECT v FROM Vinho v WHERE v.nome LIKE ?1", "%" + nome + "%").list();
    }
}