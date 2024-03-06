package T2020.A85;

public class Question1 {
    // if index % 2 == 0 --> can only go right or down
    // if index % 2 != 0 --> can only go left or down

    // need to return the max points possible in a path
    // need to traverse every possible path

    public static int findMaximum(int[][] mat) {
        boolean[][] visitedMap = visitedMap(mat.length, mat[0].length);
        return findMaximum(mat, visitedMap, 0, 0, 0);
    }

    public static int findMaximum(int[][] mat, boolean[][] visitedMap, int i, int j, int sum) {
        int currCell = mat[i][j];
        // mark cell as visited
        visitedMap[i][j] = true;

        // check moves (in bounds and not visited)

        // check move right
        if (validMove(visitedMap, i, j + 1)) {
            if (i % 2 == 0) {
                sum = Math.max(sum, findMaximum(mat, visitedMap, i, j + 1, sum + currCell));
            }
        }
        // check move down
        if (validMove(visitedMap, i + 1, j)) {
            sum = Math.max(sum, findMaximum(mat, visitedMap, i + 1, j, sum + currCell));
        }
        // check move left
        if (validMove(visitedMap, i, j - 1)) {
            if (i % 2 != 0) {
                sum = Math.max(sum, findMaximum(mat, visitedMap, i, j - 1, sum + currCell));
            }
        }

        return sum;

    }

    public static boolean[][] visitedMap(int m, int n) {
        return new boolean[m][n];
    }

    public static boolean validMove(boolean[][] visitedMap, int i, int j) {
        // if cell out of bounds
        if (i < 0 || i == visitedMap.length || j < 0 || j == visitedMap[0].length) {
            return false;
        }

        // if cell visited
        if (visitedMap[i][j] == true) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] row1 = { 1, 1, -1, 1, 1 };
        int[] row2 = { 1, 0, 0, -1, 1 };
        int[] row3 = { 1, 1, 1, 1, -1 };
        int[] row4 = { -1, -1, 1, 1, 1 };
        int[] row5 = { 1, 1, -1, -1, 1 };

        int[] r1 = { 1, 0, -1 };
        int[] r2 = { 1, 1, 0 };
        int[] r3 = { 0, 0, 1 };

        int[][] mat = { row1, row2, row3, row4, row5 };
        int[][] mat2 = { r1, r2, r3 };

        int res = findMaximum(mat2);

        System.out.println("expected result: 9");
        System.out.println("actual: " + res);

    }

}
