package br.unitins.topicos1.ewine.dto.locationdto;

import br.unitins.topicos1.ewine.model.locationentities.Pais;

public record PaisDTOResponse(
    Long id,
    String nome,
    String sigla
) {
    public static PaisDTOResponse valueOf (Pais pais) {
        return new PaisDTOResponse(
            pais.getId(),
            pais.getNome(),
            pais.getSigla()
            
        );
    }
}