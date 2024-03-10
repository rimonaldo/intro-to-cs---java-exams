package T2021.B62;

public class Question1 {
    public static boolean equalSplit(int[] arr) {
        return equalSplit(arr, 0, 0, 0, 0);
    }

    public static boolean equalSplit(int[] arr, int i, int sum1, int sum2, int itemCount) {
        // if array not even, there is no 2 equal subsets
        if (arr.length % 2 != 0) {
            return false;
        }

        // if item count * 2 bigger than array,
        // we have summed more than half of array to sum1
        if (itemCount * 2 > arr.length) {
            return false;
        }

        // after summing all aray to 2 sums
        if (i == arr.length) {
            // if sums are equal and equal in size
            if (sum1 == sum2 && itemCount * 2 == arr.length) {
                return true;
            } else {
                return false;
            }
        }

        return equalSplit(arr, i + 1, sum1 + arr[i], sum2, itemCount + 1)
                || equalSplit(arr, i + 1, sum1, sum2 + arr[i], itemCount);
    }

    public static void main(String[] args) {
        int[] arr = { -3, 5, 12, 14, -9, 13 };

        boolean res = equalSplit(arr);

        System.out.println(res);
    }
}
