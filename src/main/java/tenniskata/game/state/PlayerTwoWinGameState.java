package tenniskata.game.state;

import tenniskata.game.GameState;

public class PlayerTwoWinGameState implements GameState {

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return playerTwoName + " win the game";
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
