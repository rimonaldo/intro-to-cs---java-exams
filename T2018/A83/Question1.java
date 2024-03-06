package T2018.A83;

public class Question1 {

    public static int prince(int[][] drm, int i, int j) {
        int[][] emptyMat = new int[drm.length][drm[0].length];
        int[][] travelMap = createUnvisitedMap(emptyMat, i, j);

        if (drm[i][j] == -1) {
        }

        populateVisitPath(drm, travelMap, i, j, -2, j);
        return findMin(travelMap, 0, 0, Integer.MAX_VALUE);

    }

    public static int prince(int[][] drm, int i, int j, int sum) {
        int currCell = drm[i][j];
        int right = 0;
        int down = 0;
        int left = 0;
        int up = 0;
        if (currCell == -1) {
            return sum;
        }

        if (validJump(drm, i, j + 1, currCell)) {
            right = prince(drm, i, j + 1, sum + 1);
        }

        if (validJump(drm, i + 1, j, currCell)) {
            down = prince(drm, i + 1, j, sum + 1);
        }

        if (validJump(drm, i, j - 1, currCell)) {
            left = prince(drm, i, j - 1, sum + 1);
        }

        if (validJump(drm, i - 1, j, currCell)) {
            up = prince(drm, i - 1, j, sum);
        }

        return Math.min(Math.min(right, up), Math.min(left, down));

    }

    public static int[][] createUnvisitedMap(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;

        if (i == m) {
            return mat;
        }
        if (j == n) {
            return createUnvisitedMap(mat, i + 1, 0);
        }

        mat[i][j] = -1;

        return createUnvisitedMap(mat, i, j + 1);
    }

    public static int[][] populateVisitPath(int[][] mat, int[][] visitMap, int i, int j, int prev,
            int count) {
        // if not valid cell
        if (!validCell(mat, i, j)) {
            return visitMap;
        }

        if (mat[i][j] == -1) {
            return visitMap;
        }

        // if first cell or a valid slope
        // count slope
        if (prev == -2 || validJump(mat, i, j, prev)) {
            // populate visit map

            visitMap[i][j] = count;
            // keep the check to every direction

            // go down
            populateVisitPath(mat, visitMap, i + 1, j, mat[i][j], count + 1);
            // go right
            populateVisitPath(mat, visitMap, i, j + 1, mat[i][j], count + 1);
            // go up
            populateVisitPath(mat, visitMap, i - 1, j, mat[i][j], count + 1);
            // go left
            populateVisitPath(mat, visitMap, i, j - 1, mat[i][j], count + 1);

        } else {
            visitMap[i][j] = 1;
        }

        return visitMap;

    }

    public static boolean validCell(int[][] mat, int i, int j) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (i < 0 || i == rows || j < 0 || j == cols) {
            return false;
        }
        return true;
    }

    public static int findMin(int[][] mat, int i, int j, int min) {
        // all cells checked. returns max
        if (!validCell(mat, i, j + 1) && !validCell(mat, i + 1, j)) {
            return min;
        }

        // if last cell in row, start next row
        if (!validCell(mat, i, j + 1)) {
            return findMin(mat, i + 1, 0, min);
        }

        // if valid cell check max
        if (validCell(mat, i, j)) {
            min = Math.min(min, mat[i][j]);
        }

        // recurse to the next cell
        return findMin(mat, i, j + 1, min);
    }

    public static int[][] copyMat(int[][] mat, int[][] matToFill, int i) {
        if (i == mat.length) {
            return matToFill;
        }
        int[] emptyRow = new int[mat[0].length];
        matToFill[i] = copyRow(mat[i], emptyRow, 0);

        return copyMat(mat, matToFill, i + 1);
    }

    public static int[] copyRow(int[] row, int[] rowToFill, int j) {
        if (j == row.length) {
            return rowToFill;
        }
        rowToFill[j] = row[j];

        return copyRow(row, rowToFill, j + 1);
    }

    public static boolean validJump(int[][] mat, int i, int j, int prev) {
        if (!validCell(mat, i, j)) {
            return false;
        }
        if (prev - mat[i][j] <= 2 && prev - mat[i][j] >= -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] row1 = { 2, 0, 1, 2, 3 };
        int[] row2 = { 2, 3, 5, 5, 4 };
        int[] row3 = { 8, -1, 6, 8, 7 };
        int[] row4 = { 3, 4, 7, 2, 4 };
        int[] row5 = { 2, 4, 3, 1, 2 };

        int[][] mat = { row1, row2, row3, row4, row5 };

        int[][] emptyMat = new int[mat.length][mat[0].length];

        int[][] matCopy = copyMat(mat, emptyMat, 0);

        int[][] visitMap = createUnvisitedMap(emptyMat, 0, 0);

        int shortest = prince(mat, 0, 0);

        System.out.println(shortest);
    }
}