package com.alessandro.rosmarino.task_reminder.web.service;

import com.alessandro.rosmarino.task_reminder.mail.TaskMailSender;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {

    @Autowired
    private TaskMailSender taskMailSender;

    public void sendSimpleEmail(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(taskMailSender.getJavaMailProperties().getProperty("mail.smtp.from"));
        message.setTo(taskMailSender.getUsername());
        message.setSubject(subject);
        message.setText(text);
        taskMailSender.send(message);
    }

    public void sendHTMLEmail(String subject, String text) {
        MimeMessage message = taskMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom(taskMailSender.getJavaMailProperties().getProperty("mail.smtp.from"));
            helper.setTo(taskMailSender.getUsername());
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        taskMailSender.send(message);
    }
}
