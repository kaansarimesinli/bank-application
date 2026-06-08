package com.project.service.notification;

import com.project.model.Notification;

public class BillReminder extends Notification {
    public BillReminder(String message) {
        super(message);
    }
    @Override
    public void sendNotification() {
        System.out.println("📅 [BILL REMINDER] (" + getTimestamp() + ") -> " + getMessage());
    }
}
