package com.devtarlley.apitask.services;

import com.devtarlley.apitask.dto.subtarefa.SubTarefaDTO;
import com.devtarlley.apitask.mapper.SubTarefaMapper;
import com.devtarlley.apitask.repository.SubTarefaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubTarefaService {

    private final SubTarefaRepository subTarefaRepository;
    private final SubTarefaMapper subTarefaMapper;
    public SubTarefaService(SubTarefaRepository subTarefaRepository, SubTarefaMapper subTarefaMapper) {
        this.subTarefaRepository = subTarefaRepository;
        this.subTarefaMapper = subTarefaMapper;
    }

    public SubTarefaDTO buscarSubTarefaPorId(Long idSubTarefa){
        return this.subTarefaMapper.toDTO(this.subTarefaRepository.findById(idSubTarefa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não encontrado subtarefa com id: "+idSubTarefa)));
    }

    public List<SubTarefaDTO> buscarTodasSubTarefas(){
        return this.subTarefaMapper.toDTO(this.subTarefaRepository.findAll());
    }

    public List<SubTarefaDTO> buscarSubTarefasPorIdTarefa(Long idTarefa){
        return this.subTarefaMapper.toDTO(this.subTarefaRepository.findByTarefa_IdTarefa(idTarefa));
    }
}
