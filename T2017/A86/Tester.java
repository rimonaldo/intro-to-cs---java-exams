package T2017.A86;

public class Tester {
    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "gesek";
        String str3 = "sunday";
        String str4 = "saturday";

        // int res = Question1.edit(str1, str2);
        // System.out.println("Question 1 - Tester 1, expected res 1");
        // System.out.println("Actual: " + res);

        // int res2 = Question1.edit(str3, str4);
        // System.out.println("Question 1 - Tester 2, expected res 4");
        // System.out.println("Actual: " + res2);


        // Question 2 
        int [] arr = {-2,0,1,3};
        int [] arr2 = {1,3,4,5,7};
        int threeSum1 = Question2.countTriplets(arr, 2);
        int threeSum2 = Question2.countTriplets(arr2, 12);

        System.out.println("Question 2 - Tester 1, expected res 2");
        System.out.println("Actual: " + threeSum1);

        System.out.println("Question 2 - Tester 2, expected res 4");
        System.out.println("Actual: " + threeSum2);
    }
}
