
import java.util.Scanner;

public class Game {
    private Board board;
    private int turn = 1, who = 1;
    private Player player1;
    private Player player2;
    public Scanner input = new Scanner(System.in);

    public Game() {
        board = new Board();
        startPlayers();
        while (Play()) {}
            
    }

    public void startPlayers() {
        // TODO: pass input and ouputs
        this.player1 = new Human(1);
        this.player2 = new Human(2);
    }

    public boolean Play() {
        board.showBoard();
        if (won() == 0) {
            System.out.println("----------------------");
            System.out.println("\nTurn " + turn);
            System.out.println("It's turn of Player " + who());

            if (who() == 1)
                player1.play(board);
            else
                player2.play(board);

            if (board.fullBoard()) {
                System.out.println("Full Board. Draw!");
                return false;
            }
            who++;
            turn++;

            return true;
        } else {
            if (won() == -1)
                System.out.println("Player 1 won!");
            else
                System.out.println("Player 2 won!");

            return false;
        }

    }

    public int who() {
        if (who % 2 == 1)
            return 1;
        else
            return 2;
    }

    public int won() {
        if (board.checkLines() == 1)
            return 1;
        if (board.checkColumns() == 1)
            return 1;
        if (board.checkDiagonals() == 1)
            return 1;

        if (board.checkLines() == -1)
            return -1;
        if (board.checkColumns() == -1)
            return -1;
        if (board.checkDiagonals() == -1)
            return -1;

        return 0;
    }

}
