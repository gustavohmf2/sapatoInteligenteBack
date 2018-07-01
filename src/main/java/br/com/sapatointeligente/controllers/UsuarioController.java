package br.com.sapatointeligente.controllers;

import br.com.sapatointeligente.dto.SincSapatoDTO;
import br.com.sapatointeligente.models.Medico;
import br.com.sapatointeligente.models.Paciente;
import br.com.sapatointeligente.models.SapatoInteligente;
import br.com.sapatointeligente.responses.Response;
import br.com.sapatointeligente.services.SapatoService;
import br.com.sapatointeligente.udpconnection.UDPServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.com.sapatointeligente.services.MedicoService;
import br.com.sapatointeligente.services.PacienteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private SapatoService sapatoService;

    @Autowired
    private UDPServer udpServer;

    @GetMapping("/paciente")
    public ResponseEntity<Response<List<Paciente>>> getAllPaciente() {

        Response<List<Paciente>> response = new Response<List<Paciente>>();

        List<Paciente> listTemp = pacienteService.getAll();

        response.setData(listTemp);

        return ResponseEntity.ok(response);
    }



    @PostMapping("/paciente")
    public ResponseEntity<Response<Paciente>> salvaPaciente(@Valid @RequestBody Paciente paciente, BindingResult bindingResult) {

        Response<Paciente> response = new Response<Paciente>();

        /**
         * verificando se a validação está correta, caso contrário retorna o erro na resposta da
         * requisição
         */
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(pacienteService.save(paciente));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/paciente/medico{idMedico}")
    public ResponseEntity<Response<List<Paciente>>> getAllPacientes(@RequestParam(value = "idMedico") Integer idMedico) {

        Response<List<Paciente>> response = new Response<List<Paciente>>();

        //List<Paciente> pacientes = medicoService.findById(idMedico).getPacientes()

        response.setData(pacienteService.getAllPacienteIdMedico(idMedico));

        return ResponseEntity.ok(response);
    }

    /**
     *
     * @param paciente
     * @return Resposta encapsulando sucesso ou erro da requisição
     */
    @PostMapping("/paciente/medico{idMedico}")
    public ResponseEntity<Response<Paciente>> salvaPaciente(@RequestParam(value="idMedico") Integer idMedico , @Valid @RequestBody Paciente paciente, BindingResult bindingResult) {

        Response<Paciente> response = new Response<Paciente>();

        System.out.println("Salvar novo paciente: "+ paciente.getNome());

        Medico medico = medicoService.findById(idMedico);

        medico.addPaciente(paciente);

        /**
         * verificando se a validação está correta, caso contrário retorna o erro na resposta da
         * requisição
         */
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(pacienteService.save(paciente));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/medico")
    public ResponseEntity<Response<List<Medico>>> getAllMedico() {

        Response<List<Medico>> response = new Response<List<Medico>>();

        response.setData(medicoService.getAll());

        return ResponseEntity.ok(response);
    }



    @PostMapping("/medico")
    public ResponseEntity<Response<Medico>> salvaMedico(@Valid @RequestBody Medico medico, BindingResult bindingResult) {

        Response<Medico> response = new Response<Medico>();

        /**
         * Iteração sobre o objeto bindResult que armazena o resultado da validação do objeto
         * adiciona os erros ao response caso exita
         * ao fim retorna erro na requisição adicionando os erros ao response
         */
        if(bindingResult.hasErrors()) {

            if(!bindingResult.getAllErrors().isEmpty()) {
                bindingResult.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
        }

        response.setData(medicoService.save(medico));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/paciente/sincSapato")
    public ResponseEntity<Response<String>> sincronizarSapato(@RequestBody SincSapatoDTO sincSapatoDTO) {

        Response<String> response = new Response<String>();



        System.out.println("Sincronizar sapato: "+ sincSapatoDTO.getIdSapato() + " com " + sincSapatoDTO.getIdPaciente());

        SapatoInteligente sapatoInteligente = sapatoService.getById(sincSapatoDTO.getIdSapato());

        Paciente paciente = pacienteService.getPaciente(sincSapatoDTO.getIdPaciente());

            paciente.setSapatoInteligente(sapatoInteligente);

            if(pacienteService.save(paciente) != null) {
                response.setData("Sincronização realizada");
            }else{
                response.setData("Falha na Sincronização");
            }

        return ResponseEntity.ok(response);
    }

    @GetMapping("testeudp")
    public void testeUDP() {

        System.out.println("UDP SERVER");
        udpServer.start();

    }

}
