package br.com.sapatointeligente.services;

import br.com.sapatointeligente.dto.GatilhoDTO;
import br.com.sapatointeligente.models.Notificacao;
import br.com.sapatointeligente.models.Paciente;
import br.com.sapatointeligente.models.SapatoInteligente;
import br.com.sapatointeligente.repository.NotificacaoRepository;
import br.com.sapatointeligente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService extends Thread{


    @Autowired
    private SensorService sensorService;
    @Autowired
    private GatilhoService gatilhoService;

    @Autowired
    private NotificacaoRepository notificacaoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    private String idSapato;


    synchronized public void monitorar(String idSapato) {
        this.idSapato = idSapato;
    }

    @Override
    public void run() {

        Paciente paciente = pacienteRepository.findBySapatoId(idSapato);

        while (true) {
            GatilhoDTO gatilho = gatilhoService.getAllByPaciente(idSapato);

            if(gatilho.getGatilhoPressaos() != null) {
                gatilho.getGatilhoPressaos().forEach(
                        gatilhoPressao -> {
                        }
                );
            }



            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
