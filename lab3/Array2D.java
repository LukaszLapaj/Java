import java.util.Random;
import java.util.Arrays;

class Array2D {
    public static void main(String[] args) {
        int MAX = (args.length == 0) ? 10 : Integer.parseInt(args[0]);
        int[][] t = new int[MAX][MAX];
        fillArray(t);
        printArray(t);
        int[] s = sumDiagonals(t);
        System.out.println("Sumy wartosci na przekatnych: " + s[0] + ", " + s[1]);
        System.out.println("Suma wartosci na krawedziach: " + sumBorder(t));
        System.out.println("Wiersz z najmniejsza maksynalna wartoscia: " + minMax(t));
        System.out.println("Liczba nieparzysta w kazdym wierszu: " + oddRow(t));
        System.out.println("Wiersz wylacznie parzystych: " + !oddRow(t));
        System.out.println("Równa suma wiersza i kolumny: " + sameSum(t));
        System.out.println("Maksymalna suma sasiadow: " + maxSumNeigh(t));
        System.out.println("Wszystlkie liczby unikalne: " + unique(t));
        System.out.println("Liczba unikalnych wartosci: " + numberUniques(t));
    }

    static void fillArray(int[][] t) {
        Random random = new Random();
        for (int i = 0; i < t.length; ++i) {
            for (int j = 0; j < t[i].length; ++j) {
                t[i][j] = random.nextInt(100);
            }
        }
    }

    static void printArray(int[][] t) {
        for (int i = 0; i < t.length; ++i) {
            for (int j = 0; j < t[i].length; ++j) {
                System.out.print(t[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[] sumDiagonals(int[][] t) {
        int[] sum = {0, 0};
        for (int i = 0; i < t.length; ++i) {
            sum[0] += t[i][i];
            sum[1] += t[i][t.length - i - 1];
        }
        return sum;
    }

    static int sumBorder(int[][] t) {
        int sum = 0;
        for (int i = 0; i < t.length; ++i) {
            sum += t[0][i];
            sum += t[t.length - 1][i];
            if (i > 0 && i < t.length - 1) {
                sum += t[i][0];
                sum += t[i][t.length - 1];
            }
        }
        return sum;
    }

    static int minMax(int[][] t) {
        int[] max = new int[t.length];
        for (int i = 0; i < t.length; ++i) {
            max[i] = Integer.MIN_VALUE;
            for (int j = 0; j < t[i].length; ++j) {
                if (t[i][j] > max[i]) max[i] = t[i][j];
            }
        }
        int min = Integer.MAX_VALUE, row = 0;
        for (int i = 0; i < max.length; ++i) {
            if (max[i] < min) {
                min = max[i];
                row = i;
            }
        }
        return row;
    }

    static boolean oddRow(int[][] t) {
        for (int i = 0; i < t.length; ++i) {
            boolean isOdd = false;
            for (int j = 0; j < t[i].length; ++j) {
                if (t[i][j] % 2 == 1) {
                    isOdd = true;
                    continue;
                }
            }
            if (!isOdd)
                return false;
        }
        return true;
    }

    static boolean sameSum(int[][] t) {
        int[] sumr = new int[t.length];
        int[] sumc = new int[t.length];
        for (int i = 0; i < t.length; ++i) {
            sumr[i] = 0;
            sumc[i] = 0;
            for (int j = 0; j < t[i].length; ++j) {
                sumr[i] += t[i][j];
                sumc[j] += t[i][j];
            }
        }
        for (int i = 0; i < t.length; ++i) {
            for (int j = 0; j < t.length; ++j) {
                if (sumr[i] == sumc[j])
                    return true;
            }
        }
        return false;
    }

    static int maxSumNeigh(int[][] t) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t.length; ++i) {
            for (int j = 0; j < t[i].length; ++j) {
                if (i < t.length - 1 && (t[i][j] + t[i + 1][j] > max)) max = t[i][j] + t[i + 1][j];
                if (j < t[i].length - 1 && (t[i][j] + t[i][j + 1] > max)) max = t[i][j] + t[i][j + 1];
            }
        }
        return max;
    }

    static boolean unique(int[][] t) {
        return numberUniques(t) == t.length * t[0].length;
    }

    static int numberUniques(int[][] t) {
        int[] sorted = new int[t.length * t[0].length];
        for (int i = 0; i < t.length; ++i) {
            System.arraycopy(t[i], 0, sorted, i * t[i].length, t[i].length);
        }
        Arrays.sort(sorted);
        int u = 1;
        for (int i = 1; i < sorted.length; ++i) {
            if (sorted[i] != sorted[i - 1]) u++;
        }
        return u;
    }
}