package com.example.Poplyuiko_base_server.controllers;

import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @GetMapping("/")
    public ResponseEntity<List<ToDo>> getAllToDo() {
        return ResponseEntity.ok(toDoService.getAllToDo());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<ToDo>> getAllCompletedToDo() {
        return ResponseEntity.ok(toDoService.findAllCompletedToDo());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<ToDo>> getAllIncompleteToDo() {
        return ResponseEntity.ok(toDoService.findAllInCompleteToDo());
    }
    @PostMapping("/")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        return ResponseEntity.ok(toDoService.createNewToDo(toDo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        toDo.setId(id);
        return ResponseEntity.ok(toDoService.updateToDo(toDo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return ResponseEntity.ok(true);
    }
}
