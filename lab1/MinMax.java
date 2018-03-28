import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long number;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        System.out.println();
        while (s.hasNextInt()) {
            number = s.nextInt();
            if (number < min) min = number;
            if (number > max) max = number;
        }
        System.out.println();
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println();
    }
}