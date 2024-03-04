public class Question1 {
    public static int longestSlope(int[][] mat, int num) {
        return longestSlopeHelper(mat, num, 0, 0, Integer.MIN_VALUE, 0, 0);
    }

    public static int longestSlopeHelper(int[][] mat, int num, int i, int j, int prev, int count, int max) {
        if (i >= mat.length || j >= mat[0].length) { // If we have traversed all cells
            return max;
        }

        int nextI = i;
        int nextJ = j + 1;
        if (nextJ == mat[0].length) { // If we have traversed all columns of the current row
            nextI = i + 1;
            nextJ = 0;
        }

        int newCount = (Math.abs(prev - mat[i][j]) == num) ? count + 1 : 1;
        max = Math.max(max, newCount);
        
        return longestSlopeHelper(mat, num, nextI, nextJ, mat[i][j], newCount, max);
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 3, 13, 15, 28, 30 },
                { 55, 54, 53, 27, 26 },
                { 54, 12, 52, 51, 50 },
                { 50, 10, 8, 53, 11 }
        };
        System.out.println(longestSlope(mat, 1)); // 6
        System.out.println(longestSlope(mat, 2)); // 3
    }
}
