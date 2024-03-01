package T2017.A86;

public class Question2 {
    public static int countTriplets(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int sum = 0;
        int total = 0;
        // for each element in the array
        for (int i = 0; i < arr.length; i++) {
            // start sum as element
            sum = arr[i];
            r = arr.length - 1;
            while (l < r) {
                l = i + 1;
                if (r > arr.length - 1) {
                    break;
                }
                // sum from the next element
                // two sum (two pointers)
                sum += arr[l] + arr[r];

                if (sum < num) {
                    total++;
                    r++;
                } else {
                    l--;
                    
                }

            }
        }
        return total;
    }
}
