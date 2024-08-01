package com.fcm.pushnotification.pushnotification.service;


import com.fcm.pushnotification.pushnotification.dto.SendNotificationDto;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FcmService {


    public String sendMessage(SendNotificationDto sendNotificationDto) throws Exception {
        Message message = Message.builder()
                .setToken(sendNotificationDto.getToken())
                .setNotification(Notification.builder()
                        .setTitle(sendNotificationDto.getTitle())
                        .setBody(sendNotificationDto.getBody())
                        .build()
                )
                .build();


        return FirebaseMessaging.getInstance().send(message);
    }


}