package com.project.model;

public abstract class Lesson {
    private final String lessonTitle;
    private final String category;
    private boolean isCompleted;

    public Lesson(String lessonTitle, String category) {
        this.lessonTitle = lessonTitle;
        this.category = category;
        this.isCompleted = false;
    }

    public String getLessonTitle() { return lessonTitle; }
    public String getCategory() { return category; }
    public boolean isCompleted() { return isCompleted; }

    public void completeLesson() { this.isCompleted = true; }

    public abstract void studyLesson();
}
