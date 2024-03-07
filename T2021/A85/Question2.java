package T2021.A85;

public class Question2 {
    // true if exists avg x
    // print the idxs of the avg
    public static boolean findAverage(int[] arr, double x) {
        double avg = arr[0];
        int left = 0, right = 0;
        double amt = 1.0;
        double sum = arr[0];
        if (arr[left] > x) {
            return false;
        }
        while (left <= right) {
            if (avg == x) {
                System.out.println(left + "---" + right);
                return true;
            }
            if (avg < x) {
                sum -= arr[left];
                left++;
                right++;
                sum += arr[right];
            } else {
                left--;
                sum += arr[left];
                amt++;
            }

            avg = sum / amt;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 8, 14, 15, 35 };
        double x = 8;

        boolean res = findAverage(arr, x);

        System.out.println(res);
    }
}
