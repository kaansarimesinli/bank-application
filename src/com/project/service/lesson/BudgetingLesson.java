package com.project.service.lesson;

import com.project.model.Lesson;

public class BudgetingLesson extends Lesson {
    public BudgetingLesson(String lessonTitle) {
        super(lessonTitle, "Budgeting");
    }

    @Override
    public void studyLesson() {
        System.out.println("\n[LESSON: BUDGETING MANAGEMENT]");
        System.out.println("Title: " + getLessonTitle());
        System.out.println("Content: Learn the 50/30/20 rule. Allocate 50% to needs, 30% to wants, and 20% to savings.");
        completeLesson();
        System.out.println("Status: Lesson marked as COMPLETED! ✅");
    }
}
