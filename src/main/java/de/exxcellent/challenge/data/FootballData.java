package de.exxcellent.challenge.data;

public class FootballData implements Data {
    private String name;
    private int goals;
    private int goalsAllowed;

    public FootballData(String name, int goals, int goalsAllowed) {
        this.name = name;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    @Override
    public int getSpread() {
        return Math.abs(goals - goalsAllowed);
    }

    @Override
    public String getId() {
        return name;
    }
}
