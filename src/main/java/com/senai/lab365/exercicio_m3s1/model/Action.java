package com.senai.lab365.exercicio_m3s1.model;

import com.senai.lab365.exercicio_m3s1.enums.CategoriaAcao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Size(min = 3, max = 999)
    String titulo;

    @NotBlank
    @Size(min = 5, max = 999)
    String descricao;

    @NotNull
    CategoriaAcao categoriaAcao;

    @NotNull
    @PastOrPresent
    LocalDate dataRealizacao;

    @NotBlank
    String responsavel;

    public Action(String titulo, String descricao, CategoriaAcao categoriaAcao, LocalDate dataRealizacao, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoriaAcao = categoriaAcao;
        this.dataRealizacao = dataRealizacao;
        this.responsavel = responsavel;
    }
}
