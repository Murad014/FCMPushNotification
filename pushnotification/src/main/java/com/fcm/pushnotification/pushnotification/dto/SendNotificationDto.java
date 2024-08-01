package com.fcm.pushnotification.pushnotification.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendNotificationDto {
    private String token;
    private String title;
    private String body;
}
