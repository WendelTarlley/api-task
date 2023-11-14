package com.devtarlley.apitask.mapper;

import com.devtarlley.apitask.domain.SubMenu;
import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import com.devtarlley.apitask.dto.submenu.SubMenuDTORetornoSubMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface SubMenuMapper {

    SubMenu toEntity(SubMenuDTO subMenuDTO);

    @Mapping(target = "menu", source = "menu")
    SubMenuDTO toDTO(SubMenu submenu);

    List<SubMenu> toEntity(List<SubMenuDTO> subMenuDTO);

    List<SubMenuDTO> toDTO(List<SubMenu> submenu);

    SubMenuDTO toDTO(SubMenuDTORetornoSubMenu subMenuDTORetornoSubMenu);

    SubMenuDTORetornoSubMenu toDTORetornoSubMenu(SubMenuDTO subMenuDTO);

    SubMenu toEntity(SubMenuDTORetornoSubMenu subMenuDTORetornoSubMenu);
}
