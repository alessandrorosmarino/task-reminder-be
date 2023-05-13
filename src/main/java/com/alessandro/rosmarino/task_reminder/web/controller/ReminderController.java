package com.alessandro.rosmarino.task_reminder.web.controller;

import com.alessandro.rosmarino.task_reminder.util.ReminderEmailBuilder;
import com.alessandro.rosmarino.task_reminder.web.Entities.Reminder;
import com.alessandro.rosmarino.task_reminder.web.service.MailSenderService;
import com.alessandro.rosmarino.task_reminder.web.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping("/reminders")
    public List<Reminder> getAllReminder() {
        List<Reminder> reminders = new ArrayList<>();
        reminderService.getAllReminders().forEach(reminders::add);
        return reminders;
    }

    @GetMapping("/reminders/{id}")
    public Reminder getReminder(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }

    @PostMapping("/reminders")
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
    }

    @PutMapping("/reminders/{id}")
    public Reminder updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Reminder reminderToUpdate = reminderService.getReminderById(id);
        reminderToUpdate.setCreationDate(reminder.getCreationDate());
        reminderToUpdate.setReminderTime(reminder.getReminderTime());
        reminderToUpdate.setReminderText(reminder.getReminderText());
        reminderToUpdate.setReminderWeekday(String.join(",",reminder.getReminderWeekday()));
        reminderToUpdate.setRecurring(reminder.getRecurring());
        reminderToUpdate.setDone(reminder.getDone());
        return reminderService.saveReminder(reminderToUpdate);
    }

    @DeleteMapping("/reminders/{id}")
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminderById(id);
    }

    @GetMapping("/sendReminders")
    public void sendReminders() {
        LocalDate today = LocalDate.now();
        String mailBody = ReminderEmailBuilder.buildReminderList(getRemindersByWeekday(today.getDayOfWeek().toString().toLowerCase()));
        mailSenderService.sendHTMLEmail("Your reminders for today", mailBody);
    }

    @GetMapping("/reminders/weekday/{weekday}")
    public List<Reminder> getRemindersByWeekday(@PathVariable String weekday) {
        List<Reminder> reminders = new ArrayList<>();
        reminderService.getRemindersByWeekdayContaining(weekday).forEach(reminders::add);
        return reminders;
    }
}
