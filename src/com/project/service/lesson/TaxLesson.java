package com.project.service.lesson;

import com.project.model.Lesson;

public class TaxLesson extends Lesson {
    public TaxLesson(String lessonTitle) {
        super(lessonTitle, "Tax");
    }

    @Override
    public void studyLesson() {
        System.out.println("\n[LESSON: TAX AND DEDUCTION AWARENESS]");
        System.out.println("Title: " + getLessonTitle());
        System.out.println("Content: Grasp the basics of income taxes, deductibles, and financial write-offs to optimize net income.");
        completeLesson();
        System.out.println("Status: Lesson marked as COMPLETED! ✅");
    }
}
