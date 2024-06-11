package com.example.Poplyuiko_base_server.controllers;

import com.example.Poplyuiko_base_server.DTOs.BaseSuccessResponse;
import com.example.Poplyuiko_base_server.DTOs.CreateTodoDto;
import com.example.Poplyuiko_base_server.DTOs.CustomSuccessResponse;
import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.services.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService todoService;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<Page<ToDo>>> getAllTodos(@RequestParam(defaultValue = "0") int page,
                                                                         @RequestParam(defaultValue = "10") int size) {
        Page<ToDo> toDos = todoService.getAllToDos(page, size);
        CustomSuccessResponse<Page<ToDo>> response = new CustomSuccessResponse<>();
        response.setStatusCode(200);
        response.setSuccess(true);
        response.setData(toDos);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ToDo> createTodo(@Valid @RequestBody CreateTodoDto todo) {
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<CustomSuccessResponse<ToDo>> updateToDoStatus(@PathVariable Long id) {
        ToDo updatedToDo = todoService.updateToDoStatus(id);
        CustomSuccessResponse<ToDo> response = new CustomSuccessResponse<>();
        response.setStatusCode(200);
        response.setSuccess(true);
        response.setData(updatedToDo);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/text/{id}")
    public ResponseEntity<CustomSuccessResponse<ToDo>> updateToDoText(@PathVariable Long id, @Valid @RequestBody CreateTodoDto todo) {
        ToDo updatedToDo = todoService.updateToDoText(id,todo.getText());
        CustomSuccessResponse<ToDo> response = new CustomSuccessResponse<>();
        response.setStatusCode(200);
        response.setSuccess(true);
        response.setData(updatedToDo);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<BaseSuccessResponse> deleteAllCompletedToDos() {
        todoService.deleteAllCompletedToDos();
        BaseSuccessResponse response;
        response = new BaseSuccessResponse();
        response.setStatusCode(204);
        response.setSuccess(true);
        return ResponseEntity.noContent().build();
    }
}
