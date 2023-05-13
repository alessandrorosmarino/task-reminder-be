package com.alessandro.rosmarino.task_reminder.util;

import com.alessandro.rosmarino.task_reminder.web.Entities.Reminder;

import java.util.List;

public class ReminderEmailBuilder {

    public static String buildReminderList(List<Reminder> reminderList) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Your reminders for today:</h1><table style='border: 1px solid black'><thead>" +
                "<tr><th>Reminder Time</th>" +
                "<th>Reminder text</th></tr>" +
                "</thead><tbody>");
        for (Reminder reminder : reminderList) {
            sb.append("<tr><td>");
            sb.append(reminder.getReminderTime());
            sb.append("</td><td>");
            sb.append(reminder.getReminderText());
            sb.append("</td></tr>");
        }
        sb.append("</tbody></table>");
        return sb.toString();
    }
}
