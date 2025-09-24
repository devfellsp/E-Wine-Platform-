package br.unitins.topicos1.ewine.service.location;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.ewine.dto.locationdto.EstadoDTO;
import br.unitins.topicos1.ewine.dto.locationdto.EstadoDTOResponse;
import br.unitins.topicos1.ewine.model.locationentities.Estado;
import br.unitins.topicos1.ewine.model.locationentities.Pais;
import br.unitins.topicos1.ewine.repository.locationrepository.EstadoRepository;
import br.unitins.topicos1.ewine.repository.locationrepository.PaisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EstadoServiceImp implements EstadoService {
    
    @Inject
    EstadoRepository estadoRepository;

    @Inject
    PaisRepository paisRepository; 

    @Override
    @Transactional
    public EstadoDTOResponse create(EstadoDTO estadoDTO) {
        Estado novoEstado = new Estado();
        novoEstado.setNome(estadoDTO.nome());
        novoEstado.setSigla(estadoDTO.sigla());
        novoEstado.setPais(buscarPaisOuFalhar(estadoDTO.idPais()));

        estadoRepository.persist(novoEstado);
        return EstadoDTOResponse.valueOf(novoEstado);
    }

    @Override
    @Transactional
    public EstadoDTOResponse update(Long id, EstadoDTO estadoDTO) {
        Estado estado = estadoRepository.findById(id);
        if (estado == null) {
            throw new NotFoundException("Estado não encontrado para atualização. ID: " + id);
        }

        if (!estado.getPais().getId().equals(estadoDTO.idPais())) {
            estado.setPais(buscarPaisOuFalhar(estadoDTO.idPais()));
        }

        estado.setNome(estadoDTO.nome());
        estado.setSigla(estadoDTO.sigla());

        return EstadoDTOResponse.valueOf(estado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!estadoRepository.deleteById(id)) {
            throw new NotFoundException("Estado não encontrado para exclusão. ID: " + id);
        }
    }

    @Override
    public EstadoDTOResponse findById(Long id) {
        Estado estado = estadoRepository.findById(id);
        if (estado == null) {
            throw new NotFoundException("Estado não encontrado com ID: " + id);
        }
        return EstadoDTOResponse.valueOf(estado);
    }

    @Override
    public List<EstadoDTOResponse> findAll() {
        return estadoRepository.listAll().stream()
                .map(EstadoDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstadoDTOResponse> findByNome(String nome) {
        return estadoRepository.findByNome(nome).stream()
                .map(EstadoDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstadoDTOResponse> findByPaisId(Long idPais) {
        buscarPaisOuFalhar(idPais);
        return estadoRepository.findByPais(idPais).stream()
                .map(EstadoDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    // 🔹 método privado para evitar duplicação
    private Pais buscarPaisOuFalhar(Long idPais) {
        Pais pais = paisRepository.findById(idPais);
        if (pais == null) {
            throw new NotFoundException("País não encontrado para o ID: " + idPais);
        }
        return pais;
    }
}
