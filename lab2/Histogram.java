import java.util.Random;

public class Histogram {
    public static void main(String[] args) {
        int n = (args.length == 0) ? 50 : Integer.parseInt(args[0]);
        final int max = 10;
        int[] histArray = new int[max];
        Random rand = new Random();
        System.out.println();
        for (int i = 0; i < n; ++i) {
            int l = rand.nextInt(max);
            histArray[l]++;
        }
        System.out.println();
        for (int i = 0; i < max; ++i) {
            System.out.print(i + " ");
            for (int j = 0; j < histArray[i]; ++j)
                System.out.print("*");
            System.out.println();
        }
        System.out.println();
    }
}