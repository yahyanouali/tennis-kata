package tenniskata.game.state;

import tenniskata.game.GameState;

public class InitialGameState implements GameState {

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return "0-0";
    }

    @Override
    public GameState playerOneWonPoint() {
        return new UnequalGameState(1, 0);
    }

    @Override
    public GameState playerTwoWonPoint() {
        return new UnequalGameState(0, 1);
    }

}
