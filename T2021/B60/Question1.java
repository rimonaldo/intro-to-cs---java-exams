package T2021.B60;

public class Question1 {
    public static boolean split(int[] arr) {
        return split(arr, 0, 0, 0, 0);
    }

    public static boolean split(int[] arr, int sum1, int sum2, int sum3, int i) {
        if (sum1 > 0 && sum1 == sum2 && sum2 == sum3) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        return split(arr, sum1 + arr[i], sum2, sum3, i + 1)
                || split(arr, sum1, sum2 + arr[i], sum3, i + 1)
                || split(arr, sum1, sum2, sum3 + arr[i], i + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 7, 1, 2, 3, 5 };
        boolean res = split(arr);

        System.out.println(res);
    }
}
