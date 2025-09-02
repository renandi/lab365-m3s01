package com.senai.lab365.exercicio_m3s1.service;

import com.senai.lab365.exercicio_m3s1.model.Action;

import java.util.List;

public interface ActionService {

    Action createAction (Action action);

    Action getById (Long id);
    List<Action> getAll ();

    Action update(Long id, Action action);

    String deleteById (Long id);
}
