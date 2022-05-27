package com.github.maikoncarlos.maikonlogapp.api.model.response;

import com.github.maikoncarlos.maikonlogapp.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaResponse {

    private Long id;
    private ClienteReduzidoResponse cliente;
    private DestinatarioResponse destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;


}
