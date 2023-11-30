package com.devtarlley.apitask.repository;

import com.devtarlley.apitask.domain.Tarefa;
import com.devtarlley.apitask.enumerated.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

//    @Query("select t from Tarefa t where t.status = ?1")
    List<TarefaDTO> findByStatus(Status status);

}