package com.example.Poplyuiko_base_server.services;

import com.example.Poplyuiko_base_server.DTOs.ChangeStatusToDoDto;
import com.example.Poplyuiko_base_server.DTOs.ChangeTextTodoDto;
import com.example.Poplyuiko_base_server.DTOs.CreateTodoDto;
import com.example.Poplyuiko_base_server.DTOs.GetNewsDto;
import com.example.Poplyuiko_base_server.handling.CustomException;
import com.example.Poplyuiko_base_server.handling.ErrorCodes;
import com.example.Poplyuiko_base_server.models.ToDo;
import com.example.Poplyuiko_base_server.repositories.ToDoRepository;
import com.example.Poplyuiko_base_server.response.BaseSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public GetNewsDto<ToDo> getAllToDos(int page, int perPage, Boolean status) {
        var listTask = toDoRepository.findAll(PageRequest.of(page, perPage));
        var countReady = toDoRepository.findAll().stream().filter(ToDo::isStatus).count();
        return new GetNewsDto<>(
                listTask.stream()
                        .filter(item -> {
                            if (status == null) {
                                return true;
                            } else {
                                return item.isStatus() == status;
                            }
                        }).toList(),
                listTask.getTotalElements(),
                countReady,
                listTask.getTotalElements() - countReady);
    }

    public ToDo createTodo(CreateTodoDto createTodo) {
        ToDo todo = new ToDo();
        todo.setText(createTodo.getText());
        return toDoRepository.save(todo);
    }

    public BaseSuccessResponse updateToDoStatus(Long id, ChangeStatusToDoDto changeStatusToDoDto) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCodes.TASK_NOT_FOUND));
        todo.setStatus(changeStatusToDoDto.getStatus());
        toDoRepository.save(todo);
        return new BaseSuccessResponse(0, true, null);
    }

    public BaseSuccessResponse updateToDoAllStatus(ChangeStatusToDoDto changeStatusToDoDto) {
        var toDos = toDoRepository.findAll();
        toDos.forEach(item -> {
            item.setStatus(changeStatusToDoDto.getStatus());
            toDoRepository.save(item);
        });
        return new BaseSuccessResponse(1, true, null);
    }

    public BaseSuccessResponse updateToDoText(Long id, ChangeTextTodoDto changeTextTodoDto) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCodes.TASK_NOT_FOUND));
        todo.setText(changeTextTodoDto.getText());
        toDoRepository.save(todo);
        return new BaseSuccessResponse(0, true, null);
    }

    public BaseSuccessResponse deleteTodo(Long id) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCodes.TASK_NOT_FOUND));
        toDoRepository.delete(todo);
        return new BaseSuccessResponse(0, true, null);
    }

    @Transactional
    public BaseSuccessResponse deleteAllCompletedToDos() {
        toDoRepository.deleteByStatus(true);
        return new BaseSuccessResponse(1, true, null);
    }
}

