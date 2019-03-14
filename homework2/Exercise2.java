import java.util.Random;

public class Exercise2 {
    /*
    wo goats are trying to cross a bridge, but they cannot pass each other.
    Instead, they meet in the middle and try to push each other off the bridge.
    To do that, a goat takes its time to gather power (between 0.5 and 2.0 seconds),
    and then moves forward one step, pushing the other goat one step backwards.
    At each push, print the position of the two goats,
    and whenever one of the goats falls off the bridge,
    the application should end, and announce which goat has managed to go through.

    The length of the bridge is given in a command line argument.
    */
    public static void main(String[] args) throws Exception {
        try {
            int len = Integer.parseInt(args[0]);
            Object lock = new Object();
            if (len % 2 != 0) {
                throw new NotEvenException();
            }
            Goat g1 = new RightDirGoat(len, lock);
            Goat g2 = new LeftDirGoat(len, lock);
            g1.setOpponent(g2);
            g2.setOpponent(g1);
            g1.start();
            g2.start();
        } catch (NumberFormatException e) {
            System.out.println("provide length of the bridge");
        } catch (NotEvenException e) {
            System.out.println("length should be divisible by 2");
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        System.out.println("The runtime was faster because wait time was decreased. See line 64");
    }
}

class NotEvenException extends Exception {

}

abstract class Goat extends Thread {

    String name;
    public int goal;
    public int position;
    Object lock;
    Goat opponent;
    Random r;

    public Goat(int pos, Object lock, String name) {
        position = pos;
        this.lock = lock;
        this.name = name;
        r = new Random();
    }

    @Override
    public void run() {
        while (!reachedGoal() && !fellOff()) {
            try {
                // would be 1500 and 500 but it's too slow
                sleep(r.nextInt(150) + 5);
            } catch (Exception e) {
            }
            if (!fellOff()) {
                kick();
            } else {
                System.out.println(name + " fell off :c");
            }
        }
        if (reachedGoal()) {
            System.out.println(name + " reached the goal \\o/");
        }
    }

    public void kick() {
        synchronized (lock) {
            position += stepForward();
            opponent.position += stepForward();
            System.out.println(name + " kicked! results: " + this + " " + this.opponent);
        }

    }

    public void setOpponent(Goat g) {
        opponent = g;
    }

    boolean reachedGoal() {
        synchronized(lock) {
            return position == goal;
        }
    }

    abstract boolean fellOff();

    abstract int stepForward();

    @Override
    public String toString() {
        return name + " is at " + position + ".";
    }
}

class RightDirGoat extends Goat {

    public RightDirGoat(int length, Object lock) {
        super(length / 2, lock, "Right");
        goal = length;
    }

    @Override
    int stepForward() {
        return 1;
    }

    @Override boolean fellOff() {
        return position < opponent.goal;
    }
}

class LeftDirGoat extends Goat {

    public LeftDirGoat(int length, Object lock) {
        super(length / 2 + 1, lock, "Left");
        goal = 0;
    }

    @Override
    int stepForward() {
        return -1;
    }

    @Override boolean fellOff() {
        return position > opponent.goal;
    }
}