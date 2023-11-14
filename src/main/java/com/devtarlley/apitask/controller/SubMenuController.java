package com.devtarlley.apitask.controller;

import com.devtarlley.apitask.dto.submenu.SubMenuDTO;
import com.devtarlley.apitask.services.SubMenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @GetMapping("/semMenu")
    public ResponseEntity<List<SubMenuDTO>> buscarSubMenusSemMenu(){
        return ResponseEntity.ok().body(this.subMenuService.buscarSubMenusSemMenu());
    }

    @GetMapping("/porNome")
    public ResponseEntity<SubMenuDTO> buscarSubMenuPorNome(@RequestParam String subMenu){
        return ResponseEntity.ok().body(subMenuService.buscarSubMenuPorNome(subMenu));
    }

    @PostMapping
    public ResponseEntity<SubMenuDTO> salvarSubMenu(@RequestBody @Valid SubMenuDTO subMenuDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(subMenuDTO)
                .toUri();
        return ResponseEntity.created(uri).body(this.subMenuService.salvarSubMenu(subMenuDTO));
    }

   @PostMapping("/atualizar")
    public ResponseEntity<SubMenuDTO> salvarAlteracaoSubMenu(@RequestBody @Valid SubMenuDTO subMenuDTO){

        return ResponseEntity.ok().body(this.subMenuService.salvarSubMenu(subMenuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMenu(@PathVariable Long id){
        this.subMenuService.deletarMenu(id);
        return ResponseEntity.accepted().build();
    }
}
