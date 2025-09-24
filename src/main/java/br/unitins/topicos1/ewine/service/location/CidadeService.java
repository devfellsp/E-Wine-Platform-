package br.unitins.topicos1.ewine.service.location;

import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTO;
import br.unitins.topicos1.ewine.dto.locationdto.CidadeDTOResponse;

public interface CidadeService {

    CidadeDTOResponse create(CidadeDTO dto);
    
    CidadeDTOResponse update(Long id, CidadeDTO dto);
    
    void delete(Long id);
    
    CidadeDTOResponse findById(Long id);
    
    List<CidadeDTOResponse> findAll();
    
    List<CidadeDTOResponse> findByNome(String nome);
    
    List<CidadeDTOResponse> findByEstadoId(Long idEstado);
    

    
}
