package T2018.A83;

public class Question2 {
    public static int findSingle(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;

        while (start < end) {
            mid = start + (end - start) / 2;

            if (a[mid - 1] != a[mid] && a[mid + 1] != a[mid]) {
                return a[mid];
            }

            if (mid % 2 == 0) {
                // go right
                start = mid + 1;
            } else {
                // go left
                end = mid - 1;
            }
        }
        return a[mid];
    }

    public static void main(String[] args) {
        int[] arr = { 6, 6, 18, 18, -4, -4, 12, 12, 9 };

        int res = findSingle(arr);
        System.out.println("single element is: " + res);
    }
}
