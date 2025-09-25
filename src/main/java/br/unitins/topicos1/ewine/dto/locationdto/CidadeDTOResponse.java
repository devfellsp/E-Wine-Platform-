package br.unitins.topicos1.ewine.dto.locationdto;
import br.unitins.topicos1.ewine.model.locationentities.Cidade;

public record CidadeDTOResponse(
    Long id,
    String nome,
    Long idEstado
) {
    public static CidadeDTOResponse valueOf (Cidade cidade) {
        return new CidadeDTOResponse(
            cidade.getId(),
            cidade.getNome(),
            cidade.getEstado().getId()
        );
    }
}