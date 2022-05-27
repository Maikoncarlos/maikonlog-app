package com.github.maikoncarlos.maikonlogapp.api.mapper;

import com.github.maikoncarlos.maikonlogapp.api.model.request.EntregaRequest;
import com.github.maikoncarlos.maikonlogapp.api.model.response.EntregaResponse;
import com.github.maikoncarlos.maikonlogapp.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaResponse toResponse(Entrega entrega) {
        return modelMapper.map(entrega, EntregaResponse.class);
    }

    public List<EntregaResponse> toCollectionResponse(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaRequest entregaRequest) {
        return modelMapper.map(entregaRequest, Entrega.class);
    }
}
