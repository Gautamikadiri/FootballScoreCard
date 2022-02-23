import com.footballscoreboard.FootballWorldCup;
import com.footballscoreboard.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ScoreBoardTest {

    ScoreBoard scoreBoard;

    BufferedReader mockBuffer;

    @BeforeEach
    public void beforeEach() {
        scoreBoard = new ScoreBoard();
        mockBuffer = mock(BufferedReader.class);
        scoreBoard.input = mockBuffer;
    }

    @Test
    void testCreateBoard() throws IOException {
        //Arrange
        when(mockBuffer.readLine()).thenReturn("ITALY").thenReturn("SPAIN");

        //ACT
        scoreBoard.createBoard();

        //ASSERT
        assertEquals(1, scoreBoard.footballTeams.size());
    }

    @Test
    void testUpdateScore() throws IOException {
        FootballWorldCup footballWorldCup = new FootballWorldCup();
        footballWorldCup.setHomeTeam("ITALY");
        footballWorldCup.setAwayTeam("SPAIN");
        Map<Integer, FootballWorldCup> footballTeams = new HashMap<>();
        footballTeams.put(1, footballWorldCup);
        when(mockBuffer.readLine()).thenReturn("1").thenReturn("ITALY");
        scoreBoard.footballTeams = footballTeams;

        scoreBoard.updateScore();

        assertEquals(1, scoreBoard.footballTeams.get(1).homeTeamScore);

    }

    @Test
    void testFinishGame() throws IOException {
        FootballWorldCup footballWorldCup = new FootballWorldCup();
        footballWorldCup.setHomeTeam("ITALY");
        footballWorldCup.setAwayTeam("SPAIN");
        Map<Integer, FootballWorldCup> footballTeams = new HashMap<>();
        footballTeams.put(1, footballWorldCup);


        when(mockBuffer.readLine()).thenReturn("1");
        scoreBoard.footballTeams = footballTeams;

        scoreBoard.finishGame();

        assertEquals(0, scoreBoard.footballTeams.size());
        assertEquals(1, scoreBoard.finishedMatchToTotalScore.size());

    }

    @Test
    void testSummary() {
        Map<Integer, FootballWorldCup> footballTeams = new HashMap<>();
        scoreBoard.footballTeams = footballTeams;

        FootballWorldCup footballWorldCup1 = new FootballWorldCup();
        footballWorldCup1.setHomeTeam("ITALY");
        footballWorldCup1.setAwayTeamScore(3);
        footballWorldCup1.setAwayTeam("SPAIN");
        footballWorldCup1.setHomeTeamScore(4);

        FootballWorldCup footballWorldCup2 = new FootballWorldCup();
        footballWorldCup2.setHomeTeam("INDIA");
        footballWorldCup2.setAwayTeam("AFRICA");
        footballWorldCup2.setAwayTeamScore(3);
        footballWorldCup2.setHomeTeamScore(4);

        Set<FootballWorldCup> footballWorldCups = new HashSet<>();
        footballWorldCups.add(footballWorldCup1);
        footballWorldCups.add(footballWorldCup2);

        Map<Integer, Set<FootballWorldCup>> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.put(7, footballWorldCups);

        scoreBoard.finishedMatchToTotalScore = reverseSortedMap;
        scoreBoard.getSummary();
    }

}
