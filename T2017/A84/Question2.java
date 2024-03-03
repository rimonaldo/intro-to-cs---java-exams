package T2017.A84;

public class Question2 {
    // two pointers
    // find sum 

    // modified binary search to find pivot:
    // L,M,R - if M <= M+1 ---> than this portion is sorted (go left <--)
    // else , this m+1 is the pivot
    // this will have time complexity of O(log n)

    // after finding the pivot we will implement two pointer sum
    // time complexity of O(n)

    // time complexity sums to be : O(log n) + O(n) = O(n + log n)
    // the significant complexity of this is O(n) , therefore O(n) is the overall
    // time complexity

    public static boolean findSum(int[] arr, int sum) {
        // in rotated sorted array
        int l = 0;
        int r = arr.length - 1;
        int pivotIdx = 0;

        // binary search to find pivot
        while (l <= r) {
            int m = l + (r - l) / 2;

            // if m bigger than r (pivot somewhere right)
            if (arr[m] > arr[r]) {
                // if m > m+1 , m+1 is the pivot -> can break loop
                if (arr[m] > arr[m + 1]) {
                    pivotIdx = m + 1;
                    System.err.println("found pivot:" + arr[m + 1]);
                    break;
                } else {
                    // if m not bigger than m+1
                    // well keep searching the right side
                    l = m + 1;
                }
            } else {
                // else, m smaller than r (pivot somwhere left)
                r = m - 1;
                if (arr[m] > arr[m + 1]) {
                    // if m > m+1 , m+1 is the pivot -> can break loop
                    pivotIdx = m + 1;
                    System.err.println("found pivot:" + arr[m + 1]);
                    break;
                }
            }

        }

        // two pointers to find sum of two items
        int low = pivotIdx;
        int high = low - 1;
        while (low != high) {
            // condition to make sure we are not out of array bounds
            if (high < 0) {
                high = arr.length - 1;
            }

            if (low > arr.length - 1) {
                low = 0;
            }

            if (arr[low] + arr[high] == sum) {
                return true;
            }

            if (arr[low] + arr[high] < sum) {
                low++;
            } else {
                if (arr[low] + arr[high] > sum) {
                    high--;
                }
            }
        }
        return false;

    }

}
