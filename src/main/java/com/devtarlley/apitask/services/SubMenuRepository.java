package com.devtarlley.apitask.services;

import com.devtarlley.apitask.domain.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
}