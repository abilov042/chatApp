package com.chatApp.core.webSocked.module;

import com.chatApp.entities.concretes.Message;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

//@Component
//@Slf4j
//public class SocketModule {
//
//    private final SocketIOServer socketIOServer;
//
//    public SocketModule(SocketIOServer socketIOServer) {
//        this.socketIOServer = socketIOServer;
//
//        socketIOServer.addConnectListener(onConnected());
//        socketIOServer.addDisconnectListener(onDisconnected());
//        socketIOServer.addEventListener("send_message", Message.class, onMessageReceived());
//    }
//
//    private DataListener<Message> onMessageReceived() {
//
//        return (senderClient, data, ackSender) -> {
//            log.info(String.format("%s -> %s",
//                    senderClient.getSessionId(), data.getMessage()));
//
//            String room = senderClient.getHandshakeData().getSingleUrlParam("room");
//
//
//
//            senderClient
//                    .getNamespace()
//                    .getRoomOperations(room)
//                    .getClients()
//                    .forEach(
//                            client -> {
//                                if(!client.getSessionId().equals(senderClient.getSessionId())){
//                                    client.sendEvent("get_message", data.getMessage());
//                                }
//                            }
//                    );
//        };
//    }
//
//    private ConnectListener onConnected() {
//        return client -> {
//            String room = client.getHandshakeData().getSingleUrlParam("room");
//            client.joinRoom(room);
//            client
//                    .getNamespace()
//                    .getRoomOperations(room)
//                    .sendEvent(
//                            "get_message",
//                            String.format("%s connected to -> %s", client.getSessionId(), room)
//                    );
//            log.info(String.format("SocketID: %s connected", client.getSessionId().toString()));
//        };
//    }
//
//    private DisconnectListener onDisconnected() {
//
//        return client -> {
//            String room = client.getHandshakeData().getSingleUrlParam("room");
//            //client.leaveRoom(room);
//            client
//                    .getNamespace()
//                    .getRoomOperations(room)
//                    .sendEvent(
//                            "get_message",
//                            String.format("%s disconnected from -> %s", client.getSessionId(), room)
//                    );
//            log.info(String.format("SocketID: %s disconnected", client.getSessionId().toString()));
//        };
//
//    }
//}