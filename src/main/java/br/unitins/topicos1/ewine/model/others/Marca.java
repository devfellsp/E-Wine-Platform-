package br.unitins.topicos1.ewine.model.others;

import jakarta.persistence.Entity;

@Entity
public class Marca extends DefaultEntity {
    
    private String nome;
    private String paisDeOrigem;
    private String anofundacao;
    private String classificacao;
    
    

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }
    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }   
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
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
