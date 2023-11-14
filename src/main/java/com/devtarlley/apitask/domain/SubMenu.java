package com.devtarlley.apitask.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "submenu")
@Data
public class SubMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idSubMenu;

    private String nome;

    @Column(name = "nome_componente")
    private String nomeComponente;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

}
