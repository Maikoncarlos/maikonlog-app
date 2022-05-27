package com.github.maikoncarlos.maikonlogapp.api.mapper;

import com.github.maikoncarlos.maikonlogapp.api.model.response.OcorrenciaResponse;
import com.github.maikoncarlos.maikonlogapp.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaResponse toResponse(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaResponse.class);
    }

    public List<OcorrenciaResponse> toCollectionResponse(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
