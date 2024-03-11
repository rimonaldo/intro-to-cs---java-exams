package T2022.A67;

public class Qustion1 {
    public static boolean isIdentity(int[][] mat, int x, int size) {
        if (size == 1) {
            if (mat[x][x] == 1) {
                return true;
            }
        }
        return isIdentity(mat, x, size, 0);
    }

    public static boolean isIdentity(int[][] mat, int x, int size, int n) {

        if (!isValidX(mat, x + n, n)) {
            return false;
        }

        if (n == size - 1) {
            return true;
        }

        return isIdentity(mat, x, size, n + 1);

    }

    public static boolean isValidX(int[][] mat, int x, int n) {
        if (n == 0) {
            return true;
        }
        if (x - n < 0) {
            return true;
        }
        // check column
        if (mat[x - n][x] != 0) {
            return false;
        }

        // check row
        if (mat[x][x - n] != 0) {
            return false;
        }

        return isValidX(mat, x, n - 1);
    }

    public static void main(String[] args) {
        int[] r1 = { 1, 0, 0, 0, 3 };
        int[] r2 = { 0, 1, 0, 0, 0 };
        int[] r3 = { 0, 0, 1, 0, 0 };
        int[] r4 = { 0, 0, 0, 1, 0 };
        int[] r5 = { 0, 0, 0, 0, 1 };

        int[][] mat = { r1, r2, r3, r4, r5 };
        boolean res = isIdentity(mat, 0, 5);

        System.out.println(res);
    }
}
