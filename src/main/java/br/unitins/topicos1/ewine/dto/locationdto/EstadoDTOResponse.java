package br.unitins.topicos1.ewine.dto.locationdto;

import br.unitins.topicos1.ewine.model.locationentities.Estado;

public record EstadoDTOResponse
(
    String nome,
    String sigla,
    Long idPais
) {

    public EstadoDTOResponse valueOf (Estado estado) {
        return new EstadoDTOResponse(
            estado.getNome(),
            estado.getSigla(),
            estado.getPais().getId()
        );
    }

}