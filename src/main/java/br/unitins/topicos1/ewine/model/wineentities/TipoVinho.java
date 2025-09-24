package br.unitins.topicos1.ewine.model.wineentities;

import br.unitins.topicos1.ewine.model.others.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class TipoVinho extends DefaultEntity {
    private String nome;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}