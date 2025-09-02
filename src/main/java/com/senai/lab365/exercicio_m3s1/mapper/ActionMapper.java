package com.senai.lab365.exercicio_m3s1.mapper;

import com.senai.lab365.exercicio_m3s1.dtos.ActionRequestDto;
import com.senai.lab365.exercicio_m3s1.dtos.ActionResponseDto;
import com.senai.lab365.exercicio_m3s1.model.Action;

public class ActionMapper {
    public static ActionResponseDto toDto(Action action) {
        return new ActionResponseDto (
            action.getId(),
                action.getTitulo(),
                action.getDescricao(),
                action.getCategoriaAcao(),
                action.getDataRealizacao(),
                action.getResponsavel()
        );
    }

    public static Action toEntity(ActionRequestDto actionRequestDto) {
        return new Action (
                actionRequestDto.titulo(),
                actionRequestDto.descricao(),
                actionRequestDto.categoriaAcao(),
                actionRequestDto.dataRealizacao(),
                actionRequestDto.responsavel()
                );
    }
}
