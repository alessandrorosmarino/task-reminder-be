package com.alessandro.rosmarino.task_reminder.mail;

import com.alessandro.rosmarino.task_reminder.web.configuration.TaskMailConfiguration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class TaskMailSender extends JavaMailSenderImpl {

    public TaskMailSender(TaskMailConfiguration taskMailConfiguration) {
        super();
        this.setHost(taskMailConfiguration.getHost());
        this.setPort(taskMailConfiguration.getPort());
        this.setUsername(taskMailConfiguration.getUsername());
        this.setPassword(taskMailConfiguration.getPassword());

        Properties props = getJavaMailProperties();
        props.put("mail.transport.protocol", taskMailConfiguration.getProtocol());
        props.put("mail.smtp.auth", taskMailConfiguration.getAuth());
        props.put("mail.smtp.starttls.enable", taskMailConfiguration.getStarttls());
        props.put("mail.debug", taskMailConfiguration.getDebug());
        props.put("mail.smtp.from", taskMailConfiguration.getFrom());
    }
}
