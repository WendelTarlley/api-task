package com.devtarlley.apitask.mapper;

import com.devtarlley.apitask.domain.SubMenu;
import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubMenuMapper {

    SubMenu toEntity(SubMenuDTO subMenuDTO);

    SubMenuDTO toDTO(SubMenu submenu);

    List<SubMenu> toEntity(List<SubMenuDTO> subMenuDTO);

    List<SubMenuDTO> toDTO(List<SubMenu> submenu);
}
