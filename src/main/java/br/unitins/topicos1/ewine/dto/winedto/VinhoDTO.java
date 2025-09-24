package br.unitins.topicos1.ewine.dto.winedto;

import java.util.List;

public record VinhoDTO(
    String nome,
    String safra,
    Double preco,
    Integer quantEstoque,
    String descricao,
    String imagem,
    String sku,
    
   
    Long idMarca,
    Long idTipoVinho,
    List<Long> idsUvas, 
    Long idPaisDeOrigem,
    Long idEstilo,
    Long idOcasiao
) {}


