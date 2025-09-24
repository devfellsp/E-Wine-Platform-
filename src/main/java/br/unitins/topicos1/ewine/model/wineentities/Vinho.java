package br.unitins.topicos1.ewine.model.wineentities;

import java.util.List;

import br.unitins.topicos1.ewine.model.locationentities.Pais;
import br.unitins.topicos1.ewine.model.others.DefaultEntity;
import br.unitins.topicos1.ewine.model.others.Marca;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Vinho extends DefaultEntity {

    private String nome;
    private Double preco;
    private Integer quantEstoque;
    private String descricao;
    private String imagem;
    private String sku;

    @ManyToMany
    private List<Uva> uvas;

    @ManyToOne
    @JoinColumn(name = "id_tipo_vinho")
    private TipoVinho tipoVinho;


    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais paisDeOrigem;

    @ManyToOne
    @JoinColumn(name = "id_estilo")
    private Estilo estilo;

    @ManyToOne
    @JoinColumn(name = "id_ocasiao")
    private Ocasiao ocasiao;
 
    @ManyToOne
    @JoinColumn(name = "id_safra")
    private Safra safra;
   
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(Integer quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public TipoVinho getTipoVinho() {
        return tipoVinho;
    }

    public void setTipoVinho(TipoVinho tipoVinho) {
        this.tipoVinho = tipoVinho;
    }

    public List<Uva> getUvas() {
        return uvas;
    }

    public void setUvas(List<Uva> uvas) {
        this.uvas = uvas;
    }

    public Pais getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(Pais paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Ocasiao getOcasiao() {
        return ocasiao;
    }

    public void setOcasiao(Ocasiao ocasiao) {
        this.ocasiao = ocasiao;
    }

    public Safra getSafra() {
        return safra;
    }

    public void setSafra(Safra safra) {
        this.safra = safra;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    


   
}

