package tenniskata.game;

import org.junit.jupiter.api.Test;
import tenniskata.common.Player;
import tenniskata.game.Game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameTest {

    Player playerOne = new Player("player 1");
    Player playerTwo = new Player("player 2");

    @Test
    void shouldHaveLoveAllAsInitialSate() {
        Game game = new Game(playerOne, playerTwo);

        assertThat(game.getScore()).isEqualTo("0-0");

    }

    @Test
    void givenInitialState_whenPlayerOneScoringPoint_shouldBeLoveFifteen() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);

        assertThat("15-0").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerTwoScoringPoint_shouldBeFifteenLove() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerTwo);

        assertThat("0-15").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerOneAndPlayerTwoScoringPoint_shouldBeFifteenAll() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerTwo);

        assertThat("15-15").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerOneScoresTwoTimes_shouldBeThirtyLove() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        assertThat("30-0").isEqualTo(game.getScore());
    }

    @Test
    void givenInitialState_whenPlayerTwoScoresTwoTimes_shouldBeLoveThirty() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);

        assertThat("0-30").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerTwoScoresThreeTimes_shouldBeLoveForty() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        assertThat("40-0").isEqualTo(game.getScore());
    }

    @Test
    void givenInitialState_whenPlayerTwoScoresAndPlayerOneScored_shouldBeFifteenAll() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);

        assertThat("0-40").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerTwoScoresFourTimes_shouldBeWinForPlayerTwo() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        assertThat("player 1 win the game").isEqualTo(game.getScore());
        assertThat(game.isOver()).isTrue();

    }

    @Test
    void givenInitialState_whenPlayerOneAndTwoScoredThreeTimesAndPlayerTwoScores_shouldBeAdvantageForPlayerTwo() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);

        assertThat("advantage player 2").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerOneAndTwoScoredThreeTimesAndPlayerOneScores_shouldBeAdvantageForPlayerOne() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);

        game.wonPoint(playerOne);

        assertThat("advantage player 1").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_whenPlayerOneAndTwoScoreThreeTimes_shouldBeDeuce() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);

        assertThat("deuce").isEqualTo(game.getScore());

    }

    @Test
    void givenInitialState_PlayerOneScoresFourTimes_shouldBeWinForPlayerOne() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);
        game.wonPoint(playerOne);

        assertThat("player 1 win the game").isEqualTo(game.getScore());
        assertThat(game.isOver()).isTrue();

    }

    @Test
    void givenInitialState_PlayerTwoScoresFourTimes_shouldBeWinForPlayerTwo() {

        Game game = new Game(playerOne, playerTwo);

        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);
        game.wonPoint(playerTwo);

        assertThat("player 2 win the game").isEqualTo(game.getScore());
        assertThat(game.isOver()).isTrue();

    }



}
