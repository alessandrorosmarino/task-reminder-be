package com.alessandro.rosmarino.task_reminder.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaskMailConfiguration {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String protocol;
    private final String auth;
    private final String starttls;
    private final String debug;
    private final String from;

    public TaskMailConfiguration(@Value("${spring.mail.host}") String host,
                                 @Value("${spring.mail.port}") int port,
                                 @Value("${spring.mail.username}") String username,
                                 @Value("${spring.mail.password}") String password,
                                 @Value("${spring.mail.properties.mail.transport.protocol}") String protocol,
                                 @Value("${spring.mail.properties.mail.smtp.auth}") String auth,
                                 @Value("${spring.mail.properties.mail.smtp.starttls.enable}") String starttls,
                                 @Value("${spring.mail.properties.mail.debug}") String debug,
                                 @Value("${spring.mail.properties.mail.smtp.from}") String from) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.protocol = protocol;
        this.auth = auth;
        this.starttls = starttls;
        this.debug = debug;
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getAuth() {
        return auth;
    }

    public String getStarttls() {
        return starttls;
    }
    public String getDebug() {
        return debug;
    }

    public String getFrom() {
        return from;
    }
}
