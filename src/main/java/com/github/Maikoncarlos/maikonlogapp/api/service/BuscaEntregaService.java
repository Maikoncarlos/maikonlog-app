package com.github.maikoncarlos.maikonlogapp.api.service;

import com.github.maikoncarlos.maikonlogapp.domain.exception.EntidadeNaoEncontradaException;
import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }

}