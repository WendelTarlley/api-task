package com.devtarlley.apitask.mapper;

import com.devtarlley.apitask.domain.SubTarefa;
import com.devtarlley.apitask.dto.subtarefa.SubTarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SubTarefaMapper.class,TarefaMapper.class})
public interface SubTarefaMapper {

    @Mapping(target = "tarefa.idTarefa",source = "idTarefa")
    SubTarefa toEntity(SubTarefaDTO subTarefaDTO);

    List<SubTarefa> toEntity(List<SubTarefaDTO> subTarefaDTOS);

    @Mapping(target = "idTarefa",source = "tarefa.idTarefa")
    SubTarefaDTO toDTO(SubTarefa subTarefa);

    List<SubTarefaDTO> toDTO(List<SubTarefa> subTarefas);
}
