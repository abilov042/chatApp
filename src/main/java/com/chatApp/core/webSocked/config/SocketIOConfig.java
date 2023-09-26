package com.chatApp.core.webSocked.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class SocketIOConfig {
//
//    @Value("${socket-io-server.hostname}")
//    private String hostname;
//
//    @Value("${socket-io-server.port}")
//    private int port;
//
//
//    @Bean
//    public SocketIOServer sockedIoService(){
//
//        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
//        config.setHostname(hostname);
//        config.setPort(port);
//        config.setOrigin("*");
//        return new SocketIOServer(config);
//    }
//}
