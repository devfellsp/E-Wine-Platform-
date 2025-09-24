package br.unitins.topicos1.ewine.dto.winedto;

import br.unitins.topicos1.ewine.model.wineentities.Ocasiao;

public record OcasiaoDTOResponse(
    String nome
) {
    public OcasiaoDTOResponse valueOf ( Ocasiao ocasiao) {
        return new OcasiaoDTOResponse(
            ocasiao.getNome()
        );
    }
}