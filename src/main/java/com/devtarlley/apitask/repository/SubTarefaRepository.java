package com.devtarlley.apitask.repository;

import com.devtarlley.apitask.domain.SubTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubTarefaRepository extends JpaRepository<SubTarefa, Long> {
    @Query("select s from SubTarefa s where s.tarefa.idTarefa = ?1")
    List<SubTarefa> findByTarefa_IdTarefa(Long idTarefa);

}