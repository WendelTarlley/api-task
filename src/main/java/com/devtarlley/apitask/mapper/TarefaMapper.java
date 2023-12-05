package com.devtarlley.apitask.mapper;

import com.devtarlley.apitask.domain.Tarefa;
import com.devtarlley.apitask.dto.tarefa.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TarefaMapper.class,SubTarefaMapper.class})
public interface TarefaMapper {

    Tarefa toEntity(TarefaDTO tarefaDTO);
    List<Tarefa> toEntity(List<TarefaDTO> tarefaDTOList);


    @Mapping(target = "subTarefaDTOS",source = "subTarefas")
    TarefaDTO toDTO(Tarefa tarefa);
    List<TarefaDTO> toDTO(List<Tarefa> tarefaList);

}
