package com.project.service.lesson;

import com.project.model.Lesson;

public class InvestingLesson extends Lesson {
    public InvestingLesson(String lessonTitle) {
        super(lessonTitle, "Investing");
    }

    @Override
    public void studyLesson() {
        System.out.println("\n[LESSON: INVESTING FUNDAMENTALS]");
        System.out.println("Title: " + getLessonTitle());
        System.out.println("Content: Understand compound interest, diversification, and investment asset types like stocks and bonds.");
        completeLesson();
        System.out.println("Status: Lesson marked as COMPLETED! ✅");
    }
}
