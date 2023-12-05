package com.devtarlley.apitask.dto.subtarefa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubTarefaDTO {

    private Long idSubTarefa;

    private String nome;

    private boolean finalizado;

    private Long idTarefa;
}
