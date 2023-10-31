package com.devtarlley.apitask.services;

import com.devtarlley.apitask.MenuMapper;
import com.devtarlley.apitask.domain.Menu;
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
        return  mapper.toDTO(this.menuRepository.findAll());
    }

}
