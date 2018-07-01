package br.com.sapatointeligente.controllers;

import br.com.sapatointeligente.models.Paciente;
import br.com.sapatointeligente.models.SapatoInteligente;
import br.com.sapatointeligente.models.SensorDistancia;
import br.com.sapatointeligente.responses.Response;
import br.com.sapatointeligente.services.PacienteService;
import br.com.sapatointeligente.services.SapatoService;
import br.com.sapatointeligente.services.SensorDistanciaService;
import br.com.sapatointeligente.services.SensorService;
import br.com.sapatointeligente.utils.SapatoTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping("/sapato")
public class SapatoController {

    @Autowired
    private SapatoService sapatoService;
    
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorDistanciaService sensorDistanciaService;


    @GetMapping(value = "/simularsapato{pacienteid}")
    public ResponseEntity<Response<String>> simularCapturaDados(@RequestParam(value = "pacienteid") Integer pacienteid) {

        Response<String> response = new Response<String>();


        Paciente paciente = pacienteService.getPaciente(pacienteid);
        sensorService.simularPressao(paciente);


        sensorService.start();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/fimsimularsapato{pacienteid}")
    public ResponseEntity<Response<String>> fimSimularCapturaDados(@RequestParam(value = "pacienteid") Integer pacienteid) throws InterruptedException {

        Response<String> response = new Response<String>();

        sensorService.interrupt();

        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "/simularsapatopercurso{pacienteid}")
    public ResponseEntity<Response<String>> simularSapatoPercurso(@RequestParam(value = "pacienteid") Integer pacienteid) {

        Response<String> response = new Response<String>();


        Paciente paciente = pacienteService.getPaciente(pacienteid);
        sensorDistanciaService.simularDistancia(paciente);


        sensorDistanciaService.start();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/fimsimularsapatopercurso{pacienteid}")
    public ResponseEntity<Response<String>> fimSimularSapatoPercurso(@RequestParam(value = "pacienteid") Integer pacienteid) throws InterruptedException {

        Response<String> response = new Response<String>();

        sensorDistanciaService.interrupt();

        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<Response<SapatoInteligente>> save(@RequestBody SapatoInteligente sapatoInteligente) {

        Response<SapatoInteligente> response = new Response<SapatoInteligente>();

        response.setData(sapatoService.salvar(sapatoInteligente));

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<Response<List<SapatoInteligente>>> getAll() {

        Response<List<SapatoInteligente>> response = new Response<List<SapatoInteligente>>();

        response.setData(sapatoService.getAll());

        return ResponseEntity.ok(response);
    }
}
