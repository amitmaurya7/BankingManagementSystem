package com.banking.reportingservice.service;

import lombok.extern.slf4j.Slf4j;
import model.NotificationEvent;
import model.NotificationEvent.NotificationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

	@Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void handleNotification(NotificationEvent event) {
        log.info("Received Notification Event: {}", event.toString());

        try {
            if (event.getType() == NotificationType.EMAIL) {
                sendEmail("amitmauryass163@gmail.com", event.getMessage());
            } else if (event.getType() == NotificationType.SMS) {
                // sendSms(user.getPhone(), event.getMessage()); // Uncomment if Twilio is configured
            }
            log.info("Notification sent successfully!");
        } catch (Exception e) {
            log.error("Notification failed: {}", e.getMessage());
        }
    }

    private void sendEmail(String email, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("springboot567@gmail.com");
            mailMessage.setTo(email);
            mailMessage.setSubject("Transaction Alert");
            mailMessage.setText(message);
            mailSender.send(mailMessage);
            log.info("Email sent to {}", email);
        } catch (Exception e) {
            log.error("Failed to send email to {}: {}", email, e.getMessage());
        }
    }

    private void sendSms(String phone, String message) {
        try {
            // twilioSmsService.sendSms(phone, message); // Uncomment if Twilio is configured
            log.info("SMS sent to {}", phone);
        } catch (Exception e) {
            log.error("Failed to send SMS to {}: {}", phone, e.getMessage());
        }
    }
}
