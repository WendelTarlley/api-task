package com.devtarlley.apitask.controller;

import com.devtarlley.apitask.dto.subtarefa.SubTarefaDTO;
import com.devtarlley.apitask.services.SubTarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/atualizarSubTarefa")
    public ResponseEntity<Void> atualizarSubTarefa(@RequestBody @Valid SubTarefaDTO subTarefaDTO){
            this.subTarefaService.atualizarSubTarefa(subTarefaDTO);
        return ResponseEntity.ok().build();
    }
    @PatchMapping
    public ResponseEntity<Void> atualizarSubTarefas(@RequestBody @Valid List<SubTarefaDTO> subTarefaDTOS){
            this.subTarefaService.atualizarSubTarefas(subTarefaDTOS);
        return ResponseEntity.ok().build();
    }
}
