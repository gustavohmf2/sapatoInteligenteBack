package br.com.sapatointeligente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    /*
    private final SimpMessagingTemplate template;
    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }
    */
    /**
     * Mapear url para enviar a mensagem
     * a mensagem será enviado para todos os clientes que estão subscritos em /chat
     * @param message
     */
    @MessageMapping("/send/message")
    @SendTo("/chat/hi")
    public String onReceivedMessage(String message) {
        return new Date() + message;
    }
}
