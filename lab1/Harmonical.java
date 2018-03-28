import java.util.Scanner;
import java.util.Locale;

public class Harmonical {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner s = new Scanner(System.in);
        double denominator = 0.0;
        int n = 0;
        System.out.println();
        while (s.hasNextDouble()) {
            double number = s.nextDouble();
            if (Math.abs(number) > 1e-10) {
                denominator += 1 / number;
                ++n;
            }
        }
        System.out.println();
        if (n == 0 || Math.abs(denominator) < 1e-10)
            System.out.println("Nie podano liczb lub mianownik = 0");
        else
            System.out.println("Srednia harmoniczna z podanych liczb to: " + n / denominator);
        System.out.println();
    }
}