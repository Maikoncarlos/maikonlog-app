package com.github.maikoncarlos.maikonlogapp.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaRequest {

    @NotBlank
    private String descricao;

}
