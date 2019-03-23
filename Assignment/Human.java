
import java.util.Scanner;
import java.io.PrintWriter;

public class Human extends Player {
    public Scanner input;
    public PrintWriter printer;

    public Human(int player, Scanner input, PrintWriter printer) {
        super(player);
        this.input = input;
        this.player = player;
        this.printer = printer;
    }

    public void println(String s) {
        // System.out.print(s);
        printer.println(s);
        printer.flush();
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
                println("enter Line: ");
                String in = input.nextLine();
                try {
                    attempt[0] = Integer.parseInt(in);
                } catch (Exception e) {
                    println("you can only input a number");
                }
                if (attempt[0] > 3 || attempt[0] < 1)
                    println("Invalid line. It's 1, 2 or 3");

            } while (attempt[0] > 3 || attempt[0] < 1);

            do {
                println("enter Column: ");
                String in = input.nextLine();
                try {
                    attempt[1] = Integer.parseInt(in);
                } catch (Exception e) {
                    println("you can only input a number");
                }
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
