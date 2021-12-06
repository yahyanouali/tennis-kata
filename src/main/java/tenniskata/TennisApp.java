package tenniskata;

import tenniskata.common.Player;
import tenniskata.match.Match;

import java.util.Random;

public class TennisApp {
    public static void main(String[] args) {
        Player yahya = new Player("yahya");
        Player nadal = new Player("nadal");
        Player[] players = {yahya, nadal};
        Match match = new Match(yahya, nadal);


        // simulate a random match of less than 50ms
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < 50) {
            System.out.println(match.getScore());

            int i = new Random().nextInt(2);
            match.wonPoint(players[i]);
        }

    }

}
