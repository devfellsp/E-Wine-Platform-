package br.unitins.topicos1.ewine.service.location;

import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.EstadoDTO;
import br.unitins.topicos1.ewine.dto.locationdto.EstadoDTOResponse;

public  interface EstadoService {
    EstadoDTOResponse create(EstadoDTO dto);
    
    EstadoDTOResponse update(Long id, EstadoDTO dto);
    
    void delete(Long id);
    
    EstadoDTOResponse findById(Long id);
    
    List<EstadoDTOResponse> findAll();
    
    List<EstadoDTOResponse> findByNome(String nome);
    
    List<EstadoDTOResponse> findByPaisId(Long idPais);
    
}
