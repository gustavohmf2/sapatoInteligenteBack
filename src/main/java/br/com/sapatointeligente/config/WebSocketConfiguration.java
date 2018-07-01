package br.com.sapatointeligente.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;

import java.io.IOException;
import java.util.Map;

/**
 * Classe de confifuração para o socket
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    /**
     * configuração para receber requisições de qualquer origem
     * O cliente enviará uma mensagem atravpes do http://localhost:8080/app/../..
     * só temos um subscribe(chat), os clientes irão assinar "chat" para esperar por
     * messagens do servidor
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/chat");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * configuração do endpoint para o cliente se conectar com o servidor
     * hhtp://localhost:8080/socket/
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket")
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
