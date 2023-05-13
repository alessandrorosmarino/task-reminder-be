package com.alessandro.rosmarino.task_reminder.web.controller;

import com.alessandro.rosmarino.task_reminder.web.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping("/testMail")
    public void sendTestMail() {
        mailSenderService.sendSimpleEmail("Test Simple", "Test");
    }
    @GetMapping("/testHTML")
    public void sendTestHTMLMail() {
        mailSenderService.sendHTMLEmail("Test HTML", "<h1>Test</h1>");
    }
}
