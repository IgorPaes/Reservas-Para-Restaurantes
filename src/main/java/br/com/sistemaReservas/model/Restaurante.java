package br.com.sistemaReservas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    private Long id;
    private String nome, endereco, cep, telefone, img;

}