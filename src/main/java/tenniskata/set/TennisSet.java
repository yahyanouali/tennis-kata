package tenniskata.set;

import tenniskata.common.Player;
import tenniskata.game.Game;
import tenniskata.set.state.InitialSetState;
import tenniskata.set.state.PlayerOneWinSetState;
import tenniskata.set.state.PlayerTwoWinSetState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TennisSet {
    private TennisSetState tennisSetState;
    private List<Game> games;
    private final Player playerOne;
    private final Player playerTwo;

    public TennisSet(Player playerOne, Player playerTwo) {
        this.tennisSetState = new InitialSetState();
        this.games = new ArrayList<>();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public void wonGame(Player player) {
        Objects.requireNonNull(player);

        if (player.equals(this.playerOne)) {
            this.tennisSetState = this.tennisSetState.playerOneWonGame();

        } else if (player.equals(this.playerTwo)) {
            this.tennisSetState = this.tennisSetState.playerTwoWonGame();

        } else {
            throw new IllegalArgumentException("Please provide an already registered player for this set");

        }
    }

    public boolean isOver() {
        return this.tennisSetState instanceof PlayerOneWinSetState
                || this.tennisSetState instanceof PlayerTwoWinSetState;
    }

    public String getScore() {
        return this.tennisSetState.asString();

    }

}
