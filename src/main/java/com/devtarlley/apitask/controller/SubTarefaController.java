package com.devtarlley.apitask.controller;

import com.devtarlley.apitask.dto.subtarefa.SubTarefaDTO;
import com.devtarlley.apitask.services.SubTarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subtarefa")
public class SubTarefaController {

    private final SubTarefaService subTarefaService;

    public SubTarefaController(SubTarefaService subTarefaService) {
        this.subTarefaService = subTarefaService;
    }

    @GetMapping
    public ResponseEntity<List<SubTarefaDTO>> buscarTodasSubTarefas(){
        return ResponseEntity.ok(this.subTarefaService.buscarTodasSubTarefas());
    }

    @GetMapping("/porIdSubTarefa/{idSubTarefa}")
    public ResponseEntity<SubTarefaDTO> buscarSubTarefaPorId(@PathVariable Long idSubTarefa){
        return ResponseEntity.ok(this.subTarefaService.buscarSubTarefaPorId(idSubTarefa));
    }

    @GetMapping("/porIdTarefa/{idTarefa}")
    public ResponseEntity<List<SubTarefaDTO>> buscarSubTarefasPorIdTarefa(@PathVariable Long idTarefa){
        return ResponseEntity.ok(this.subTarefaService.buscarSubTarefasPorIdTarefa(idTarefa));
    }
}
