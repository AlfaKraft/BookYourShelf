package com.tieto.bookyourshelf.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    public MailSender mailSender;
    private SimpleMailMessage templateMessage;



    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    @Scheduled(fixedRate=10000)
    public void sendNotification() {
        System.out.println("I will execute after evey 10 seconds");

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        //msg.setTo(order.getCustomer().getEmailAddress());
        msg.setTo("jaaktamm@live.com");

        msg.setText(
                "test message ");
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
