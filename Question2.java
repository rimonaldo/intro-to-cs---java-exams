public class Question2 {

    public static int longestSubarray(int[] a) {
        boolean positive = (a[0] > 0) ? true : false;
        int i = 0;
        int j = 1;
        int iMax = -1;
        int jMax = -1;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while (i < a.length && j < a.length) {
            if (positive) {
                if (a[j] < 0) {
                    count++;
                } else {
                    i = j;
                    count = 0;
                }
            } else {
                if (a[j] > 0) {
                    count++;
                } else {
                    i = j;
                    count = 0;
                }
            }
            if (count > max) {
                max = count;
                iMax = i;
                jMax = j;
            }
            j++;
            positive = !positive;
        }
        System.out.println("Starting index = " + iMax + " Ending index = " + jMax);
        return max;
    }

    public static void main(String[] args) {
        int[] a1 = { -1, 1, -1, 5, 2, 2 };
        int[] a2 = { 3, 3, 2, -7, 2, 1, 1, -2, 2 };
        int[] a3 = { 1, 2, 3, 4, 5, 4 };
        int[] a4 = { 1, -2, 3, -4, -4, 4, 2, -4, 6, -2 };

        System.out.println(longestSubarray(a1)); // 3
        System.out.println(longestSubarray(a2)); // 3
        System.out.println(longestSubarray(a3)); // 1
        System.out.println(longestSubarray(a4)); // 4
    }
}
