        package com.devtarlley.apitask.repository;

import com.devtarlley.apitask.domain.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
    Optional<SubMenu> findByNome(String nome);

    List<SubMenu> findByMenu_IdMenu(Long idMenu);

    List<SubMenu> findByMenuNull();


}