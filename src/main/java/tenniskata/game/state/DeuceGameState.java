package tenniskata.game.state;


import tenniskata.game.GameState;

class DeuceGameState implements GameState {

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return "deuce";
    }

    @Override
    public GameState playerOneWonPoint() {
        return new PlayerOneAdvantageGameState();
    }

    @Override
    public GameState playerTwoWonPoint() {
        return new PlayerTwoAdvantageGameState();
    }

}
