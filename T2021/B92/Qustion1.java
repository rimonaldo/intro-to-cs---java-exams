package T2021.B92;

public class Qustion1 {
    public static int printExpr(int[] arr, int num) {
        return printExpr(arr, num, 0, 0, "");
    }

    public static int printExpr(int[] arr, int num, int i, int sum, String str) {
        if (num == sum) {
            System.out.println(str + " = " + num);
            return 1;
        }

        if (i == arr.length) {
            return 0;
        }

        String str1 = " + " + arr[i];
        String str2 = " - " + arr[i];

        return printExpr(arr, num, i + 1, sum - arr[i], str + str2)
                + printExpr(arr, num, i + 1, sum + arr[i], str + str1)
                + printExpr(arr, num, i + 1, sum, str);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 2 };
        int num = 4;
        int res = printExpr(arr, num);
        System.out.println("res is" + res);
    }
}
