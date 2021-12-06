package tenniskata.set;

import org.junit.jupiter.api.Test;
import tenniskata.common.Player;

import static org.assertj.core.api.Assertions.assertThat;

class TennisSetTest {
    Player playerOne = new Player("player 1");
    Player playerTwo = new Player("player 2");

    @Test
    void shouldHaveZeroForAllAsInitialSate() {
        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        assertThat(tennisSet.getScore()).isEqualTo("(0-0)");
    }

    @Test
    void givenInitialState_whenPlayerOneWonOneGame_shouldBe_1_0() {

        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);

        assertThat("(1-0)").isEqualTo(tennisSet.getScore());

    }


    @Test
    void givenInitialState_whenPlayerOneAndPlayerTwoWonOnePointEach_shouldBe_1_1() {

        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerTwo);

        assertThat("(1-1)").isEqualTo(tennisSet.getScore());

    }

    @Test
    void givenInitialState_whenPlayerOneWonTwoGamesSuccessively_shouldBe_2_0()  {

        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);

        assertThat("(2-0)").isEqualTo(tennisSet.getScore());

    }

    @Test
    void givenInitialState_whenPlayerTwoWonTwoGamesSuccessively_shouldBe_0_2()  {

        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);

        assertThat("(0-2)").isEqualTo(tennisSet.getScore());

    }

    @Test
    void givenInitialState_whenPlayerOneWonSixGames_shouldBeWinForPlayerOne()  {
        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);

        assertThat("(6-0)").isEqualTo(tennisSet.getScore());
        assertThat(tennisSet.isOver()).isTrue();

    }

    @Test
    void givenInitialState_whenPlayerTwoWonSixGames_shouldBeWinForPlayerTwo()  {
        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);

        assertThat("(0-6)").isEqualTo(tennisSet.getScore());
        assertThat(tennisSet.isOver()).isTrue();

    }

    @Test
    void givenInitialState_whenPlayerOneWonFiveGamesAndPlayerWonFourGamesAndThenPlayerOneWonAnotherGame_shouldBeWinForPlayerOne()  {
        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);

        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);

        tennisSet.wonGame(playerOne);

        assertThat("(6-4)").isEqualTo(tennisSet.getScore());
        assertThat(tennisSet.isOver()).isTrue();

    }

    @Test
    void givenInitialState_whenPlayerOneWonFiveGamesAndPlayerWonFiveGamesAndThenPlayerOneWonAnotherGame_shouldBeStillRunningSet()  {
        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);

        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);

        tennisSet.wonGame(playerOne);

        assertThat("(6-5)").isEqualTo(tennisSet.getScore());
        assertThat(tennisSet.isOver()).isFalse();

    }

    @Test
    void givenInitialState_whenPlayerOneWonFiveGamesAndPlayerWonFiveGamesAndThenPlayerOneWonTwoGames_shouldBeBeWinForPlayerOne()  {
        TennisSet tennisSet = new TennisSet(playerOne, playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);

        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);
        tennisSet.wonGame(playerTwo);

        tennisSet.wonGame(playerOne);
        tennisSet.wonGame(playerOne);

        assertThat("(7-5)").isEqualTo(tennisSet.getScore());
        assertThat(tennisSet.isOver()).isTrue();

    }

}
