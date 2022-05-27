package com.github.maikoncarlos.maikonlogapp.api.controller;

import com.github.maikoncarlos.maikonlogapp.domain.model.Cliente;
import com.github.maikoncarlos.maikonlogapp.domain.repositories.ClienteRepository;
import com.github.maikoncarlos.maikonlogapp.domain.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            ResponseEntity.ok(cliente);
        }
       return ResponseEntity.notFound().build();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente,
                                             @PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(cliente.getId());
        cliente = clienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }

}