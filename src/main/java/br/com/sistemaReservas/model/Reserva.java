package br.com.sistemaReservas.model;

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    private long id, idRestaurante, idCliente;
    private Date data;
    private Time horario;
    private byte qtdPessoas;
    private String comentario;

    public Reserva(long id, long idRestaurante, long idCliente, Date data, Time horario, byte qtdPessoas) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.data = data;
        this.horario = horario;
        this.qtdPessoas = qtdPessoas;
    }

    public Reserva(long idRestaurante, long idCliente, Date data, Time horario, byte qtdPessoas, String comentario) {
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.data = data;
        this.horario = horario;
        this.qtdPessoas = qtdPessoas;
        this.comentario = comentario;
    }
    
}

