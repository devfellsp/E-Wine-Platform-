package br.unitins.topicos1.ewine.service.others;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.ewine.dto.OthersDTO.MarcaDTO;
import br.unitins.topicos1.ewine.dto.OthersDTO.MarcaDTOResponse;
import br.unitins.topicos1.ewine.model.others.Marca;
import br.unitins.topicos1.ewine.repository.othersrepository.MarcaRepository; // Ajuste o pacote

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaDTOResponse create(MarcaDTO marcaDTO) {
        Marca novaMarca = new Marca();
        novaMarca.setNome(marcaDTO.nome());
        marcaRepository.persist(novaMarca);
        return MarcaDTOResponse.valueOf(novaMarca);
    }

    @Override
    @Transactional
    public MarcaDTOResponse update(Long id, MarcaDTO marcaDTO) {
        Marca marca = marcaRepository.findById(id);
        if (marca == null) {
            throw new NotFoundException("Marca não encontrada para atualização. ID: " + id);
        }
        marca.setNome(marcaDTO.nome());
        return MarcaDTOResponse.valueOf(marca);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        boolean deleted = marcaRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Marca não encontrada para exclusão. ID: " + id);
        }
    }

    @Override
    public MarcaDTOResponse findById(Long id) {
        Marca marca = marcaRepository.findById(id);
        if (marca == null) {
            throw new NotFoundException("Marca não encontrada com ID: " + id);
        }
        return MarcaDTOResponse.valueOf(marca);
    }

    @Override
    public List<MarcaDTOResponse> findAll() {
        return marcaRepository.listAll().stream()
                .map(MarcaDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<MarcaDTOResponse> findByNome(String nome) {
        return marcaRepository.findByNome(nome).stream()
                .map(MarcaDTOResponse::valueOf)
                .collect(Collectors.toList());
    }
}
