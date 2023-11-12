package com.devtarlley.apitask.services;

import com.devtarlley.apitask.domain.Menu;
import com.devtarlley.apitask.mapper.MenuMapper;
import com.devtarlley.apitask.dto.menu.MenuDTO;
import com.devtarlley.apitask.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private MenuMapper mapper;
    private MenuRepository menuRepository;
    public MenuService(MenuMapper mapper, MenuRepository menuRepository) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
    }

    public List<MenuDTO> getMenu(){
        List<Menu> all = this.menuRepository.findAll();
        return  mapper.toDTO(all);
    }

    public MenuDTO getMenuPorNome(String nomeMenu) {
        Menu menu = this.menuRepository.findByNome(nomeMenu)
                .orElseThrow();
        return mapper.toDTO(menu);
    }

    public MenuDTO salvarMenu(MenuDTO menuDTO) {
      return this.mapper.toDTO(this.menuRepository.save(mapper.toEntity(menuDTO)));
    }

    public void deletarMenu(Long id) {
        this.menuRepository.deleteById(id);
    }
}
