package br.com.sapatointeligente.controllers;

import br.com.sapatointeligente.dto.GatilhoDTO;
import br.com.sapatointeligente.models.*;
import br.com.sapatointeligente.responses.Response;
import br.com.sapatointeligente.services.GatilhoService;
import br.com.sapatointeligente.services.SapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gatilho")
public class GatilhoController {

    @Autowired
    private GatilhoService gatilhoService;
    @Autowired
    private SapatoService sapatoService;


    @PostMapping("/peso{idSapato}")
    public void salvarGatilhoPeso(@RequestParam(value = "idSapato") String idSapato, @RequestBody GatilhoPeso gatilhoPeso) {

        System.out.println(idSapato);
        SapatoInteligente si = sapatoService.getById(idSapato);
        gatilhoPeso.setSapatoInteligente(si);
        gatilhoService.salvarGatilhoPeso(gatilhoPeso);
    }

    @PostMapping("/pressao{idSapato}")
    public void salvarGatilhoPressao(@RequestParam(value = "idSapato") String idSapato,@RequestBody GatilhoPressao gatilhoPressao) {

        System.out.println(idSapato);
        SapatoInteligente si = sapatoService.getById(idSapato);
        gatilhoPressao.setSapatoInteligente(si);
        gatilhoService.salvarGatilhoPressao(gatilhoPressao);
    }

    @PostMapping("/distancia{idSapato}")
    public void salvarGatilhoDistancia(@RequestParam(value = "idSapato") String idSapato,@RequestBody GatilhoPercurso gatilhoPercurso) {

        System.out.println(idSapato);
        SapatoInteligente si = sapatoService.getById(idSapato);
        gatilhoPercurso.setSapatoInteligente(si);
        gatilhoService.salvarGatilhoPercurso(gatilhoPercurso);
    }

    @GetMapping("/gatilhoPaciente{idSapato}")
    public ResponseEntity<Response<GatilhoDTO>> getAllGatilhos(@RequestParam(value = "idSapato") String sapatoId) {

        Response<GatilhoDTO> response = new Response<GatilhoDTO>();

        response.setData(gatilhoService.getAllByPaciente(sapatoId));

        return ResponseEntity.ok(response);
    }
}
