package br.com.sistemaReservas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Restaurante {

    private Long id;
    private String nome, endereco, cep, telefone, img;

    public Restaurante(Long id, String nome, String endereco, String cep, String telefone, String img) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = formatarTelefone(telefone);
        this.img = img;
    }

    public static String formatarTelefone(String telefone) {
        if (telefone.length() == 11) {
            return telefone.replaceAll("(\\d{2})(\\d{1})(\\d{4})(\\d{4})", "($1) $2 $3-$4");
        } else {
            throw new IllegalArgumentException("O número de telefone deve conter 11 dígitos.");
        }
    }

}