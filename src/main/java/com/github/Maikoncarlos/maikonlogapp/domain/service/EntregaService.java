package com.github.maikoncarlos.maikonlogapp.domain.service;

import com.github.maikoncarlos.maikonlogapp.domain.model.Cliente;
import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.model.StatusEntrega;
import com.github.maikoncarlos.maikonlogapp.domain.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private ClienteService clienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega novaEntrega(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        entrega.setCliente(cliente);
        return entregaRepository.save(entrega);
    }
}