package T2019.A84;

public class Question2 {
    // sum the array
    //

    public static int avarge(int[] arr) {
        int sum = 0, leftSum = 0, rightSum = 0;
        int max = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;
        int leftAvg, rightAvg, leftAmt, rightAmt;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        rightSum = sum;
        for (int i = 0; i < arr.length - 1; i++) {

            rightSum -= arr[i];
            leftSum += arr[i];
            leftAmt = i + 1;
            rightAmt = arr.length - leftAmt;
            leftAvg = leftSum / leftAmt;
            // finishing loop at the last index
            // so we wont have 0 items on the right side
            rightAvg = rightSum / rightAmt;

            if (Math.abs(leftAvg - rightAvg) > max) {
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, -2, 10 };
        int res = avarge(arr);

        System.out.println("expected res: 2");
        System.out.println("Actual: " + res);

    }
}
