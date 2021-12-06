package tenniskata.game;

public interface GameState {

    String asString(String playerOneName, String playerTwoName);

    GameState playerOneWonPoint();

    GameState playerTwoWonPoint();

}
