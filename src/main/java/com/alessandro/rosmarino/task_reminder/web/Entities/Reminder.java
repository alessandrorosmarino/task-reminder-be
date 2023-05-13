package com.alessandro.rosmarino.task_reminder.web.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private LocalDateTime creationDate;
    @Nonnull
    private LocalTime reminderTime;
    @Nonnull
    private String reminderText;
    private String reminderWeekday;
    private Boolean isRecurring;
    private Boolean isDone;

    public Reminder() {
    }

    public Reminder(@Nonnull LocalDateTime creationDate, @Nonnull LocalTime reminderTime, @Nonnull String reminderText, String reminderWeekday, Boolean isRecurring, Boolean isDone) {
        this.creationDate = creationDate;
        this.reminderTime = reminderTime;
        this.reminderText = reminderText;
        this.reminderWeekday = reminderWeekday;
        this.isRecurring = isRecurring;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }

    public String[] getReminderWeekday() {
        return reminderWeekday.split(",");
    }

    public void setReminderWeekday(String reminderWeekday) {
        this.reminderWeekday = reminderWeekday;
    }

    public Boolean getRecurring() {
        return isRecurring;
    }

    public void setRecurring(Boolean recurring) {
        isRecurring = recurring;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
