package T2020.A85;

public class Question2 {
    // if next num > curr num
    // increment sorted arrays count

    public static int strictlyIncreasing(int[] a) {
        int incBy = 0;
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] > a[i]) {
                incBy++;
                sum += incBy;
            } else {
                incBy = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 4, 5 };

        int res = strictlyIncreasing(a);

        System.out.println("expected res: 4");
        System.out.println("Actual: " + res);
    }
}
