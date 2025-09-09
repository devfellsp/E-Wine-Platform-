package br.unitins.topicos1.ewine.model;

import jakarta.persistence.Entity;

@Entity
public class Marca extends DefaultEntity {                               
    private String nome;
    private String paisOrigem;
    private String anofundacao;
    private String classificacao;


    public String getAnofundacao() {
        return anofundacao;
    }
    public void setAnofundacao(String anofundacao) {
        this.anofundacao = anofundacao;
    }
    
    
    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
     
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getPaisOrigem() {
        return paisOrigem;
    }
    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
}
