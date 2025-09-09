package br.unitins.topicos1.ewine.model;

import jakarta.persistence.Entity;

@Entity
public class Vinho extends DefaultEntity {

    private String nome;
    private String tipo;
    private String safra;
    private String pais;
    private String uva;
    private Double preco;
    private Integer quantEstoque;
    private String descricao;
    private String imagem;  
    private String marca;
    private String sku;


    
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }  
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getSafra() { return safra; }
    public void setSafra(String safra) { this.safra = safra; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getUva() { return uva; }
    public void setUva(String uva) { this.uva = uva; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQuantEstoque() { return quantEstoque; }
    public void setQuantEstoque(Integer quantEstoque) { this.quantEstoque = quantEstoque; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }
}
