package com.devtarlley.apitask.controller;

import com.devtarlley.apitask.dto.tarefa.TarefaDTO;
import com.devtarlley.apitask.services.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTodasTarefas(){
        return ResponseEntity.ok(this.tarefaService.buscarTodasAsTarefas());
    }

    @GetMapping("/{idTarefa}")
    public ResponseEntity<TarefaDTO> buscarTarefaPorId(@PathVariable Long idTarefa){
        return ResponseEntity.ok(this.tarefaService.buscarTarefaPorId(idTarefa));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TarefaDTO>> buscarTarefasPorStatus(@PathVariable String status){
        return ResponseEntity.ok(this.tarefaService.buscarTarefasPorStatus(status));
    }
}
