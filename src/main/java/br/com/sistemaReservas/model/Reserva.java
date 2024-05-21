package br.com.sistemaReservas.model;

import java.util.Date;

import lombok.Getter;

@Getter
public class Reserva {

    private int id;
    private String nomeRestaurante, horario;
    private Date data;
    private int quantidadePessoas;

    public Reserva(int id, String nomeRestaurante, Date data, String horario, int quantidadePessoas) {
        this.id = id;
        this.nomeRestaurante = nomeRestaurante;
    }

}

