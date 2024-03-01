package T2017.A84;

public class Question1 {
    // The amount of ways to get from origin point
    // to a point "n" further to the right
    // in exactly "k" amount of steps
    public static int ways(int k, int n) {
        // Base case:
        // if no more steps left
        if (k == 0) {
            if (n == 0) {
                // if were in the target return 1 (found 1 way)
                return 1;
            } else {
                // else , return 0 (no way was found)
                return 0;
            }
        }
        // Reccursive step:
        // return all the possible ways if going left
        // + all the possible ways of going right
        return ways(k - 1, n - 1) + ways(k - 1, n + 1);
    }

}