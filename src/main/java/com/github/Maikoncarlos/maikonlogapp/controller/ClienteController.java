package com.github.Maikoncarlos.maikonlogapp.controller;


import com.github.Maikoncarlos.maikonlogapp.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João");
        cliente.setEmail("joao@teste.com");
        cliente.setTelefone("11 957889800");

        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setEmail("joao@teste.com");
        cliente1.setTelefone("11 957889800");

        return Arrays.asList(cliente, cliente1);
    }

}