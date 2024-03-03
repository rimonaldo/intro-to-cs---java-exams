package T2017.A90;

public class Question2 {
    public static int findSmallest(int arr[]) {
        int sum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum < arr[i])
                return sum;
            sum += arr[i];
        }
        return sum;
    }
}
