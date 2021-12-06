package tenniskata.set.state;

import tenniskata.set.TennisSetState;

public class InitialSetState implements TennisSetState {

    @Override
    public String asString() {
        return "(0-0)";
    }

    @Override
    public TennisSetState playerOneWonGame() {
        return new InProgressSetState(1, 0);
    }

    @Override
    public TennisSetState playerTwoWonGame() {
        return new InProgressSetState(0, 1);
    }
}
