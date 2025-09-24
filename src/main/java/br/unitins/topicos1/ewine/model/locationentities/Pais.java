package br.unitins.topicos1.ewine.model.locationentities;

import br.unitins.topicos1.ewine.model.others.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Pais extends DefaultEntity {
    private String nome;
    private String sigla;

        @Enumerated(EnumType.STRING)
    private Regiao regiao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Regiao getRegiao() {
        return regiao;
    }

}