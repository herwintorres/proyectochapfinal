package com.example.proyectochat.view;

import com.example.proyectochat.model.MessageModel;

import java.util.List;

public interface ChatContract {
    /**
     * Muestra la lista de conversaciones en la interfaz de usuario.
     * @param conversations Lista de modelos de mensajes que representan las conversaciones.
     */
    void showConversations(List<MessageModel> conversations); // Puedes cambiar el tipo de datos según lo que contenga una conversación

    /**
     * Muestra una confirmación de que el mensaje ha sido enviado correctamente.
     */
    void showMessageSentConfirmation();
}
