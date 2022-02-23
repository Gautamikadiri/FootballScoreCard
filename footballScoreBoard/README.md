# Live Football worldcup score board that shows matches and scores

1. Start a game - when it starts it provides the initial score as (0-0). FootballWorldCup is a model class which
   provides the data of the HomeTeam, AwayTeam and scores.

2. Firstly options would be given to the user to 1) create 2) update 3) finish 4) fetchSummary to the user.

3. Update score - when any of the team scores a new goal, then team which gets the goal increases it's score by 1 also
   the updated scores of the teams are displayed .The function updateScore handles it.

4. Finish Game - If the match is completed, then the team which completes the match is removed from the scoreboard.
   finishGame function does the work.

5. Summary of games - After all the matches are done , it gets added to the map in the order they are finished and the
   total score is calculated for different teams . The games with the same total score will be returned ordered by the
   most recently added . This is done by sorting according to the scores and returning the most recent one added if two
   scores are equal by getSummary method.

6. Also the test cases ScoreBoardTest is written to test the functionality.
