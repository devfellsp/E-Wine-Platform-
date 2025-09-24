package br.unitins.topicos1.ewine.model.locationentities;

import br.unitins.topicos1.ewine.model.others.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Estado extends DefaultEntity {
    private String nome;
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}