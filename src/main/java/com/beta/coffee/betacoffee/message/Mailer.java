package com.beta.coffee.betacoffee.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mailer  { // Classe de configuração do email

    private JavaMailSender javaMailSender;

    @Autowired
    public Mailer(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void submit(EmailMessage emailMessage) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(emailMessage.getSender());
        simpleMailMessage.setTo(emailMessage.getRecipients()
                .toArray(new String[0]));
        simpleMailMessage.setSubject(emailMessage.getSubject());
        simpleMailMessage.setText(emailMessage.getBody());

        javaMailSender.send(simpleMailMessage);
    }
}