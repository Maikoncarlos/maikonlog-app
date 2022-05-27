package com.github.maikoncarlos.maikonlogapp.api.service;

import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import com.github.maikoncarlos.maikonlogapp.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long id, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(id);

        return entrega.adicionarOcorrencia(descricao);
    }
}
