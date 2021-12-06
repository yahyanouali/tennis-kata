package tenniskata.game;

public enum ScoreEnum {
    LOVE(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40);

    private static final ScoreEnum[] values = values();

    private final int score;

    ScoreEnum(int score) {
        this.score = score;
    }

    public static int getScore(int points) {
        if(points < 0 || points > values.length) {
            throw new IllegalArgumentException("Invalid number of points");
        }

        return values[points].getScore();
    }

    private int getScore() {
        return score;
    }

}
