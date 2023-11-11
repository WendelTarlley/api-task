package com.devtarlley.apitask.dto.menu;

import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MenuDTO(Long id,
                      @NotBlank
                      String nome,
                      @NotBlank
                      String link,
                      @NotBlank
                      String icone,
                      List<SubMenuDTO> submenu) {
}
