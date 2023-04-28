package com.alessandro.rosmarino.task_reminder.web.controller;

import com.alessandro.rosmarino.task_reminder.web.Entities.Reminder;
import com.alessandro.rosmarino.task_reminder.web.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

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
}
