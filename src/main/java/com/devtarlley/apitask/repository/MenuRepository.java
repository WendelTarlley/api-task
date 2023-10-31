package com.devtarlley.apitask.repository;

import com.devtarlley.apitask.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}