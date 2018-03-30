import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
        int N = (args.length == 0) ? 10 : Integer.parseInt(args[0]);
        boolean[][] world = generate(N);
        print(world);
        System.out.println();
        world = nextGen(world);
        print(world);
        Scanner s = new Scanner(System.in);
        while (stillLife(world) && s.nextLine().length() == 0) {
            world = nextGen(world);
            print(world);
        }
    }

    public static void print(boolean[][] grid) {
        String s = "";
        for (boolean[] row : grid) {
            for (boolean val : row) {
                if (val) s += "* ";
                else s += ". ";
            }
            s += "\n";
        }
        System.out.println(s);
    }

    public static boolean[][] generate(int N) {
        boolean[][] grid = new boolean[N][N];
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                if (Math.random() > 0.7) grid[r][c] = true;
            }
        }
        return grid;
    }

    public static boolean stillLife(boolean[][] grid) {
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                if (grid[r][c])
                    return true;
            }
        }
        return false;
    }

    public static boolean[][] nextGen(boolean[][] world) {
        boolean[][] newWorld = new boolean[world.length][world[0].length];
        int num;
        for (int r = 0; r < world.length; ++r) {
            for (int c = 0; c < world[0].length; ++c) {
                num = numNeighbors(world, r, c);
                if (occupiedNext(num, world[r][c])) newWorld[r][c] = true;
            }
        }
        return newWorld;
    }

    public static boolean occupiedNext(int numNeighbors, boolean occupied) {
        if (occupied && (numNeighbors == 2 || numNeighbors == 3))
            return true;
        else if (!occupied && numNeighbors == 3)
            return true;
        else
            return false;
    }

    private static int numNeighbors(boolean[][] world, int row, int col) {
        int num = world[row][col] ? -1 : 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (inbounds(world, r, c) && world[r][c]) {
                    num++;
                }
            }
        }
        return num;
    }

    private static boolean inbounds(boolean[][] world, int r, int c) {
        return r >= 0 && r < world.length && c >= 0 && c < world[0].length;
    }
}