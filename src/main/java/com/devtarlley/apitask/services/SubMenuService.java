package com.devtarlley.apitask.services;

import com.devtarlley.apitask.domain.SubMenu;
import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import com.devtarlley.apitask.dto.submenu.SubMenuDTORetornoSubMenu;
import com.devtarlley.apitask.mapper.SubMenuMapper;
import com.devtarlley.apitask.repository.SubMenuRepository;
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

    public SubMenuDTO buscarSubMenuPorNome(String subMenu) {
        return subMenuMapper.toDTO(this.subMenuRepository.findByNome(subMenu)
                .orElseThrow());
    }

    public SubMenuDTO salvarSubMenu(SubMenuDTO subMenuDTO) {
        return this.subMenuMapper.toDTO(this.subMenuRepository.save(subMenuMapper.toEntity(subMenuDTO)));
    }

    public void salvarSubMenu(SubMenu subMenu){
        this.subMenuRepository.save(subMenu);
    }

    public List<SubMenuDTO> buscarSubMenuPorMenuId(Long menuId){
        return this.subMenuMapper.toDTO(this.subMenuRepository.findByMenu_IdMenu(menuId));
    }
    public void deletarMenu(Long id) {
        this.subMenuRepository.deleteById(id);
    }

    public SubMenu toEntity(SubMenuDTO subMenuDTO) {
        return this.subMenuMapper.toEntity(subMenuDTO);
    }

    public void salvarSubMenu(List<SubMenu> resultado) {
        resultado.forEach(this::salvarSubMenu);
    }

    public SubMenu toEntity(SubMenuDTORetornoSubMenu subMenuDTORetornoSubMenu) {
     return   this.subMenuMapper.toEntity(subMenuDTORetornoSubMenu);
    }

    public List<SubMenuDTO> buscarSubMenusSemMenu() {
        return this.subMenuMapper.toDTO(this.subMenuRepository.findByMenuNull());
    }
}
