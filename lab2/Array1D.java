import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

class Array1D {
    public static void main(String[] args) {
        int MAX = (args.length == 0) ? 10 : Integer.parseInt(args[0]);
        int[] t = new int[MAX];
        fillArray(t);
        int[] sorted = makeSortedCopy(t);
        printArray(t);
        printArray(sorted);
        System.out.println("Wystapien najmniejszej wartosci: " + minCount(sorted));
        System.out.print("Wartosci najwieksze: ");
        printArray(maxValues(sorted, 3));
        System.out.println("Czy ciag jest rosnacy: " + ascending(t));
        System.out.println("Czy ciag jest rosnacy (po posortowaniu): " + ascending(sorted));
        System.out.println("Czy ciag jest malejacy: " + descending(t));
        System.out.println("Czy ciag jest geometryczny: " + geometricProgression(t));
        System.out.println("Czy istnieje wartosc unikalna: " + unique(sorted));
        System.out.println("Maksymalna suma sasiadujacych elementow: " + maxNeigh(t));
        System.out.println();
    }

    static int[] makeSortedCopy(int[] t) {
        int[] sortedArrayCopy = new int[t.length];
        System.arraycopy(t, 0, sortedArrayCopy, 0, t.length);
        Arrays.sort(sortedArrayCopy);
        return sortedArrayCopy;
    }

    static void fillArray(int[] t) {
        Random r = new Random();
        for (int i = 0; i < t.length; ++i) {
            t[i] = r.nextInt(10);
        }
    }

    static void printArray(int[] t) {
        for (int i = 0; i < t.length; ++i) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    static int minCount(int[] t) {
        int min = t[0];
        int counter = 1;
        for (int i = 1; i < t.length && t[i] == min; ++i) {
            counter++;
        }
        return counter;
    }

    static int[] maxValues(int[] t, int n) {
        if (n > t.length) n = t.length;
        int[] max = new int[n];
        for (int i = 0; i < n; ++i) {
            max[i] = t[t.length - i - 1];
        }
        return max;
    }

    static boolean ascending(int[] t) {
        for (int i = 0; i < t.length - 1; ++i) {
            if (t[i] > t[i + 1])
                return false;
        }
        return true;
    }

    static boolean descending(int[] t) {
        for (int i = 0; i < t.length - 1; ++i) {
            if (t[i] < t[i + 1])
                return false;
        }
        return true;
    }

    static boolean geometricProgression(int[] t) {
        if (t.length <= 2)
            return true;
        for (int i = 2; i < t.length - 1; ++i) {
            if (t[1] * t[i - 1] != t[0] * t[i])
                return false;
        }
        return true;
    }

    static boolean unique(int[] t) {
        for (int i = 0; i < t.length - 1; ++i) {
            if (t[i] == t[i + 1])
                return false;
        }
        return true;
    }

    static int maxNeigh(int[] t) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t.length - 1; ++i) {
            if (t[i] + t[i + 1] > max) max = t[i] + t[i + 1];
        }
        return max;
    }
}