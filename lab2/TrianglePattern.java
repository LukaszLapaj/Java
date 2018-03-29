public class TrianglePattern {
    public static void main(String[] args) {
        int dimension = (args.length == 0) ? 12 : Integer.parseInt(args[0]);
        System.out.println();
        for (int i = 0; i < dimension; i++) {
            for (int k = i; k < dimension - 1; ++k)
                System.out.print(" ");
            for (int j = 0; j <= i; ++j)
                System.out.print("*" + " ");
            System.out.println();
        }
    }
}