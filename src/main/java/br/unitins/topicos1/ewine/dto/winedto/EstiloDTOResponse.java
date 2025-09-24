package br.unitins.topicos1.ewine.dto.winedto;

import br.unitins.topicos1.ewine.model.wineentities.Estilo;

public record EstiloDTOResponse(
    String nome
) {
    public EstiloDTOResponse valueOf (Estilo estilo) {
        return new EstiloDTOResponse(
            estilo.getNome()
        );
    }
}