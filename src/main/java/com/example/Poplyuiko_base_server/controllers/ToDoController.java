package com.example.Poplyuiko_base_server.controllers;

import com.example.Poplyuiko_base_server.DTOs.ChangeStatusToDoDto;
import com.example.Poplyuiko_base_server.DTOs.ChangeTextTodoDto;
import com.example.Poplyuiko_base_server.DTOs.CreateTodoDto;
import com.example.Poplyuiko_base_server.DTOs.GetNewsDto;
import com.example.Poplyuiko_base_server.handling.ValidationConstants;
import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.response.BaseSuccessResponse;
import com.example.Poplyuiko_base_server.response.CustomSuccessResponse;
import com.example.Poplyuiko_base_server.services.ToDoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
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

import java.util.Optional;

@RestController
@Validated
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService todoService;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<GetNewsDto<ToDo>>> getPaginated(
            @RequestParam(defaultValue = "0")
            @Positive(message = ValidationConstants.TASKS_PAGE_GREATER_OR_EQUAL_1)
            @Max(value = 100, message = ValidationConstants.TASKS_PER_PAGE_LESS_OR_EQUAL_100)
            int page,
            @RequestParam(defaultValue = "10")
            @Positive(message = ValidationConstants.TASKS_PER_PAGE_GREATER_OR_EQUAL_1)
            @Max(value = 100, message = ValidationConstants.TASKS_PER_PAGE_LESS_OR_EQUAL_100)
            int perPage,
            @RequestParam(required = false)
            Boolean status) {
        return ResponseEntity.ok(new CustomSuccessResponse<>(todoService.getAllToDos(page, perPage, status)));
    }

    @PostMapping
    public ResponseEntity<CustomSuccessResponse<ToDo>> create(@Valid @RequestBody CreateTodoDto todo) {
        return ResponseEntity.ok(new CustomSuccessResponse<>(todoService.createTodo(todo)));

    }

    @DeleteMapping
    public ResponseEntity<BaseSuccessResponse> deleteAllReady() {
        return ResponseEntity.ok(todoService.deleteAllCompletedToDos());
    }

    @PatchMapping
    public ResponseEntity<BaseSuccessResponse> patch(@RequestBody @Valid ChangeStatusToDoDto dto) {
        return ResponseEntity.ok(todoService.updateToDoAllStatus(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseSuccessResponse> delete(
            @PathVariable @Positive(message = ValidationConstants.ID_MUST_BE_POSITIVE) Long id) {
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<BaseSuccessResponse> patchStatus(@PathVariable
                                                           @Positive(message = ValidationConstants.ID_MUST_BE_POSITIVE)
                                                           Long id,
                                                           @RequestBody @Valid ChangeStatusToDoDto dto) {
        return ResponseEntity.ok(todoService.updateToDoStatus(id, dto));
    }

    @PatchMapping("/text/{id}")
    public ResponseEntity<BaseSuccessResponse> patchText(
            @PathVariable @Positive(message = ValidationConstants.ID_MUST_BE_POSITIVE) Long id,
            @RequestBody @Valid ChangeTextTodoDto changeTextTodoDto) {
        return ResponseEntity.ok(todoService.updateToDoText(id, changeTextTodoDto));
    }
}
