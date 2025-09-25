package br.unitins.topicos1.ewine.service.others;

import java.util.List;

import br.unitins.topicos1.ewine.dto.OthersDTO.MarcaDTO;
import br.unitins.topicos1.ewine.dto.OthersDTO.MarcaDTOResponse;


public interface MarcaService {
    MarcaDTOResponse create(MarcaDTO dto);
    MarcaDTOResponse update(Long id, MarcaDTO dto);
    void delete(Long id);
    MarcaDTOResponse findById(Long id);
    List<MarcaDTOResponse> findAll();
    List<MarcaDTOResponse> findByNome(String nome);
}
