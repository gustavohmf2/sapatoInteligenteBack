package br.com.sapatointeligente.services;

import br.com.sapatointeligente.models.Paciente;
import br.com.sapatointeligente.models.SapatoInteligente;
import br.com.sapatointeligente.models.SensorPressao;
import br.com.sapatointeligente.repository.SapatoInteligenteRepository;
import br.com.sapatointeligente.repository.SensorPressaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.Thread.sleep;

@Service
public class SapatoService {

    @Autowired
    private SapatoInteligenteRepository sapatoInteligenteRepository;

    public SapatoInteligente salvar(SapatoInteligente sapatoInteligente) {

        return sapatoInteligenteRepository.save(sapatoInteligente);
    }

    public List<SapatoInteligente> getAll() {

        return (List<SapatoInteligente>) sapatoInteligenteRepository.findAll();
    }

    public SapatoInteligente getById(String id) {

        return sapatoInteligenteRepository.findById(id).get();
    }

}
