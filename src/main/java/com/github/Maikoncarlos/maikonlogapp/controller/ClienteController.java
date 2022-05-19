package com.github.Maikoncarlos.maikonlogapp.controller;


import com.github.Maikoncarlos.maikonlogapp.domain.model.Cliente;
import com.github.Maikoncarlos.maikonlogapp.domain.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

}