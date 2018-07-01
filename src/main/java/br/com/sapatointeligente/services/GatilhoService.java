package br.com.sapatointeligente.services;

import br.com.sapatointeligente.dto.GatilhoDTO;
import br.com.sapatointeligente.models.*;
import br.com.sapatointeligente.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GatilhoService {

    @Autowired
    private SapatoInteligenteRepository sapatoInteligenteRepository;
    @Autowired
    private GatilhoPesoRepository gatilhoPesoRepository;
    @Autowired
    private GatilhoPressaoRepository gatilhoPressaoRepository;
    @Autowired
    private GatilhoDistanciaRepository gatilhoDistanciaRepository;

    public void salvarGatilhoPeso(GatilhoPeso gatilhoPeso) {

        gatilhoPesoRepository.save(gatilhoPeso);
    }

    public void salvarGatilhoPressao(GatilhoPressao gatilhoPressao) {
        gatilhoPressaoRepository.save(gatilhoPressao);
    }

    public void salvarGatilhoPercurso(GatilhoPercurso gatilhoPercurso) {
        gatilhoDistanciaRepository.save(gatilhoPercurso);
    }

    public GatilhoDTO getAllByPaciente(String sapatoId) {


        GatilhoDTO gatilho = new GatilhoDTO();

        gatilho.setIdSapato(sapatoId);
        gatilho.setGatilhoPercursos(gatilhoDistanciaRepository.findAllByPaciente(sapatoId));
        gatilho.setGatilhoPesos(gatilhoPesoRepository.findAllByPaciente(sapatoId));
        gatilho.setGatilhoPressaos(gatilhoPressaoRepository.findAllByPaciente(sapatoId));

        return gatilho;
    }

}
