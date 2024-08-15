package com.example.proyectochat.presenter;

import com.example.proyectochat.model.UserModel;

public interface ChatPresenter {
    // Método para cargar las conversaciones entre dos usuarios
    // @param user1 El primer usuario
    // @param user2 El segundo usuario
    void loadConversations(UserModel user1, UserModel user2);

    // Método para enviar un mensaje entre dos usuarios
    // @param messageText El texto del mensaje
    // @param user1 El primer usuario
    // @param user2 El segundo usuario
    void sendMessage(String messageText, UserModel user1, UserModel user2);
}
