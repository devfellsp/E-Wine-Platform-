package br.unitins.topicos1.ewine.service.location;


import java.util.List;

import br.unitins.topicos1.ewine.dto.locationdto.PaisDTO;
import br.unitins.topicos1.ewine.dto.locationdto.PaisDTOResponse;

public interface PaisService {
    PaisDTOResponse create (PaisDTO paisDTO);
    PaisDTOResponse update (Long id, PaisDTO paisDTO);
    PaisDTOResponse findById (Long id);  
    void delete (Long id);
    List<PaisDTOResponse> findAll();
    List<PaisDTOResponse> findByName (String nome);
   

}
