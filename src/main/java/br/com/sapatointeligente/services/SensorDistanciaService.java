package br.com.sapatointeligente.services;

import br.com.sapatointeligente.models.*;
import br.com.sapatointeligente.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class SensorDistanciaService implements Runnable{

    @Autowired
    private SapatoInteligenteRepository sapatoInteligenteRepository;

    @Autowired
    private SensorDistanciaRepository sensorDistanciaoRepository;

    @Autowired
    private GatilhoDistanciaRepository gatilhoDistanciaRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public  boolean pressao = true;

    public Paciente paciente;

    private Thread worker;
    private AtomicBoolean running = new AtomicBoolean(false);
    private AtomicBoolean stopped = new AtomicBoolean(true);
    private int interval;

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    boolean isRunning() {
        return running.get();
    }

    boolean isStopped() {
        return stopped.get();
    }


    synchronized public void simularDistancia(Paciente paciente) {


        SapatoInteligente si =
                sapatoInteligenteRepository.findById(paciente.getSapatoInteligente().getId()).get();

        String saparoid = si.getId();

        //seta nova data de referencia para comparar os resultados capturados pelo sensor
        GatilhoPercurso gp = gatilhoDistanciaRepository.findBySapato(si.getId());

        gp.setDataInicio(new GregorianCalendar());

        gatilhoDistanciaRepository.save(gp);

        System.out.println("Simular");

        if(sensorDistanciaoRepository.findBySapato(paciente.getSapatoInteligente().getId()) == null) {

            sensorDistanciaoRepository.save(new SensorDistancia(true,
                    si,
                    new GregorianCalendar()));
        }



        this.paciente = paciente;



    }

    public Paciente getPaciente() {

        return this.paciente;
    }


    @Override
    public void run() {

        running.set(true);
        stopped.set(false);
        while (running.get()) {


            SensorDistancia sd = sensorDistanciaoRepository.findBySapato(paciente.getSapatoInteligente().getId());

            try {
                //valor gerado de até 1
                sd.setDistanciaPercorrida(sd.getDistanciaPercorrida() + new Random(1).nextFloat() );
                sd.setDtCaptura(new GregorianCalendar());

                comparaGatilho(sd);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");

            }


            System.out.println(sd);
            sensorDistanciaoRepository.save(sd);

        }
        stopped.set(true);
    }


    synchronized public void fimSimulacao() {

        pressao = false;
        try {

            this.wait();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    public void simularDistancia() {

    }

    public void simularPeso() {

    }

    public void comparaGatilho(SensorDistancia sensorDistancia) {

        GatilhoPercurso gp = gatilhoDistanciaRepository.findBySapato(sensorDistancia.getSapatoInteligente().getId());

        /**
         * CompareTo() return:
         * < 0 data menor
         * 0 datas iguais
         * > 0 data maior
         *
         * dataDiff é a diferença entre a ultima captura do sensor e a data que o gatilho começou a
         * capturar
         */
        Integer dataDiff = sensorDistancia.getDtCaptura().compareTo(gp.getDataInicio());
        //conversão do tempo em minutos
        Integer seconds = dataDiff/1000;
        Integer hora = seconds/3600;

        System.out.println("##########################################");
        System.out.println("Hora: "+hora);
        System.out.println("Tempo gatilho: "+gp.getTempo());
        System.out.println("Comparação: "+ sensorDistancia.getDistanciaPercorrida() +" " + gp.getDistMax());
        System.out.println("##########################################");

        if(gp != null && (sensorDistancia.getDistanciaPercorrida() > gp.getDistMax())
                && hora < gp.getTempo()){
            Notificacao not = notificacaoRepository.findByPaciente(paciente.getId());

            if(not == null) {

                System.out.println("#### Notificação de Gatilho ####");
                notificacaoRepository.save(new Notificacao(
                        paciente,
                        null,
                        new GregorianCalendar(),
                        "Gatilho Distância",
                        false,
                        "Você passou da quantidade máxima permitida de deslocamento"
                ));
            }

            not.setRepeticao(not.getRepeticao() + 1);
            notificacaoRepository.save(not);

            //zera a distancia para uma nova contabilidade
            sensorDistancia.setDistanciaPercorrida(new Float(0));
            sensorDistanciaoRepository.save(sensorDistancia);

            //reiniciao momento de captura
            gp.setDataInicio(new GregorianCalendar());
            gatilhoDistanciaRepository.save(gp);
        }

    }

}
