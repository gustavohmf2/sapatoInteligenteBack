package br.com.sapatointeligente.services;

import br.com.sapatointeligente.models.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sapatointeligente.repository.MedicoRepository;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    public Medico save(Medico medico) {

        return medicoRepository.save(medico);
    }

    public List<Medico> getAll() {

        return (List<Medico>) medicoRepository.findAll();
    }

    public Medico findById(Integer idMedico) {

        return medicoRepository.findById(idMedico).get();
    }

}
