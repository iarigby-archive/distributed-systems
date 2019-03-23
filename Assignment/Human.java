
import java.util.Scanner;
import java.io.PrintWriter;

public class Human extends Player {
    public Scanner input;
    public PrintWriter printer;

    public Human(int player, Scanner input) {
        super(player);
        this.input = input;
        this.player = player;
        this.printer = new PrintWriter(System.out);
        println("Player created!");
    }

    public Human(int player) {
        this(player, new Scanner(System.in));
    }

    private void print(String s) {
        printer.print(s);
        System.out.println("here");
        // printer.flush();
    }

    private void println(String s) {
        print(s + "\n");
    }

    @Override
    public void play(Board board) {
        Try(board);
        board.setPosition(attempt, player);
    }

    @Override
    public void Try(Board board) {
        do {
            do {
                print("Line: ");
                
                try {
                    attempt[0] = input.nextInt();
                } catch (Exception e) {
                    println("you can only enter a number");
                }
                if (attempt[0] > 3 || attempt[0] < 1)
                    println("Invalid line. It's 1, 2 or 3");

            } while (attempt[0] > 3 || attempt[0] < 1);

            do {
                print("Column: ");
                attempt[1] = input.nextInt();

                if (attempt[1] > 3 || attempt[1] < 1)
                    println("Invalid column. É 1, 2 or 3");

            } while (attempt[1] > 3 || attempt[1] < 1);

            attempt[0]--;
            attempt[1]--;

            if (!checkTry(attempt, board))
                println("Placed already marked. Try other.");
        } while (!checkTry(attempt, board));
    }
}
