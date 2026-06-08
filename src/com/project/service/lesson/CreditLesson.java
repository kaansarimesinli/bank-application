package com.project.service.lesson;

import com.project.model.Lesson;

public class CreditLesson extends Lesson {
    public CreditLesson(String lessonTitle) {
        super(lessonTitle, "Credit");
    }

    @Override
    public void studyLesson() {
        System.out.println("\n[LESSON: CREDIT AND DEBT MANAGEMENT]");
        System.out.println("Title: " + getLessonTitle());
        System.out.println("Content: Discover how credit scores are calculated. Learn strategies to optimize utilize-ratio and manage outstanding debts.");
        completeLesson();
        System.out.println("Status: Lesson marked as COMPLETED!");
    }
}
