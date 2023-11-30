package com.devtarlley.apitask.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idSubTarefa;

    private String nome;

    private Boolean finalizada;

    @ManyToOne
    @JoinColumn(name = "id_tarefa",nullable = false)
    private Tarefa tarefa;

}