package com.github.maikoncarlos.maikonlogapp.api.service;

import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }

}
