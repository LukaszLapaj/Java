import java.util.Scanner;

public class AutomorphicNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.print("Podaj liczbę n: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println();
        for (long i = 5, counter = 0; counter < n; i += 10) {
            long i_square = i * i;
            if (("" + i_square).endsWith("" + i)) {
                System.out.println(i + " jest liczbą automorficzną");
                ++counter;
            }
            long k = i + 1;
            long k_square = k * k;
            if (("" + k_square).endsWith("" + k)) {
                System.out.println(k + " jest liczbą automorficzną");
                ++counter;
            }
        }
        System.out.println();
    }
}