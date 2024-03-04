package T2018.A85;

public class Question1 {
    public static int longestSlope(int[][] mat, int num) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] visitMap = new int[row][col];
        visitMap = populateUnvisitedMap(visitMap, 0, 0);
        System.out.println(visitMap[0][0]);
        int max;

        return 0;

        // int max = Math.max()
        // return findLongestPath(mat, row, col, 0, 0, num);
    }

    public static int longestSlope(int[][] mat, int[][] visitMap, int i, int j, int num) {
        int max = Integer.MIN_VALUE;
        int rows = mat.length;
        int cols = mat[0].length;
        int[] nextCoord = nextUnvisitedCell(visitMap, i, j);

        // if last cell --> return the max from visitMap
        if (nextCoord[0] == rows && nextCoord[1] == cols) {
            return findMax(visitMap, 0, 0, max);
        }

        populateVisitPath(mat, visitMap, nextCoord[i], nextCoord[j], -1, num, 1);
        // recurse for every unvisited cell
        return longestSlope(mat, visitMap, nextCoord[i], nextCoord[j], num);

    }

    public static int findMax(int[][] mat, int i, int j, int max) {
        // all cells checked. returns max
        if (!validCell(mat, i, j + 1) && !validCell(mat, i + 1, j)) {
            return max;
        }

        // if last cell in row, start next row
        if (!validCell(mat, i, j + 1)) {
            return findMax(mat, i + 1, 0, max);
        }

        // if valid cell check max
        if (validCell(mat, i, j)) {
            max = Math.max(max, mat[i][j]);
        }

        // recurse to the next cell
        return findMax(mat, i, j + 1, max);
    }

    public static int[][] populateVisitPath(int[][] ogMat, int[][] visitMap, int i, int j, int prev, int num,
            int count) {
        // if not valid cell
        if (!validCell(ogMat, i, j)) {
            return visitMap;
        }

        // if first cell or a valid slope
        // count slope
        if (prev == -1 || prev - num == ogMat[i][j]) {
            // populate visit map

            visitMap[i][j] = count;
            // keep the check to every direction

            // go down
            populateVisitPath(ogMat, visitMap, i + 1, j, ogMat[i][j], num, count + 1);
            // go right
            populateVisitPath(ogMat, visitMap, i, j + 1, ogMat[i][j], num, count + 1);
            // go up
            populateVisitPath(ogMat, visitMap, i - 1, j, ogMat[i][j], num, count + 1);
            // go left
            populateVisitPath(ogMat, visitMap, i, j - 1, ogMat[i][j], num, count + 1);

        } else {

            visitMap[i][j] = 1;
        }

        return visitMap;

    }

    public static int[] nextUnvisitedCell(int[][] roadMap, int i, int j) {
        int[] endCoord = { roadMap.length, roadMap[0].length };
        int[] rightCoord = { i, j + 1 };

        if (!validCell(roadMap, i, j + 1) && !validCell(roadMap, i + 1, j)) {
            return endCoord;
        }

        // if next cell not valid
        if (!validCell(roadMap, i, j + 1)) {
            // try next row first col
            return nextUnvisitedCell(roadMap, i + 1, 0);
        }

        if (validCell(roadMap, i, j)) {
            if (roadMap[i][j] == -1) {
                // if current cell unvisited , return it
                int[] currCoord = { i, j };
                return currCoord;
            }
        }

        // check if right move still in bounds
        if (validCell(roadMap, i, j + 1)) {
            // if in bounds check if next cell visited
            if (roadMap[i][j + 1] == -1) {
                // if not visited , return next cell
                return rightCoord;
            } else {
                // if in bounds but visited all row
                // recur to next row at first col
                return nextUnvisitedCell(roadMap, i, j + 1);
            }
        }

        // if not
        return nextUnvisitedCell(roadMap, i + 1, 0);

    }

    public static boolean validCell(int[][] mat, int i, int j) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (i < 0 || i == rows || j < 0 || j == cols) {
            return false;
        }
        return true;
    }

    public static int[][] populateUnvisitedMap(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;

        if (i == m) {
            return mat;
        }
        if (j == n) {
            return populateUnvisitedMap(mat, i + 1, 0);
        }

        mat[i][j] = -1;

        return populateUnvisitedMap(mat, i, j + 1);
    }

    public static void main(String[] args) {
        int[] row1 = { 3, 13, 15, 28, 30 };
        int[] row2 = { 55, 54, 53, 27, 26 };
        int[] row3 = { 54, 12, 52, 51, 50 };
        int[] row4 = { 50, 10, 8, 53, 11 };

        int[] r11 = { 5, 4, 6 };
        int[] r12 = { 4, 9, 6 };
        int[] r13 = { 3, 4, 6 };

        int[] r1 = { 5, 4, 3 };
        int[] r2 = { 4, 1, 2 };
        int[] r3 = { 3, 4, 1 };

        int[][] mat = { r11, r12, r13 };
        int[][] visitMap = populateUnvisitedMap(mat, 0, 0);

        int[][] matOG = { r1, r2, r3 };
        // int[][] resMat = populateVisitPath(matOG, visitMap, 0, 0, -1, 1, 1);

        // int[][] map = { r1, r2, r3 };
        // int[] res = nextUnvisitedCell(map, 0, 0);

        // longestSlope(mat, 0);
        int longestSlope = longestSlope(matOG, visitMap, 0, 0, 1);
        System.out.println("test longest slope, expected : 5");
        System.out.println("Actual: " + longestSlope);

        // int x = res[0];
        // int y = res[1];
        // System.out.println("coordinates of next unsivisted cell:" + x + "," + y);
    }

}
