package com.example.Poplyuiko_base_server.services;

import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createNewToDo(ToDo task) {
        return toDoRepository.save(task);
    }

    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    public ToDo findToDoById(Long id) {
        return toDoRepository.getById(id);
    }

    public List<ToDo> findAllCompletedToDo() {
        return toDoRepository.findByCompletedTrue();
    }

    public List<ToDo> findAllInCompleteToDo() {
        return toDoRepository.findByCompletedFalse();
    }

    public void deleteToDo(Long toDo) {
        toDoRepository.delete(toDo);
    }

    public ToDo updateToDo(ToDo task) {
        return toDoRepository.save(task);
    }

}
