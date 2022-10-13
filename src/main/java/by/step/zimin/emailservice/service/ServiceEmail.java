package by.step.zimin.emailservice.service;

import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface ServiceEmail {
    void sendEmail(String toAddress, String subject, String message);

    void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException;
}
