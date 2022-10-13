package by.step.zimin.emailservice.controller;
import by.step.zimin.emailservice.service.ServiceEmail;

import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/email")
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private ServiceEmail emailService;

    @GetMapping(value = "simple/{user-email}")     //http://localhost:8080/email/simple/az70019148@gmail.com
    public @ResponseBody ResponseEntity sendSimpleEmail(@PathVariable("user-email") String email) {

        try {
            emailService.sendEmail(email, "", "Hello !");
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    @GetMapping(value = "/attachment/{user-email}")   //http://localhost:8080/email/attachment/az70019148@gmail.com
    public @ResponseBody ResponseEntity sendEmailAttachment(@PathVariable("user-email") String email) {

        try {
            emailService.sendEmailWithAttachment(email, "Order Confirmation", "Thanks for your recent order",
                    "F:\\HibernateSpring\\Spring projects\\email-service\\src\\main\\java\\by\\step\\zimin\\emailservice\\file\\one.txt");
        } catch (FileNotFoundException | MessagingException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox for order confirmation", HttpStatus.OK);
    }
}
