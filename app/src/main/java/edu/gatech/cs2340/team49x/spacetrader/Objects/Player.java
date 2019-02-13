package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Player {
    private String name;
    private int skillPoints;
    private int[] skills;
    private int credits;
    private Difficulty difficulty;

    public Player(String name, int skillPoints, int[] skills, int credits, Difficulty difficulty) {
        this.name = name;
        this.skillPoints = skillPoints;
        this.skills = skills;
        this.credits = credits;
        this.difficulty = difficulty;
    }

    public Player(String name) {
        this(name, 16, null, 1000, Difficulty.Easy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int[] getSkills() {
        return skills;
    }

    public void setSkills(int[] skills) {
        this.skills = skills;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
