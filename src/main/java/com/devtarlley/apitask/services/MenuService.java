package com.devtarlley.apitask.services;

import com.devtarlley.apitask.domain.SubMenu;
import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import com.devtarlley.apitask.dto.submenu.SubMenuDTORetornoSubMenu;
import com.devtarlley.apitask.mapper.MenuMapper;
import com.devtarlley.apitask.dto.menu.MenuDTO;
import com.devtarlley.apitask.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private MenuMapper mapper;
    private MenuRepository menuRepository;
    private SubMenuService subMenuService;
    public MenuService(MenuMapper mapper, MenuRepository menuRepository, SubMenuService subMenuService) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
        this.subMenuService = subMenuService;
    }

    public List<MenuDTO> getMenu(){
        return  mapper.toDTO(this.menuRepository.findAll());
    }

    public MenuDTO getMenuPorNome(String nomeMenu) {
        return mapper.toDTO(this.menuRepository.findByNome(nomeMenu)
                .orElseThrow());
    }

    public MenuDTO salvarMenu(MenuDTO menuDTO) {

        return this.mapper.toDTO(this.menuRepository.save(mapper.toEntity(menuDTO)));
    }

    public void deletarMenu(Long id) {
        this.menuRepository.deleteById(id);
    }

    public MenuDTO atualizarMenu(MenuDTO menuDTO){
        List<SubMenuDTORetornoSubMenu> submenu = menuDTO.submenu();
        List<Long> idsList;
        if (submenu != null && !submenu.isEmpty()){

            List<SubMenuDTO> subMenuDTOS = this.subMenuService.buscarSubMenuPorMenuId(menuDTO.idMenu());
            idsList = submenu.stream().map(SubMenuDTORetornoSubMenu::idSubMenu).toList();

            List<SubMenu> resultado = subMenuDTOS.stream().filter(
                    objeto -> !idsList.contains(objeto.idSubMenu())
            ).toList().stream().map(entity -> this.subMenuService.toEntity(entity)).toList();

            resultado.forEach(objeto -> objeto.setMenu(null));
            this.subMenuService.salvarSubMenu(resultado);
            List<SubMenu> list = submenu.stream().map(entity -> this.subMenuService.toEntity(entity)).toList();
            list.forEach(objeto -> objeto.setMenu(this.mapper.toEntity(menuDTO)));
            this.subMenuService.salvarSubMenu(list);
        }else{
            List<SubMenu> subMenuDTOS = this.subMenuService.buscarSubMenuPorMenuId(menuDTO.idMenu()).stream().map(entity -> this.subMenuService.toEntity(entity)).toList();
            subMenuDTOS.forEach(objeto -> objeto.setMenu(null));
            this.subMenuService.salvarSubMenu(subMenuDTOS);
        }
        return this.salvarMenu(menuDTO);

    }
}
