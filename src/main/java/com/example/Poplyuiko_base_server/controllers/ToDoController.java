package com.example.Poplyuiko_base_server.controllers;

import com.example.Poplyuiko_base_server.DTOs.BaseSuccessResponse;
import com.example.Poplyuiko_base_server.DTOs.ChangeStatusToDoDto;
import com.example.Poplyuiko_base_server.DTOs.ChangeTextTodoDto;
import com.example.Poplyuiko_base_server.DTOs.CreateTodoDto;
import com.example.Poplyuiko_base_server.DTOs.CustomSuccessResponse;
import com.example.Poplyuiko_base_server.DTOs.GetNewsDto;
import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.services.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService todoService;

    @GetMapping
    public ResponseEntity<
            CustomSuccessResponse<
                    GetNewsDto<ToDo>>> getPaginated(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int perPage) {
        return ResponseEntity.ok(new CustomSuccessResponse<>(todoService.getAllToDos(page, perPage)));
    }

    @PostMapping
    public ResponseEntity<CustomSuccessResponse<ToDo>> create(@Valid @RequestBody CreateTodoDto todo) {
        return ResponseEntity.ok(new CustomSuccessResponse<>(todoService.createTodo(todo)));

    }

    @DeleteMapping
    public ResponseEntity<BaseSuccessResponse> deleteAllReady() {
        return ResponseEntity.ok(todoService.deleteAllCompletedToDos());
    }

    @PatchMapping("/status")
    public ResponseEntity<BaseSuccessResponse> patch(@RequestBody ChangeStatusToDoDto dto) {
        return ResponseEntity.ok(todoService.updateToDoAllStatus(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseSuccessResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<BaseSuccessResponse> patchStatus(@PathVariable Long id,
                                                           @RequestBody ChangeStatusToDoDto dto) {
        return ResponseEntity.ok(todoService.updateToDoStatus(id, dto));
    }

    @PatchMapping("/text/{id}")
    public ResponseEntity<BaseSuccessResponse> patchText(@PathVariable Long id,
                                                         @Valid @RequestBody ChangeTextTodoDto changeTextTodoDto) {
        return ResponseEntity.ok(todoService.updateToDoText(id, changeTextTodoDto));
    }
}
