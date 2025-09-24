package br.unitins.topicos1.ewine.service.location;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTO;
import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTOResponse;
import br.unitins.topicos1.ewine.model.locationentities.Cidade;
import br.unitins.topicos1.ewine.model.locationentities.Estado;
import br.unitins.topicos1.ewine.repository.locationrepository.CidadeRepository;
import br.unitins.topicos1.ewine.repository.locationrepository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;




@ApplicationScoped
public class CidadeServiceImp implements CidadeService {
    
    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Override
    @Transactional
    public CidadeDTOResponse create(CidadeDTO cidadeDTO) {
        validarNome(cidadeDTO.nome());

        Cidade novaCidade = new Cidade();
        novaCidade.setNome(cidadeDTO.nome());
        novaCidade.setEstado(validarEstado(cidadeDTO.idEstado()));
        
        cidadeRepository.persist(novaCidade);
        return CidadeDTOResponse.valueOf(novaCidade);
    }

    @Override
    @Transactional
    public CidadeDTOResponse update(Long id, CidadeDTO cidadeDTO) {
        Cidade cidade = cidadeRepository.findById(id);
        if (cidade == null) {
            throw new NotFoundException("Cidade não encontrada para atualização. ID: " + id);
        }

        validarNome(cidadeDTO.nome());

        // Atualiza estado se mudou
        if (!cidade.getEstado().getId().equals(cidadeDTO.idEstado())) {
            cidade.setEstado(validarEstado(cidadeDTO.idEstado()));
        }

        cidade.setNome(cidadeDTO.nome());
        return CidadeDTOResponse.valueOf(cidade);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        boolean deleted = cidadeRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Cidade não encontrada para exclusão. ID: " + id);
        }
    }

    @Override
    public CidadeDTOResponse findById(Long id) {
        Cidade cidade = cidadeRepository.findById(id);
        if (cidade == null) {
            throw new NotFoundException("Cidade não encontrada com ID: " + id);
        }
        return CidadeDTOResponse.valueOf(cidade);
    }

    @Override
    public List<CidadeDTOResponse> findAll() {
        return cidadeRepository.listAll().stream()
                .map(CidadeDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<CidadeDTOResponse> findByNome(String nome) {
        return cidadeRepository.findByNome(nome).stream()
                .map(CidadeDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<CidadeDTOResponse> findByEstadoId(Long idEstado) {
        validarEstado(idEstado); // garante que existe

        return cidadeRepository.findByEstado(idEstado).stream()
                .map(CidadeDTOResponse::valueOf)
                .collect(Collectors.toList());
    }

    // ---------- Métodos utilitários privados ----------

    private Estado validarEstado(Long idEstado) {
        Estado estado = estadoRepository.findById(idEstado);
        if (estado == null) {
            throw new NotFoundException("Estado não encontrado para o ID: " + idEstado);
        }
        return estado;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new BadRequestException("Nome da cidade não pode ser vazio.");
        }
    }
}