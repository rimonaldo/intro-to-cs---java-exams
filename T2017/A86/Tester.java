package T2017.A86;

public class Tester {
    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "gesek";
        String str3 = "sunday";
        String str4 = "saturday";

        int res = Question1.edit(str1, str2);
        System.out.println("Question 1 - Tester 1, expected res 1");
        System.out.println("Actual: " + res);

        int res2 = Question1.edit(str3, str4);
        System.out.println("Question 1 - Tester 2, expected res 4");
        System.out.println("Actual: " + res2);

        System.out.println("Q2_________________________ ");

        // Question 2
        int[] arr = { -2, 0, 1, 3 };
        int[] arr2 = { 1, 3, 4, 5, 7 };
        int threeSum1 = Question2.countTriplets(arr, 2);
        int threeSum2 = Question2.countTriplets(arr2, 12);

        System.out.println("Question 2 - Tester 1, expected res 2");
        System.out.println("Actual: " + threeSum1);

        System.out.println("Question 2 - Tester 2, expected res 4");
        System.out.println("Actual: " + threeSum2);

        Node root = new Node(30);
        root.setLeftSon(new Node(20));
        root.getLeftSon().setRightSon(new Node(70));
        root.getLeftSon().setLeftSon(new Node(50));

        root.getLeftSon().getRightSon().setLeftSon(new Node(40));
        root.getLeftSon().getRightSon().setRightSon(new Node(60));
        root.getLeftSon().getRightSon().setLeftSon(new Node(40));
        root.getLeftSon().getLeftSon().setLeftSon(new Node(50));
        root.getLeftSon().getLeftSon().setLeftSon(new Node(150));

        root.getLeftSon().getRightSon().getLeftSon().setRightSon(new Node(100));

        root.setRightSon(new Node(40));
        root.getRightSon().setRightSon(new Node(50));

        int res3 = root.what(root);

        System.out.println("QUESTION3_____________");
        System.out.println("question 3 result:" + res3);

        // Question 4 --> not in cyllabus

        // Question 5 - Linked lists

        IntList intList = new IntList();
        IntNode head = new IntNode(-2, null);
        IntNode a = new IntNode(-3, null);
        IntNode b = new IntNode(-4, null);
        IntNode c = new IntNode(-2, null);
        IntNode d = new IntNode(1, null);
        IntNode e = new IntNode(5, null);
        IntNode f = new IntNode(-3, null);
        head.setNext(a);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        
        intList.setHead(head);
        int res5 = intList.method1();

        System.out.println(res5);
    }
}
