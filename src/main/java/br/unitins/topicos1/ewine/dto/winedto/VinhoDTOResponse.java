package br.unitins.topicos1.ewine.dto.winedto;

import br.unitins.topicos1.ewine.model.wineentities.Estilo;
import br.unitins.topicos1.ewine.model.wineentities.Ocasiao;
import br.unitins.topicos1.ewine.model.wineentities.Safra;
import br.unitins.topicos1.ewine.model.wineentities.TipoVinho;
import br.unitins.topicos1.ewine.model.wineentities.Uva;
import br.unitins.topicos1.ewine.model.wineentities.Vinho;
import br.unitins.topicos1.ewine.model.locationentities.Pais;
import br.unitins.topicos1.ewine.model.others.Marca;
import java.util.List;

public record VinhoDTOResponse(
    Long id,
    String nome,
    Double preco,
    Integer quantEstoque,
    String descricao,
    String imagem,
    String sku,
    
    Marca marca,
    TipoVinho tipoVinho,
    List<Uva> uvas,
    Pais paisDeOrigem, 
    Estilo estilo,
    Ocasiao ocasiao,
    Safra safra
) {
    public static VinhoDTOResponse valueOf(Vinho vinho) {
        return new VinhoDTOResponse(
            vinho.getId(),
            vinho.getNome(),
            vinho.getPreco(),
            vinho.getQuantEstoque(),
            vinho.getDescricao(),
            vinho.getImagem(),
            vinho.getSku(),
            vinho.getMarca(),
            vinho.getTipoVinho(),
            vinho.getUvas(),
            vinho.getPaisDeOrigem(),
            vinho.getEstilo(),
            vinho.getOcasiao(),
            vinho.getSafra()
        );
    }
}