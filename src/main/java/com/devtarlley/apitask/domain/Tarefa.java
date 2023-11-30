package com.devtarlley.apitask.domain;

import com.devtarlley.apitask.enumerated.Status;
import jakarta.persistence.*;
import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa", nullable = false)
    private Long idTarefa;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Status status;

//    @ManyToOne
//    @JoinColumn(name = "responsavel_id")
//    private Usuario responsavel;

//    private List<Usuario> participantes;

    @OneToMany(mappedBy = "tarefa",cascade = CascadeType.ALL)
    private List<SubTarefa> subTarefas;

//    private DateTime criadoEm;
//
//    private DateTime tempoDeTarefa;
//
//    private DateTime finalizadoEm;

}
