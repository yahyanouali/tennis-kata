package tenniskata.match;

import tenniskata.common.Player;
import tenniskata.game.Game;
import tenniskata.set.TennisSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Match {
    private static final String FORMATTED_SCORE = """
            Player 1 : %s
            Player 2 : %s
            Score : %s
            Current game status : %s 
            """;

    private List<TennisSet> tennisSets = new ArrayList<>();
    private final Player playerOne;
    private final Player playerTwo;
    private TennisSet currentSet;
    private Game currentGame;

    public Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentSet = new TennisSet(playerOne, playerTwo);
        this.tennisSets.add(this.currentSet);
        this.currentGame = new Game(playerOne, playerTwo);
        this.currentSet.addGame(this.currentGame);
    }

    public void wonPoint(Player player) {
        currentGame.wonPoint(player);

        if (currentGame.isOver()) {
            currentSet.wonGame(player);

            if (currentSet.isOver()) {
                currentGame = new Game(playerOne, playerTwo);
                currentSet = new TennisSet(playerOne, playerTwo);
                tennisSets.add(currentSet);
                currentSet.addGame(currentGame);

            } else {
                currentGame = new Game(playerOne, playerTwo);
                currentSet.addGame(currentGame);

            }
        }
    }

    public String getScore() {
        String allSetsCore = tennisSets.stream()
                .map(TennisSet::getScore)
                .collect(Collectors.joining(" "));

        return String.format(FORMATTED_SCORE, playerOne.name(),
                playerTwo.name(),
                allSetsCore,
                currentGame.getScore());

    }
}
