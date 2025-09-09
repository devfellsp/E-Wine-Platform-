package br.unitins.topicos1.repository;

import br.unitins.topicos1.ewine.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public List<Cliente> findByNome(String nome) {
           return find("SELECT a FROM Aluno a WHERE a.nome LIKE ?1 ", "%"+nome+"%").list();
   
        }

    }