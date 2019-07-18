
import java.util.Scanner;
import java.io.PrintWriter;

public class Game {
    private Board board;
    private int turn = 1, who = 1;
    private Human player1;
    private Human player2;
    public Scanner input = new Scanner(System.in);

    public Game() {
        board = new Board();
    }

    public void startPlayer(int p, Scanner input, PrintWriter printer) {
        if (p == 1) {
            this.player1 = new Human(p, input, printer);
        } else {
            this.player2 = new Human(p, input, printer);
        }
    }

    public void run() {
        player1.println("Game started! you're player 1");
        player2.println("Game started! you're player 2");
        while (Play()) {}
    }

    public boolean Play() {
        if (won() == 0) {
            System.out.println("----------------------");
            System.out.println("\nTurn " + turn);
            System.out.println("It's turn of Player " + who());
            String s = board.showBoard();
            System.out.println(s);
            player1.println(s);
            player2.println(s);
            if (who() == 1) {
                player1.println("it's your turn");
                player2.println("player 1 is playing");
                player1.play(board);
            } else {
                player2.println("it's your turn");
                player1.println("player 2 is playing");
                player2.play(board);
            }

            if (board.fullBoard()) {
                System.out.println("Full Board. Draw!");
                return false;
            }
            who++;
            turn++;
            return true;
        } else {
            String msg;
            if (won() == -1)
                msg = "Player 1 won!";
            else
                msg = "Player 2 won!";
            System.out.println(msg);
            player1.println(msg);
            player2.println(msg);
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
