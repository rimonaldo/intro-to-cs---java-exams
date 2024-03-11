package T2022.A87;

public class Question2 {
    public static int longestSubarray(int[] a) {
        int max = Integer.MIN_VALUE, startIdx = 0, endIdx = 1;
        int count = 1;
        String str = "";
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < 0) {
                if (a[i + 1] > 0) {
                    count++;
                } else {
                    if (max < count) {
                        str = "start: " + startIdx + ", end: " + i;
                    }
                    max = Math.max(max, count);
                    endIdx = i;
                    startIdx = i + 1;
                    count = 1;
                }

            }

            if (a[i] > 0) {
                if (a[i + 1] < 0) {
                    count++;
                } else {
                    if (max < count) {
                        str = "start: " + startIdx + ", end: " + i;
                    }
                    max = Math.max(max, count);
                    endIdx = i;
                    startIdx = i + 1;
                    count = 1;
                }

            }

        }
        System.out.println(str);
        return max;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, -1, 5, 2, 2 };
        int res = longestSubarray(a);
        System.out.println("result is: " + res);
    }
}
