package com.fcm.pushnotification.pushnotification.controller;


import com.fcm.pushnotification.pushnotification.dto.SendNotificationDto;
import com.fcm.pushnotification.pushnotification.service.FcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class SendNotificationController {

    private final FcmService fcmService;

    @Autowired
    public SendNotificationController(FcmService fcmService) {
        this.fcmService = fcmService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendByToken(@RequestBody SendNotificationDto sendNotificationDto) throws Exception {
        String message = fcmService.sendMessage(sendNotificationDto);

        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}
