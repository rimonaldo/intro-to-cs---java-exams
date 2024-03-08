package T2021.B60;

public class Question2 {
    public static int smallestSub(int[] a, int k) {
        int sum = 0;
        // sum the array
        for (int i = 0; i < a.length; i++) {
            // if exists element bigger than k
            // smallest sub length is 1
            if (a[i] > k) {
                return 1;
            }
            sum += a[i];
        }

        // if the sum of the array is smaller than k
        // we wont find bigger subset
        if (sum <= k) {
            return a.length;
        }

        // start sliding window
        int r = a.length - 1;
        int l = 0;
        while (l < r) {
            // if not possible to close window from left(window sum not bigger than k)
            if (sum - a[l] < k) {
                // check if possible to close window from right
                if (sum - a[r] > k) {
                    // if possible, close window
                    sum -= a[r];
                    r--;
                } else {
                    // if not possible,
                    return (r - l) + 1;
                }
            }

            // if is possible to close window from left (window sum still bigger than k)
            if (sum - a[l] > k) {
                // close window from left
                sum -= a[l];
                l++;
            }
        }
        return a.length;
    }

    public static void main(String[] args) {
        int[] a = { 1, 4, 13, 6, 0, 19 };
        int k = 26;
        int res = smallestSub(a, k);

        System.out.println(res);
    }
}
