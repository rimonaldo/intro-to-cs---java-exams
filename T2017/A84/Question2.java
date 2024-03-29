package T2017.A84;

public class Question2 {
    // moving s steps of array a
    // is a transformation of EVERY item of index i to index s+i
    // * the transformation is circular :
    // if array in size n , and transofrmation of size s than
    // a[n-s] -> a[0]
    // a[n-(s-1)] -> a[1]

    // we are given an array that has been transformed S: arr -> arr2
    // size of s is unknown (could also be 0)
    // and a number - sum
    // return if'f true if there are 2 numbers that sums to sum

    // what do i know about this problem:
    // brute force solution would be :
    // O(N^2) - for each item -> sum with each other item
    // * i should write a better solution than brute force

    // i have kind of a sorted array

    // binary search dosnt look to be good here O(logn)

    // sliding window might work here O(n) X

    // sorting the array and
    // i can for each item in the array, run a binary search - that would work and
    // will be O(nlogn)

    // two pointers

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
