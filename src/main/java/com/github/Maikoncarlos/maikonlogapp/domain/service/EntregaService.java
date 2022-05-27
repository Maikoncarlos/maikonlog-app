package com.github.maikoncarlos.maikonlogapp.domain.service;

import com.github.maikoncarlos.maikonlogapp.api.mapper.EntregaMapper;
import com.github.maikoncarlos.maikonlogapp.api.model.response.EntregaResponse;
import com.github.maikoncarlos.maikonlogapp.domain.model.Cliente;
import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.model.StatusEntrega;
import com.github.maikoncarlos.maikonlogapp.domain.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class EntregaService {

    private ClienteService clienteService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;

    @Transactional
    public Entrega novaEntrega(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        entrega.setCliente(cliente);
        return entregaRepository.save(entrega);
    }

    public List<EntregaResponse> listar() {
        return entregaMapper.toCollectionResponse(entregaRepository.findAll());
    }


    public ResponseEntity<EntregaResponse> listarPorId(Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toResponse(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}