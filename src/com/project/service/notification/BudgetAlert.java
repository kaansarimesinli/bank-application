package com.project.service.notification;

import com.project.model.Notification;

public class BudgetAlert extends Notification {
    public BudgetAlert(String message) {
        super(message);
    }
    @Override
    public void sendNotification() {
        System.out.println("⚠️ [BUDGET ALERT] (" + getTimestamp() + ") -> " + getMessage());
    }
}
