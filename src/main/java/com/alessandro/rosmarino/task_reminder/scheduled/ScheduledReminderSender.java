package com.alessandro.rosmarino.task_reminder.scheduled;

import com.alessandro.rosmarino.task_reminder.web.controller.ReminderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledReminderSender {

    @Autowired
    private ReminderController reminderController;

    @Scheduled(cron = "0 0 8 * * *")
    public void sendReminder() {
        reminderController.sendReminders();
    }
}
