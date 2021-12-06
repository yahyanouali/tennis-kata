package tenniskata.game.state;

import tenniskata.game.GameState;
import tenniskata.game.ScoreEnum;

class UnequalGameState implements GameState {

    private final int playerOnePoints;
    private final int playerTwoPoints;

    public UnequalGameState(int playerOnePoints, int playerTwoPoints) {
        this.playerOnePoints = playerOnePoints;
        this.playerTwoPoints = playerTwoPoints;
    }

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return String.format("%s-%s", ScoreEnum.getScore(playerOnePoints), ScoreEnum.getScore(playerTwoPoints));
    }

    @Override
    public GameState playerOneWonPoint() {
        final int incrementedPlayerOnePoints = playerOnePoints + 1;

        if (incrementedPlayerOnePoints == 4 && playerTwoPoints < 4) {
            return new PlayerOneWinGameState();
        }

        if (incrementedPlayerOnePoints == playerTwoPoints) {
            if (incrementedPlayerOnePoints >= 3) {
              return new DeuceGameState();
            }
            return new EqualGameState(incrementedPlayerOnePoints);
        }

        return new UnequalGameState(incrementedPlayerOnePoints, playerTwoPoints);

    }

    @Override
    public GameState playerTwoWonPoint() {
        final int incrementedPlayerTwoPoints = playerTwoPoints + 1;

        if (incrementedPlayerTwoPoints == 4 && playerTwoPoints < 4) {
            return new PlayerTwoWinGameState();
        }

        if (incrementedPlayerTwoPoints == playerOnePoints) {
            if (incrementedPlayerTwoPoints >= 3) {
                return new DeuceGameState();
            }
            return new EqualGameState(incrementedPlayerTwoPoints);
        }

        return new UnequalGameState(this.playerOnePoints, incrementedPlayerTwoPoints);

    }
}
