package com.devtarlley.apitask.controller;

import com.devtarlley.apitask.dto.menu.MenuDTO;
import com.devtarlley.apitask.services.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<MenuDTO>> getMenu(){
        return ResponseEntity.ok().body(menuService.getMenu());
    }

    @GetMapping("/porNome")
    public ResponseEntity<MenuDTO> getMenuPorNome(@RequestParam String nomeMenu){
        return ResponseEntity.ok().body(menuService.getMenuPorNome(nomeMenu));
    }

    @PostMapping
    public ResponseEntity<MenuDTO> salvarMenu(@RequestBody @Valid MenuDTO menuDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(menuDTO)
                .toUri();
        return ResponseEntity.created(uri).body(this.menuService.salvarMenu(menuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMenu(@PathVariable Long id){
        this.menuService.deletarMenu(id);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping
    public ResponseEntity<MenuDTO> atualizarMenu(@RequestBody @Valid MenuDTO menuDTO){

        return ResponseEntity.ok().body(this.menuService.salvarMenu(menuDTO));
    }
}
