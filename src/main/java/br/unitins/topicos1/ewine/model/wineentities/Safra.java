package br.unitins.topicos1.ewine.model.wineentities;

import br.unitins.topicos1.ewine.model.others.DefaultEntity;
import jakarta.persistence.Entity;
@Entity
public class Safra extends DefaultEntity {
    private Integer ano;
    private String descricao;

    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
   
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    
}
