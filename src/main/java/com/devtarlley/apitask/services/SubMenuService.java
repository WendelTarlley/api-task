package com.devtarlley.apitask.services;

import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import com.devtarlley.apitask.mapper.SubMenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubMenuService {

    private SubMenuRepository subMenuRepository;
    private SubMenuMapper subMenuMapper;

    public SubMenuService(SubMenuRepository subMenuRepository, SubMenuMapper subMenuMapper) {
        this.subMenuRepository = subMenuRepository;
        this.subMenuMapper = subMenuMapper;
    }


    public List<SubMenuDTO> buscarTodosSubMenus() {
        return subMenuMapper.toDTO(this.subMenuRepository.findAll());
    }
}
