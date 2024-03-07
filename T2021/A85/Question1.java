package T2021.A85;

public class Question1 {
    // cheapest train ticket
    // if i stay in the same row (same train line)
    // sum = [i][j+1]

    // if i change line (aka down row)
    // sum += [i+1][j+1]

    public static int minPrice(int[][] mat) {
        return minPrice(mat, 0, 1, 15, 0);
    }

    public static int minPrice(int[][] mat, int i, int j, int price, int prevPrice) {
        if (j >= mat[0].length) {
            return prevPrice;
        }
        if (i >= mat.length - 1) {
            return Integer.MAX_VALUE;
        }

        return 0;

    }

    public static boolean stationExists(int[][] mat, int i, int j) {
        if (i < 0 || i == mat.length - 1 || j == mat.length - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] line1 = { 0, 15, 80, 90 };
        int[] line2 = { -1, 0, 40, 50 };
        int[] line3 = { -1, -1, 0, 70 };
        int[] line4 = { -1, -1, -1, 0 };

        int[][] trainGrid = { line1, line2, line3, line4 };

        int trainCost = minPrice(trainGrid);

        System.out.println(trainCost);
    }
}
