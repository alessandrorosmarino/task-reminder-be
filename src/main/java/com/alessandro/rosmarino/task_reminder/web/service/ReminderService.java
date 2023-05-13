package com.alessandro.rosmarino.task_reminder.web.service;

import com.alessandro.rosmarino.task_reminder.web.Entities.Reminder;
import com.alessandro.rosmarino.task_reminder.web.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public Reminder saveReminder(Reminder reminder){
        return reminderRepository.save(reminder);
    }

    public void deleteReminder(Reminder reminder){
        reminderRepository.delete(reminder);
    }

    public void deleteReminderById(Long id){
        reminderRepository.deleteById(id);
    }

    public Reminder getReminderById(Long id){
        Optional<Reminder> reminder = reminderRepository.findById(id);
        return reminder.orElseThrow(() -> new IllegalArgumentException("Invalid reminder Id:" + id));
    }

    public Iterable<Reminder> getAllReminders(){
        return reminderRepository.findAll();
    }

    public Iterable<Reminder> getRemindersByDate(LocalDate date){
        return reminderRepository.findAllByCreationDate(date);
    }

    public Iterable<Reminder> getRemindersByWeekdayContaining(String weekday){
        return reminderRepository.findAllByReminderWeekdayContaining(weekday);
    }

}
