package com.example.Poplyuiko_base_server.repositories;

import com.example.Poplyuiko_base_server.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    public ToDo findByToDo(String toDo);

    public List<ToDo> findByCompletedTrue();

    public List<ToDo> findByCompletedFalse();

    @NonNull
    public List<ToDo> findAll();

    @NonNull
    public ToDo getById(@NonNull Long id);

    void delete(Long toDo);
}