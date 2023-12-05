package com.devtarlley.apitask.dto.tarefa;

import com.devtarlley.apitask.dto.subtarefa.SubTarefaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TarefaDTO {

    private Long idTarefa;

    private String nome;

    private List<SubTarefaDTO> subTarefas;
}
