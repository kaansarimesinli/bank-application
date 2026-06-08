package com.project.model;

public abstract class Challenge {
    private final String challengeName;
    private final String description;
    private final int xpReward;
    private boolean isCompleted;

    public Challenge(String challengeName, String description, int xpReward) {
        this.challengeName = challengeName;
        this.description = description;
        this.xpReward = xpReward;
        this.isCompleted = false;
    }

    public String getChallengeName() { return challengeName; }
    public String getDescription() { return description; }
    public int getXpReward() { return xpReward; }
    public boolean isCompleted() { return isCompleted; }

    public void setCompleted(boolean completed) { this.isCompleted = completed; }

    public abstract boolean evaluateChallenge(User user);
}
