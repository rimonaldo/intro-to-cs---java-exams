package T2021.B92;

public class Qustion2 {
    // time - O(n)
    // memory - O(1)
    public static int longestSequence(int[] a, int k) {
        int zeroIdx = 0;
        int zeroCount = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int zeroSum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                zeroCount++;
                zeroSum++;
                if (zeroCount > k) {
                    max = Math.max(max, count);
                    count = i - zeroIdx;
                    zeroIdx = i;
                    zeroCount--;
                    if (zeroCount == 0) {
                        count = 0;
                    }
                } else {
                    zeroIdx = i;
                    count++;
                }
            } else {
                count++;
            }

        }
        if (zeroSum <= k) {
            return a.length;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
        int k = 0;
        int res = longestSequence(a, k);
        System.out.println(res);
    }
}
