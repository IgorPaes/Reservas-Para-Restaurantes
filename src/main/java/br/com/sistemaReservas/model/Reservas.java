package br.com.sistemaReservas.model;


import javax.servlet.http.Cookie;

public class Reservas {
    private String data;
    private String horario;
    private int qtdPessoas;
    private String comentario;

    private User usuario;

    public Reservas(String data, String horario, int qtdPessoas, String comentario, User usuario) {
        this.data = data;
        this.horario = horario;
        this.qtdPessoas = qtdPessoas;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public String getComentario() {
        return comentario;
    }

    public User getUsuario() {
        return usuario;
    }
}


