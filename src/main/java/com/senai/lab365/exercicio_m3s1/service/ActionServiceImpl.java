package com.senai.lab365.exercicio_m3s1.service;

import com.senai.lab365.exercicio_m3s1.enums.CategoriaAcao;
import com.senai.lab365.exercicio_m3s1.exceptions.ResourceNotFoundException;
import com.senai.lab365.exercicio_m3s1.model.Action;
import com.senai.lab365.exercicio_m3s1.repository.ActionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository repository;

    @Transactional
    @Override
    public Action createAction(Action action) {
        return repository.save(action);
    }

    @Transactional
    @Override
    public Action getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public List<Action> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Action update(Long id, Action action) {
        Action myAction = repository.getReferenceById(id);

        myAction.setTitulo(action.getTitulo());
        myAction.setDescricao(action.getDescricao());
        myAction.setCategoriaAcao(action.getCategoriaAcao());
        myAction.setDataRealizacao(action.getDataRealizacao());
        myAction.setResponsavel(action.getResponsavel());

        return repository.save(myAction);
    }

    @Transactional
    @Override
    public String deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Filme com ID " + id + "deletado com sucesso!";
        }
        else {
            throw new ResourceNotFoundException("Filme com ID "+id+"não encontrado.");
        }
    }

    @Transactional
    @Override
    public List<Action> findByCategory(CategoriaAcao category) {

        return repository.findByCategoriaAcao(category);
    }
}
