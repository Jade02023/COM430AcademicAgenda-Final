package com.example.academicagenda;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationSystem {
    private final Timer timer;

    public NotificationSystem() {
        this.timer = new Timer();
    }

    public void scheduleNotification(String message, long delayMillis) {
        // Schedule a notification after the specified delay
        timer.schedule(new NotificationTask(message), delayMillis);
    }

    // Inner class representing the notification task
    private class NotificationTask extends TimerTask {
        private final String message;

        public NotificationTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            // Perform actions when the notification is triggered
            sendNotification(message);
        }
    }

    // Method to simulate sending a notification
    private void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }

    public static void main(String[] args) {
        NotificationSystem notificationSystem = new NotificationSystem();

        // Example: Schedule a notification after 5 seconds
        notificationSystem.scheduleNotification("Your task is due!", 5000);
    }
}