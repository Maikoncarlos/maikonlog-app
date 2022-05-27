package com.github.maikoncarlos.maikonlogapp.api.controller;

import com.github.maikoncarlos.maikonlogapp.api.mapper.EntregaMapper;
import com.github.maikoncarlos.maikonlogapp.api.model.request.EntregaRequest;
import com.github.maikoncarlos.maikonlogapp.api.model.response.EntregaResponse;
import com.github.maikoncarlos.maikonlogapp.api.service.FinalizacaoEntregaService;
import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/entregas")
public class EntregaController {

    private EntregaService entregaService;
    private EntregaMapper entregaMapper;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregarequest){
        Entrega entregaSolicitada = entregaService.novaEntrega
                (entregaMapper.toEntity(entregarequest));
        return entregaMapper.toResponse(entregaSolicitada);
    }

    @PutMapping("/{id}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long id) {
        finalizacaoEntregaService.finalizar(id);
    }

    @GetMapping
    public List<EntregaResponse> listar(){
        return entregaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponse> listarPorId(@Valid @PathVariable Long id){
        return entregaService.listarPorId(id);
    }



}
