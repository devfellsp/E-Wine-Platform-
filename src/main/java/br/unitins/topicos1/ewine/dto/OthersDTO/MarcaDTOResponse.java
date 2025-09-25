package br.unitins.topicos1.ewine.dto.OthersDTO;

import br.unitins.topicos1.ewine.model.others.Marca;

public record MarcaDTOResponse(
    String nome,
    String paisDeOrigem,
    String anofundacao,
    String classificacao
    ) {
        public static MarcaDTOResponse valueOf (Marca marca){

            return new MarcaDTOResponse(
                marca.getNome(),
                marca.getPaisDeOrigem(),
                marca.getAnofundacao(),
                marca.getClassificacao()
            );
        }
    }