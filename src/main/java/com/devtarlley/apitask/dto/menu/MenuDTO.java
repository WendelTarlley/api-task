package com.devtarlley.apitask.dto.menu;

import com.devtarlley.apitask.dto.submenu.SubMenuDTORetornoSubMenu;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MenuDTO(Long idMenu,
                      @NotBlank
                      String nome,
                      @NotBlank
                      String link,
                      @NotBlank
                      String icone,
                      List<SubMenuDTORetornoSubMenu> submenu) {
}
