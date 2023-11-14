package com.devtarlley.apitask.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idMenu;

    private String nome;

    private String link;

    private String icone;

    @OneToMany(mappedBy = "menu")
    private List<SubMenu> submenu = new ArrayList<>();

}

