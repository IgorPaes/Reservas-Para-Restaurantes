package br.com.sistemaReservas.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserAuthenticatedResponse {
    private boolean authenticated;
}