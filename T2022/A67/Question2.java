package T2022.A67;

public class Question2 {
    public static int findMissingIndex(int[] a) {
        int low = 0, high = a.length, mid = (low + (high - low)) / 2;
        int jumpSize = getJumpSize(a);

        while (low <= high && low > -1 && high < a.length) {
            mid = (low + high) / 2;
            int midLeftDiff = a[mid] - a[mid - 1];
            int midRightDiff = a[mid + 1] - a[mid];
            // check left from mid
            if (midLeftDiff != jumpSize) {
                return mid;
            }
            if (midRightDiff != jumpSize) {
                return mid + 1;
            }

            int lengthFromStart = mid - low;
            if (lengthFromStart != 0) {
                if ((a[mid] - a[low]) / lengthFromStart == jumpSize) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return 1;

    }

    public static int getJumpSize(int[] a) {
        int start = 0, end = a.length, mid = (start + (end - start)) / 2;
        int jump;
        if (a[mid] - a[mid - 1] < a[mid + 1] - a[mid]) {
            jump = a[mid] - a[mid - 1];
        } else {
            jump = a[mid + 1] - a[mid];
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] a = { 22, 24, 26, 32, 34, 36, 38, 40 };
        int res = findMissingIndex(a);
        System.out.println("result is : " + res);
    }
}
