package br.unitins.topicos1.ewine.service.location;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.ewine.dto.locationdto.PaisDTO;
import br.unitins.topicos1.ewine.dto.locationdto.PaisDTOResponse;
import br.unitins.topicos1.ewine.model.locationentities.Pais;
import br.unitins.topicos1.ewine.repository.locationrepository.PaisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PaisServiceImp implements PaisService {

    @Inject
    PaisRepository paisRepository;

    @Override
    @Transactional
    public PaisDTOResponse create(PaisDTO paisDTO) {
        Pais novoPais = new Pais();
        novoPais.setNome(paisDTO.nome());
        novoPais.setSigla(paisDTO.sigla());
        paisRepository.persist(novoPais);
        return PaisDTOResponse.valueOf(novoPais);
    }

    @Override
    @Transactional
    public PaisDTOResponse update(Long id, PaisDTO paisDTO) {
        Pais pais = paisRepository.findById(id);
        if (pais == null) {
            throw new NotFoundException("País não encontrado para atualização. ID: " + id);
        }

        pais.setNome(paisDTO.nome());
        pais.setSigla(paisDTO.sigla());

        return PaisDTOResponse.valueOf(pais);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        boolean deleted = paisRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("País não encontrado para exclusão. ID: " + id);
        }
    }

    @Override
    public PaisDTOResponse findById(Long id) {
        Pais pais = paisRepository.findById(id);
        if (pais == null) {
            throw new NotFoundException("País não encontrado com ID: " + id);
        }
        return PaisDTOResponse.valueOf(pais);
    }

    @Override
    public List<PaisDTOResponse> findAll() {
        return paisRepository.listAll().stream()
                .map(PaisDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaisDTOResponse> findByName(String nome) {
        return paisRepository.findByNome(nome).stream()
                .map(PaisDTOResponse::valueOf)
                .collect(Collectors.toList());
    }
}
