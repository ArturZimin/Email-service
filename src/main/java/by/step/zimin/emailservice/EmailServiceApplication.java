package by.step.zimin.emailservice;

import by.step.zimin.emailservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailServiceApplication {

//    @Autowired
//    private EmailSenderService emailService;

    public static void main(String[] args) {

        SpringApplication.run(EmailServiceApplication.class, args);


    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail() {
//        emailService.sendEmail("az70019148@gmail.com", "this is subject", "Hi how are you?");
//    }

}


/**
 *
 * http://localhost:8080/email/order-email/umeshawasthi@www.javadevjournal.com
 * http://localhost:8080/email/simple-email/umeshawasthi@www.javadevjournal.com
 */