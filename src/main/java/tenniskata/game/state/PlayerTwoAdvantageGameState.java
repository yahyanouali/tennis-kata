package tenniskata.game.state;

import tenniskata.game.GameState;

class PlayerTwoAdvantageGameState implements GameState {

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return "advantage " + playerTwoName;
    }

    @Override
    public GameState playerOneWonPoint() {
        return new DeuceGameState();
    }

    @Override
    public GameState playerTwoWonPoint() {
        return new PlayerTwoWinGameState();
    }
}
