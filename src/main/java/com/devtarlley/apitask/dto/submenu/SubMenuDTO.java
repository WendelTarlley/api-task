package com.devtarlley.apitask.dto.submenu;

import com.devtarlley.apitask.dto.menu.MenuDTORetornoSubMenu;
import jakarta.validation.constraints.NotBlank;

public record SubMenuDTO(Long idSubMenu, @NotBlank String nome,@NotBlank String nomeComponente, MenuDTORetornoSubMenu menu) {
}
