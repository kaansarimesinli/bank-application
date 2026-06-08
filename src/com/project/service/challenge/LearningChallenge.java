package com.project.service.challenge;

import com.project.model.Challenge;
import com.project.model.User;

public class LearningChallenge extends Challenge {
    private final String topicName;
    private boolean quizPassed;

    public LearningChallenge(String challengeName, String description, int xpReward, String topicName) {
        super(challengeName, description, xpReward);
        this.topicName = topicName;
        this.quizPassed = false;
    }

    public void completeQuiz() {
        this.quizPassed = true;
    }

    @Override
    public boolean evaluateChallenge(User user) {
        if (isCompleted()) return false;

        if (quizPassed) {
            setCompleted(true);
            return true;
        }
        return false;
    }
}
