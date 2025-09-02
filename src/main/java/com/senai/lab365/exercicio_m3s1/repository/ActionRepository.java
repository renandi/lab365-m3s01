package com.senai.lab365.exercicio_m3s1.repository;

import com.senai.lab365.exercicio_m3s1.enums.CategoriaAcao;
import com.senai.lab365.exercicio_m3s1.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findByCategoriaAcao (CategoriaAcao categoria);

}
