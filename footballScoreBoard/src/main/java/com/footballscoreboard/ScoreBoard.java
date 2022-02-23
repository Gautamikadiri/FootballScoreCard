package com.footballscoreboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScoreBoard {
    public BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public Map<Integer, FootballWorldCup> footballTeams = new HashMap<>();
    public Map<Integer, Set<FootballWorldCup>> finishedMatchToTotalScore = new HashMap<>();

    public void fetchUserOptions() throws IOException {
        boolean flag = true;
        while (flag) {
            System.out.println("select one of the below options : ");
            System.out.println("1 for create new scoreboard, 2 for updating the scorecard, 3 to finalise the game and 4 to see the summary.");
            Integer menuChoice = Integer.parseInt(input.readLine());
            switch (menuChoice) {
                case 1:
                    createBoard();
                    break;
                case 2:
                    updateScore();
                    break;
                case 3:
                    finishGame();
                    break;
                case 4:
                    getSummary();
                    if (footballTeams.isEmpty()) {
                        flag = false;
                    }
                    break;
            }
        }
    }

    public void finishGame() throws IOException {
        System.out.println("choose the option to remove the match from scoreBoard");
        displayOptions();
        int option = Integer.parseInt(input.readLine());
        FootballWorldCup matchCompleted = footballTeams.remove(option);
        finishedMatchToTotalScore.computeIfAbsent(matchCompleted.getTotalGoalScored(), k -> new HashSet<>()).add(matchCompleted);
    }

    public void getSummary() {
        if (footballTeams.isEmpty()) {
            System.out.println("Below is the summary of finished games.");

            Map<Integer, Set<FootballWorldCup>> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
            reverseSortedMap.putAll(finishedMatchToTotalScore);

            reverseSortedMap.entrySet().forEach((input) -> {
                Set<FootballWorldCup> value = input.getValue();
                value.forEach((result) -> System.out.println(result.getHomeTeam() + " " + result.getHomeTeamScore() + "-" + result.getAwayTeam()
                        + " " + result.getAwayTeamScore()));
            });
        } else {
            System.out.println("Summaries of the match is not available when there is at-least one match ongoing.");
        }
    }

    private void displayOptions() {
        footballTeams.entrySet().forEach((input) -> {
            System.out.print(input.getKey() + ", ");
            System.out.println(input.getValue().homeTeam + "-" + input.getValue().awayTeam);
        });
    }


    public void updateScore() throws IOException {
        System.out.println("Below are the ongoing games. Select the options to update the score");
        displayOptions();
        int option = Integer.parseInt(input.readLine());
        if (footballTeams.get(option) != null) {
            FootballWorldCup footballWorldCup = footballTeams.get(option);

            System.out.println("Type in the team name scored new goal " + footballWorldCup.getAwayTeam() + " or " + footballWorldCup.getHomeTeam());
            String teamNewGoal = input.readLine();
            if (teamNewGoal.equalsIgnoreCase(footballWorldCup.awayTeam)) {
                footballWorldCup.setAwayTeamScore(footballWorldCup.getAwayTeamScore() + 1);
            } else {
                footballWorldCup.setHomeTeamScore(footballWorldCup.getHomeTeamScore() + 1);
            }
        } else {
            System.out.println("The entered option is invalid");
        }
    }


    public void createBoard() throws IOException {
        FootballWorldCup footballWorldCup = new FootballWorldCup();
        System.out.println("Enter the Home Team Name");
        footballWorldCup.setHomeTeam(input.readLine());
        System.out.println("Enter the Away Team Name");
        footballWorldCup.setAwayTeam(input.readLine());
        footballTeams.put(footballTeams.size() + 1, footballWorldCup);
    }

}


