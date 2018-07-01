package br.com.sapatointeligente.services;

import br.com.sapatointeligente.models.*;
import br.com.sapatointeligente.repository.GatilhoPressaoRepository;
import br.com.sapatointeligente.repository.NotificacaoRepository;
import br.com.sapatointeligente.repository.SapatoInteligenteRepository;
import br.com.sapatointeligente.repository.SensorPressaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class SensorService implements Runnable{

    @Autowired
    private  SapatoInteligenteRepository sapatoInteligenteRepository;

    @Autowired
    private  SensorPressaoRepository sensorPressaoRepository;

    @Autowired
    private GatilhoPressaoRepository gatilhoPressaoRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public  boolean pressao = true;

    public  Paciente paciente;

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


    synchronized public void simularPressao(Paciente paciente) {

        Optional<SapatoInteligente> si =
                sapatoInteligenteRepository.findById("id-000000001");

        SapatoInteligente s = si.get();

        System.out.println("Simular");

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

                SensorPressao sp = null;
                try {
                    sp = new SensorPressao(
                            getPaciente().getSapatoInteligente(),
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new Random().nextInt(100)+20,
                            new GregorianCalendar());

                        comparaGatilho(sp);

                            Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted, Failed to complete operation");

                }


                System.out.println(sp);
                sensorPressaoRepository.save(sp);

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

    public void comparaGatilho(SensorPressao sensorPressao) {

        GatilhoPressao gp = gatilhoPressaoRepository.findByPaciente(sensorPressao.getSapatoInteligente().getId());

        if(gp != null && gp.getCount() <= 0){

            System.out.println("#### Notificação de Gatilho ####");
            notificacaoRepository.save(new Notificacao(
                    paciente,
                    null,
                    new GregorianCalendar(),
                    "Gatilho Pressão",
                    false,
                    "Valores excederão o permitido"
            ));

        }
        else if(sensorPressao.getD1() > gp.getD1()
        && sensorPressao.getD2() > gp.getD2()
        && sensorPressao.getD3() > gp.getD3()
        && sensorPressao.getD4() > gp.getD4()
        && sensorPressao.getD5() > gp.getD5()
        && sensorPressao.getD6() > gp.getD6()
        ) {

                gp.setCount(gp.getCount() - 1);
                gatilhoPressaoRepository.save(gp);
        }else if(sensorPressao.getE1() > gp.getE1()
                && sensorPressao.getE2() > gp.getE2()
                && sensorPressao.getE3() > gp.getE3()
                && sensorPressao.getE4() > gp.getE4()
                && sensorPressao.getE5() > gp.getE5()
                && sensorPressao.getE6() > gp.getE6()) {
            gp.setCount(gp.getCount() - 1);
            gatilhoPressaoRepository.save(gp);
        }

    }

}
