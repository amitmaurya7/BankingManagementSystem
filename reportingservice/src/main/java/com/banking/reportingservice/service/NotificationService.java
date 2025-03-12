package com.banking.reportingservice.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.banking.reportingservice.dto.NotificationEvent;
import com.banking.reportingservice.dto.NotificationEvent.NotificationType;

@Service
@Slf4j
public class NotificationService {

private final JavaMailSender mailSender = null;
//    private final TwilioSmsService twilioSmsService;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void handleNotification(NotificationEvent event) {
        log.info("Received Notification Event for user {}", event.getUserId());

        // Fetch user details from User Service
//        UserResponse user = userClient.getUserDetails(event.getUserId());

        try {
            if (event.getType() == NotificationType.EMAIL) {
                sendEmail("amitmauryass163@gmail.com", event.getMessage());
            } else if (event.getType() == NotificationType.SMS) {
//                sendSms(user.getPhone(), event.getMessage());
            }
            log.info("Notification sent successfully!");
        } catch (Exception e) {
            log.error("Notification failed: {}", e.getMessage());
        }
    }

    private void sendEmail(String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Transaction Alert");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
        log.info("Email sent to {}", email);
    }

    private void sendSms(String phone, String message) {
//        twilioSmsService.sendSms(phone, message);
        log.info("SMS sent to {}", phone);
    }
}
