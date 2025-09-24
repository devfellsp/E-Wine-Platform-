package br.unitins.topicos1.ewine.dto.winedto;

import br.unitins.topicos1.ewine.model.wineentities.TipoVinho;

public record TipoVinhoDTOResponse(
    String nome
) {
    public TipoVinhoDTOResponse valueOf (TipoVinho tipovinho){
        return new TipoVinhoDTOResponse(
            tipovinho.getNome()
        );
        
    }
}