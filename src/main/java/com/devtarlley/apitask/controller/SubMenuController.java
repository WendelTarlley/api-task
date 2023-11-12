package com.devtarlley.apitask.controller;

import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import com.devtarlley.apitask.services.SubMenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submenu")
public class SubMenuController {

    private SubMenuService subMenuService;

    public SubMenuController(SubMenuService subMenuService) {
        this.subMenuService = subMenuService;
    }

    @GetMapping
    public ResponseEntity<List<SubMenuDTO>> buscarTodosSubMenus(){
        return ResponseEntity.ok().body(this.subMenuService.buscarTodosSubMenus());
    }
}
