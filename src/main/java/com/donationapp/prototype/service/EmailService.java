package com.donationapp.prototype.service;

import com.donationapp.prototype.config.token.email.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender {

    JavaMailSender mailSender;

    private final static Logger LOGGER= LoggerFactory.getLogger(EmailService.class);




    @Override
    @Async
    public void send(String to,String email){
        try{
            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("donationapp@donationapp.com");
            mailSender.send(mimeMessage);

        }catch(MessagingException e){
            LOGGER.error("Failed to send e-mail",e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
