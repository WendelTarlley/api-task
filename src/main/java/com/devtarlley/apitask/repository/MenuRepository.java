package com.devtarlley.apitask.repository;

import com.devtarlley.apitask.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByNome(String nome);

}