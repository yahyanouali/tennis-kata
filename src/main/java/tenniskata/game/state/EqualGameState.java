package tenniskata.game.state;


import tenniskata.game.GameState;
import tenniskata.game.ScoreEnum;

class EqualGameState implements GameState {

    private final int points;

    public EqualGameState(int points) {
        this.points = points;
    }

    @Override
    public String asString(String playerOneName, String playerTwoName) {
        return String.format("%s-%s", ScoreEnum.getScore(points), ScoreEnum.getScore(points));
    }

    @Override
    public GameState playerOneWonPoint() {
        final int incrementedPlayerOnePoints = points + 1;

        if (incrementedPlayerOnePoints == 4) {
            return new PlayerOneAdvantageGameState();
        }

        return new UnequalGameState(incrementedPlayerOnePoints, points);
    }

    @Override
    public GameState playerTwoWonPoint() {
        final int incrementedPlayerTwoPoints = points + 1;

        if (incrementedPlayerTwoPoints == 4) {
            return new PlayerTwoAdvantageGameState();
        }

        return new UnequalGameState(points, incrementedPlayerTwoPoints);
    }
}
