package com.senai.lab365.exercicio_m3s1.controllers;

import com.senai.lab365.exercicio_m3s1.dtos.ActionRequestDto;
import com.senai.lab365.exercicio_m3s1.dtos.ActionResponseDto;
import com.senai.lab365.exercicio_m3s1.mapper.ActionMapper;
import com.senai.lab365.exercicio_m3s1.model.Action;
import com.senai.lab365.exercicio_m3s1.service.ActionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acoes")
@RequiredArgsConstructor
public class ActionController {

    private final ActionService service;

    @GetMapping
    public List<ActionResponseDto> findAll() {
        return service.getAll().stream().map(ActionMapper::toDto).toList();
    }

    @GetMapping("{id}")
    public ActionResponseDto findById(@PathVariable Long id) {
        return ActionMapper.toDto(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ActionResponseDto> createAction (@Valid @RequestBody ActionRequestDto dto) {
        Action action = service.createAction( ActionMapper.toEntity(dto));
        return ResponseEntity.ok(ActionMapper.toDto(action));
    }

    @PutMapping("{id}")
    public ActionResponseDto update(@PathVariable Long id, @Valid @RequestBody ActionRequestDto dto) {
        return ActionMapper.toDto(service.update(id, ActionMapper.toEntity(dto)));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
