import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Main
{ 
	public static void main(String [] args)
	{
        if (args.length > 1) {
            switch (args[0]) {
                case "args": ex2(args); break;
                case "fib": ex3(args[1]); break;
                case "div": ex4(args[1]); break;
            }
        } else {
            ex1();
        }
    }

    private static void ex1() {
        System.out.println("1. hello world");
        System.out.println("\t command line arguments for exercises:");
        System.out.println("\t\t ex2: args [args]");
        System.out.println("\t\t ex3: fib [number]");
    }

    private static void ex2(String[] args) {
        System.out.println("2. cl args");
        System.out.println("\ti. number of args: " + args.length);
        System.out.println("\tii.");
        for (String var : args)
            System.out.println("\t\t" + var);
        System.out.println("\tiii.");
        for (int i = 0; i < args.length; i++)
            System.out.println("\t\t " + (i + 1)  + ". " + args[i]);
        System.out.println("\tiv. reverse");
        for (int i = args.length - 1; i > 0 ; i--)
            System.out.println("\t\t" + args[i]);
        System.out.println("\tv. lengths");
        for (String var : args)
            System.out.println("\t\t" + var.length());
        ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));
        System.out.println("\tvi. sorted");
        Collections.sort(argsList);
        for (String var : argsList)
            System.out.println("\t\t" + var);
        System.out.println("\tvi. frequency");
        for (String var : args) {
            //not sorry for counting each time and printing duplicates, this is boring
            if (Collections.frequency(argsList, var) > 1) 
                System.out.println("\t\t" + var);
        }
    }

    private static void ex3(String arg) {
        int n = Integer.parseInt(arg);
        System.out.println("3. " + n);
        System.out.println("\ti. recursive fib " + fib1(n));
        System.out.println("\ti. iterative fib " + fib2(n));
    }

    private static int fib1(int n) {
        switch (n) {
            case 0: return 0;
            case 1: return 1;
            default: return fib1(n-2) + fib1(n-1);
        }
    } 

    private static int fib2(int n) {
        if (n == 1 || n == 2) return 1;
        int f1 = 0;
        int f2 = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

    private static void ex4(String arg) {
        int n = Integer.parseInt(arg);
        System.out.print("4. divisors of " + n + ": ");
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                System.out.print(i  + " ");
        }
        System.out.println();
    }
}