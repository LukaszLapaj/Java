import java.util.Scanner;

class Divisors {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("Podaj n: ");
        int n = s.nextInt();
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0)
                System.out.println("Podzielnik: " + i);
        }
        System.out.println();
    }
}