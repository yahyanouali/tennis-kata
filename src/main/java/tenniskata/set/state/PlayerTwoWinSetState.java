package tenniskata.set.state;

import tenniskata.set.TennisSetState;

public class PlayerTwoWinSetState implements TennisSetState {
    private final int playerOneWonGames;
    private final int playerTwoWonGames;

    public PlayerTwoWinSetState(int playerOneWonGames, int playerTwoWonGames) {
        this.playerOneWonGames = playerOneWonGames;
        this.playerTwoWonGames = playerTwoWonGames;
    }

    @Override
    public String asString() {
        return String.format("(%s-%s)", this.playerOneWonGames, this.playerTwoWonGames);
    }

    @Override
    public TennisSetState playerOneWonGame() {
        return null;
    }

    @Override
    public TennisSetState playerTwoWonGame() {
        return null;
    }
}
