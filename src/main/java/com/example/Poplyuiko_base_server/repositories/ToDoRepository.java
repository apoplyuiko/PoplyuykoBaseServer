package com.example.Poplyuiko_base_server.repositories;

import com.example.Poplyuiko_base_server.models.ToDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    void deleteByStatus(boolean status);

    Page<ToDo> findByStatus(boolean status, Pageable pageable);
}
