package com.galid.mail.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @RabbitListener(queues = "mail.queue")
    public void receiveMessage(String message) {
        System.out.println("메일발송 !");
    }
}
