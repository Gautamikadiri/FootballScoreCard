package com.footballscoreboard;

public class FootballWorldCup {
    public String homeTeam;
    public String awayTeam;
    public int homeTeamScore;
    public int awayTeamScore;
    public int totalGoalScored;

    public FootballWorldCup() {
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getTotalGoalScored() {
        return this.awayTeamScore + this.homeTeamScore;
    }
}
