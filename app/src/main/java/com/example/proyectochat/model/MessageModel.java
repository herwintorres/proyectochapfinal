package com.example.proyectochat.model;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MessageModel {
    private String messageId;
    private String messageText;
    private String senderId;
    private String senderName;
    private Date timestamp;
    private String senderEmail;

    public MessageModel(){
        // Constructor vacío necesario para Firebase
    }
    // Constructor con los datos básicos del mensaje
    public MessageModel(String messageId, String messageText, String senderId, String senderName, Date timestamp) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
    }
    // Constructor con todos los datos del mensaje, incluyendo el correo electrónico del remitente
    public MessageModel(String messageId, String messageText, String senderId, String senderName, Date timestamp, String senderEmail) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
        this.senderEmail = senderEmail;
    }

    // Getter y setter para el correo electrónico del remitente
    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    // Getters y setters para los demás atributos
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
