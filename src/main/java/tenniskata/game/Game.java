package tenniskata.game;

import tenniskata.common.Player;
import tenniskata.game.state.InitialGameState;
import tenniskata.game.state.PlayerOneWinGameState;
import tenniskata.game.state.PlayerTwoWinGameState;

import java.util.Objects;

public class Game {
    private GameState gameState;
    private final Player playerOne;
    private final Player playerTwo;

    public Game(Player playerOne, Player playerTwo) {
        this.gameState = new InitialGameState();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(Player player) {
        Objects.requireNonNull(player);

        if (player.equals(playerOne)) {
            gameState = gameState.playerOneWonPoint();

        } else if (player.equals(playerTwo)) {
            gameState = gameState.playerTwoWonPoint();

        } else {
            throw new IllegalArgumentException("Please provide an already registered player for this game");

        }
    }


    public boolean isOver() {
        return this.gameState instanceof PlayerOneWinGameState
                || this.gameState instanceof PlayerTwoWinGameState;
    }

    public String getScore() {
        return gameState.asString(playerOne.name(), playerTwo.name());
    }

}
