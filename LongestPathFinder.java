public class LongestPathFinder {

    // Method to initiate the recursive traversal to find the longest increasing path
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        return traverseMatrix(matrix, 0, 0, cache, 0);
    }

    // Recursively traverse the matrix to find the longest path from each cell
    private static int traverseMatrix(int[][] matrix, int i, int j, int[][] cache, int max) {
        if (i >= matrix.length) return max; // Finished traversing the matrix
        if (j >= matrix[0].length) return traverseMatrix(matrix, i + 1, 0, cache, max); // Move to the next row

        int localMax = dfs(matrix, i, j, cache);
        max = Math.max(max, localMax);
        return traverseMatrix(matrix, i, j + 1, cache, max); // Process the next cell in the row
    }

    // DFS to find the longest increasing path from a cell
    private static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        cache[i][j] = 1; // Mark the current cell as visited with a path length of 1 to start.
        return dfsDirection(matrix, i, j, cache, 0, 1);
    }

    private static int dfsDirection(int[][] matrix, int i, int j, int[][] cache, int dirIndex, int maxPath) {
        if (dirIndex == 4) return maxPath; // Base case: all directions are tried.

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int x = i + directions[dirIndex][0], y = j + directions[dirIndex][1];

        if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
            if (cache[x][y] == 0) { // If not already computed, compute the DFS from this new cell.
                dfs(matrix, x, y, cache);
            }
            maxPath = Math.max(maxPath, 1 + cache[x][y]);
        }

        cache[i][j] = Math.max(cache[i][j], maxPath);
        return dfsDirection(matrix, i, j, cache, dirIndex + 1, maxPath); // Try the next direction
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println("Longest increasing path length: " + longestIncreasingPath(matrix));
    }
}
