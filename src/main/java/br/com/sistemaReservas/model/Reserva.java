package br.com.sistemaReservas.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    private long id, idRestaurante;
    private Date data;
    private String horario;
    private byte quantidadePessoas;
    private String comentairo;

    public Reserva(long id, long idRestaurante, Date data, String horario, byte quantidadePessoas) {
        this.id = id;
        this.idRestaurante = idRestaurante;
        this.data = data;
        this.horario = horario;
        this.quantidadePessoas = quantidadePessoas;
    }
    
}

