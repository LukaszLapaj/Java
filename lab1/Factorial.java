import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println();
        int n = -1;
        while (n < 0) {
            System.out.println("Podaj n > 0: ");
            n = s.nextInt();
        }
        System.out.println(n + "! = " + factorialIter(n) + " / " + factorialRec(n));
        System.out.println();
    }

    static long factorialIter(long n) {
        long f = 1;
        while (n > 1) f *= n--;
        return f;
    }

    static long factorialRec(long n) {
        return (n < 2) ? 1 : n * factorialRec(n - 1);
    }
}