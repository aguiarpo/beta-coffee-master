package com.beta.coffee.betacoffee.endpoints;

import java.util.ArrayList;
import java.util.List;

import com.beta.coffee.betacoffee.models.User;
import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;
import com.beta.coffee.betacoffee.repository.UserRepository;
import com.beta.coffee.betacoffee.message.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class AdminEndpoints{

    private final UserRepository userDao;
    private Mailer mailer;

    @Autowired
    public AdminEndpoints(UserRepository userDao, Mailer mailer) {
        this.userDao = userDao;
        this.mailer = mailer;
    }


    @PostMapping(path = "message/wpp")
    public ResponseEntity<?> message(@RequestParam String number,
    @RequestParam String bodyText){
        Integer error = TwilioMessageWhatsapp.
        messageSend("whatsapp:+" + number, "O seu pedido foi realizado... " + bodyText);
        System.out.println("whatsapp:+" + number);
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @GetMapping(path = "message/email")
    public ResponseEntity<?> email(){
        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("eduardo.aguiarpo@gmail.com");
        sendEmail(recipients, "12345678");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Integer sendEmail(ArrayList<String> recipients, String body){
        try{
            mailer.submit(new EmailMessage("Suporte <suporte.animais.guaramirim@gmail.com>",
                    recipients, "Senha", "Senha -> " + body));
            return 1;
        }catch (MailException ignored){
            System.out.println(ignored + "erro");
            return 0;
        }
    }
} 