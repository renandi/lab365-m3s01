package com.senai.lab365.exercicio_m3s1.dtos;

import com.senai.lab365.exercicio_m3s1.enums.CategoriaAcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ActionRequestDto(
        @NotBlank(message = "O título é obrigatório")
        @Size(min=2, max=100, message = "O título deve conter entre 2 e 100 caracteres")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotNull(message = "A categoria é obrigatória!")
        CategoriaAcao categoriaAcao,

        @NotNull(message = "A data de realização é obrigatória!")
        @PastOrPresent
        LocalDate dataRealizacao,

        @NotBlank(message = "O responsável é obrigatório!")
        String responsavel
) {
}
