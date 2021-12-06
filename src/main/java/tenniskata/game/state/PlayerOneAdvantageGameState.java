package tenniskata.game.state;

import tenniskata.game.GameState;

class PlayerOneAdvantageGameState implements GameState {

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return "advantage " + playerOneName;
    }

    @Override
    public GameState playerOneWonPoint() {
        return new PlayerOneWinGameState();
    }

    @Override
    public GameState playerTwoWonPoint() {
        return new DeuceGameState();
    }
}
