package com.example.youtube.demo.service;

import com.example.youtube.demo.entity.NotificationEmail;
import com.example.youtube.demo.exception.YoutubeMailException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator messagePreparator=mimeMessage -> {
            MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("youtube.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());

        };
        try{
            javaMailSender.send(messagePreparator);
            log.info("Please activate your account.");
        }catch(MailException e){
            throw new YoutubeMailException("Exception while sending mail");
        }
    }
}
