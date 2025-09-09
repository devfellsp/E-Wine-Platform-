package br.unitins.topicos1.ewine.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Cliente  extends DefaultEntity {
    
    
   
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco;

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static List<Cliente> listAll() {
      
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

        

}