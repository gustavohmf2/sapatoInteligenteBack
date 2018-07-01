package br.com.sapatointeligente.services;

import br.com.sapatointeligente.models.Medico;
import br.com.sapatointeligente.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sapatointeligente.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    public Paciente save(Paciente paciente) {

        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAll() {

        return (List<Paciente>) pacienteRepository.findAll();
    }

    public Paciente getPaciente(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    public List<Paciente> getAllPacienteIdMedico(Integer idMedico) {

        return pacienteRepository.getAllPacienteForMedico(idMedico);
    }
}
