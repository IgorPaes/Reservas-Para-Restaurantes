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
    private byte quantidadePessoas;
    private String comentario;

    public Reserva(long id, long idRestaurante, long idCliente, Date data, Time horario, byte quantidadePessoas) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.data = data;
        this.horario = horario;
        this.quantidadePessoas = quantidadePessoas;
    }

    public Reserva(long idRestaurante, long idCliente, Date data, Time horario, byte quantidadePessoas, String comentario) {
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.data = data;
        this.horario = horario;
        this.quantidadePessoas = quantidadePessoas;
        this.comentario = comentario;
    }
    
}

