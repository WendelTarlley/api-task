package com.devtarlley.apitask;

import com.devtarlley.apitask.domain.Menu;
import com.devtarlley.apitask.dto.menu.MenuDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    Menu toEntity(MenuDTO menuDTO);

    MenuDTO toDTO(Menu menu);

    List<Menu> toEntity(List<MenuDTO> menuDTO);

    List<MenuDTO> toDTO(List<Menu> menu);
}
