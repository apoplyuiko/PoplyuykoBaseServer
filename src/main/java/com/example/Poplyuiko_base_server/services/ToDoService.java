package com.example.Poplyuiko_base_server.services;

import com.example.Poplyuiko_base_server.DTOs.CreateTodoDto;
import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.repositories.ToDoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public Page<ToDo> getAllToDos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return toDoRepository.findAll(pageable);
    }

    public Optional<ToDo> getTodoById(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo createTodo(@Valid CreateTodoDto createTodo) {
        ToDo todo = new ToDo();
        todo.setText(createTodo.getText());
        return toDoRepository.save(todo);
    }

    public ToDo updateToDoStatus(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDo.setStatus(!toDo.isStatus());
        return toDoRepository.save(toDo);
    }

    public ToDo updateToDoText(Long id, String newText) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDo.setText(newText);
        return toDoRepository.save(toDo);
    }

    public void deleteTodo(Long id) {
        toDoRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllCompletedToDos() {
        toDoRepository.deleteByStatus(true);
    }
}

