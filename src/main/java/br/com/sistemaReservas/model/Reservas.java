package br.com.sistemaReservas.model;

import java.util.Date;

public class Reservas {
    private int id;
    private String nomeRestaurante;
    private Date data;
    private String horario;
    private int quantidadePessoas;

    public Reservas(int id, String nomeRestaurante, Date data, String horario, int quantidadePessoas) {
        this.id = id;
        this.nomeRestaurante = nomeRestaurante;
    }



    public int getId() {
        return id;
    }


    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public Date getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }


}

