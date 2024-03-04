public class Question2 {

    public static int findSingle(int[] a) {
        int start = 0, end = a.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 0) {
                if (a[mid] == a[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            } else {
                if (a[mid] == a[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        return a[start];
    }

    public static void main(String[] args) {
        int[] a = { 6, 6, 18, 18, -4, -4, 12, 9, 9 };
        int[] b = { 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4 };
        int[] c = { 5 };
        System.out.println(findSingle(a));
        System.out.println(findSingle(b));
        System.out.println(findSingle(c));
    }
}