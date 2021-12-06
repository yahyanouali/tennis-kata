package tenniskata.set;

public interface TennisSetState {

    String asString();

    TennisSetState playerOneWonGame();

    TennisSetState playerTwoWonGame();

}
