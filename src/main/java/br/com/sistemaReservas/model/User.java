package br.com.sistemaReservas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    private Long id;
    private String nome, email, cpf, telefone, senha;

    public User(String nome, String email, String cpf, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }

}