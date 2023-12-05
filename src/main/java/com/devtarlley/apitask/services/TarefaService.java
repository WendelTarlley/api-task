package com.devtarlley.apitask.services;

import com.devtarlley.apitask.dto.tarefa.TarefaDTO;
import com.devtarlley.apitask.enumerated.Status;
import com.devtarlley.apitask.mapper.TarefaMapper;
import com.devtarlley.apitask.repository.TarefaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;
    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }


    public TarefaDTO buscarTarefaPorId(Long idTarefa){
        return this.tarefaMapper.toDTO(this.tarefaRepository.findById(idTarefa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado a Tarefa de id: " + idTarefa)));
    }

    public List<TarefaDTO> buscarTodasAsTarefas(){
        return this.tarefaMapper.toDTO(this.tarefaRepository.findAll());
    }

    public List<TarefaDTO> buscarTarefasPorStatus(String status){

        return this.tarefaMapper.toDTO(this.tarefaRepository.findByStatus(Status.valueOf(status)));
    }
}
