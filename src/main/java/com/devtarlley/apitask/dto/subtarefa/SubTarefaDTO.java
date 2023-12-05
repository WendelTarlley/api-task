package com.devtarlley.apitask.dto.subtarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubTarefaDTO {

    @NotNull
    private Long idSubTarefa;

    @NotBlank
    private String nome;

    @NotNull
    private Boolean finalizada;

    @NotNull
    private Long idTarefa;
}
