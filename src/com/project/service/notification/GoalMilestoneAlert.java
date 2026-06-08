package com.project.service.notification;

import com.project.model.Notification;

public class GoalMilestoneAlert extends Notification {
    public GoalMilestoneAlert(String message) {
        super(message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[GOAL MILESTONE] (" + getTimestamp() + ") -> " + getMessage());
    }
}
