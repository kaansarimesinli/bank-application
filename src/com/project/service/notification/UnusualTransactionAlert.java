package com.project.service.notification;

import com.project.model.Notification;

public class UnusualTransactionAlert extends Notification {
    public UnusualTransactionAlert(String message) {
        super(message);
    }

    @Override
    public void sendNotification() {
        System.out.println("🚨 [UNUSUAL TRANSACTION DETECTED] (" + getTimestamp() + ") -> " + getMessage());
    }
}
