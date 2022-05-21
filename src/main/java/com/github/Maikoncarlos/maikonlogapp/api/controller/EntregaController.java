package com.github.maikoncarlos.maikonlogapp.api.controller;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return entregaService.novaEntrega(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return entregaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> listarPorId(@Valid @PathVariable Long id){
        return entregaService.listarPorId(id);
    }
}
