package br.com.sistemaReservas.model;

import lombok.Getter;

@Getter
public class Restaurante {
    
    private Long id;
    private String nome;
    private String endereco;
    private String cep;
    private String telefone;
    private String img;

    public Restaurante(Long id, String nome, String endereco, String cep, String telefone, String img) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.img = img;
    }

}
