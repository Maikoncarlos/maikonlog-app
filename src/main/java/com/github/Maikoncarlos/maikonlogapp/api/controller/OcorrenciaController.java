package com.github.maikoncarlos.maikonlogapp.api.controller;

import com.github.maikoncarlos.maikonlogapp.api.mapper.OcorrenciaMapper;
import com.github.maikoncarlos.maikonlogapp.api.model.request.OcorrenciaRequest;
import com.github.maikoncarlos.maikonlogapp.api.model.response.OcorrenciaResponse;
import com.github.maikoncarlos.maikonlogapp.api.service.BuscaEntregaService;
import com.github.maikoncarlos.maikonlogapp.api.service.RegistroOcorrenciaService;
import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaResponse registrar(@PathVariable Long id,
                                        @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest) {

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(id, ocorrenciaRequest.getDescricao());

        return ocorrenciaMapper.toResponse(ocorrenciaRegistrada);

    }

    @GetMapping
    public List<OcorrenciaResponse> listar(@PathVariable Long id) {
        Entrega entrega = buscaEntregaService.buscar(id);

        return ocorrenciaMapper.toCollectionResponse(entrega.getOcorrencias());
    }
}