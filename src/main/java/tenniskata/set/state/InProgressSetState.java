package tenniskata.set.state;

import tenniskata.set.TennisSetState;

public class InProgressSetState implements TennisSetState {
    private final int playerOneWonGames;
    private final int playerTwoWonGames;

    public InProgressSetState(int playerOneWonGames, int playerTwoWonGames) {
        this.playerOneWonGames = playerOneWonGames;
        this.playerTwoWonGames = playerTwoWonGames;
    }

    @Override
    public String asString() {
        return String.format("(%s-%s)", playerOneWonGames, playerTwoWonGames);
    }

    @Override
    public TennisSetState playerOneWonGame() {
        final int incrementedPlayerOneWonGames = playerOneWonGames + 1;

        if(incrementedPlayerOneWonGames >= 6 &&  incrementedPlayerOneWonGames - playerTwoWonGames >= 2 ) {
            return new PlayerOneWinSetState(incrementedPlayerOneWonGames, playerTwoWonGames);
        }

        return new InProgressSetState(incrementedPlayerOneWonGames, playerTwoWonGames);

    }

    @Override
    public TennisSetState playerTwoWonGame() {
        final int incrementedPlayerTwoWonGames = playerTwoWonGames + 1;

        if(incrementedPlayerTwoWonGames >= 6 &&  incrementedPlayerTwoWonGames - playerOneWonGames >= 2 ) {
            return new PlayerTwoWinSetState(playerOneWonGames, incrementedPlayerTwoWonGames);
        }

        return new InProgressSetState(playerOneWonGames, incrementedPlayerTwoWonGames);
    }
}
