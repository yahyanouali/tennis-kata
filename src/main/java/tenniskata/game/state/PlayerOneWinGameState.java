package tenniskata.game.state;

import tenniskata.game.GameState;

public class PlayerOneWinGameState implements GameState {

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return playerOneName + " win the game";
    }

    @Override
    public GameState playerOneWonPoint() {
        return null;
    }

    @Override
    public GameState playerTwoWonPoint() {
        return null;
    }
}
