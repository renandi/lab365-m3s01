package com.senai.lab365.exercicio_m3s1.dtos;

import com.senai.lab365.exercicio_m3s1.enums.CategoriaAcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ActionResponseDto(

        Long id,

        String titulo,

        String descricao,

        CategoriaAcao categoriaAcao,

        LocalDate dataRealizacao,

        String responsavel) {
}
