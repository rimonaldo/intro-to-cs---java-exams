package T2017.A86;

public class Question2 {
    /**
     * Counts the number of triplets in the given array whose sum is less than the specified number.
     *
     * @param arr The input array of integers.
     * @param num The specified number.
     * @return The count of triplets whose sum is less than the specified number.
     */
    public static int countTriplets(int[] arr, int num) {
        int l = 1;
        int r = 2;
        int sum = 0;
        int total = 0;
        // for each element in the array
        for (int i = 0; i < arr.length; i++) {
            // start sum as element
            sum = arr[i];
            l = i + 1;
            r = l + 1;
            // iterate through all possible triplets
            while (l < arr.length - 1) {
                while (r < arr.length) {
                    // check if sum of triplet is less than num
                    if (arr[i] + arr[l] + arr[r] < num) {
                        total++;
                    }
                    r++;
                }
                l++;
                r = l + 1;
            }
        }
        return total;
    }
}
