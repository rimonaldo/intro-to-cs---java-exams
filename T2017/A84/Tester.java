package T2017.A84;

public class Tester {
    public static void main(String[] args) {
        // Question 1
        int a = Question1.ways(4, 2);
        int expected = 4;

        System.out.print("k: " + 4);
        System.out.print(", n: " + 2);
        System.out.print(", Expected: " + expected);
        System.out.print(", Actual: " + a);
        System.out.println(", Test passed: " + (a == expected));

        int b = Question1.ways(0, 0);
        int expectedB = 1;

        System.out.print("k: " + 0);
        System.out.print(", n: " + 0);
        System.out.print(", Expected: " + expectedB);
        System.out.print(", Actual: " + b);
        System.out.println("Test passed: " + (b == expectedB));

        // Question 2
        boolean sum = Question2.findSum(new int[] { 65, 70, -5, 3, 48, 49, 52 }, 44);
        System.out.println("test expected true: " + sum);
        boolean sum2 = Question2.findSum(new int[] { 8, 9, 12, 14, 16, 0, 1 }, 26);
        System.out.println("test2 expected true: " + sum2);

        // Question 3

        // T1
        // Level 1
        Node root1 = new Node(30);

        // Level 2
        root1.setLeftSon(new Node(35));
        root1.setRightSon(new Node(20));

        // Level 3
        root1.getLeftSon().setLeftSon(new Node(2));
        root1.getLeftSon().setRightSon(new Node(7));
        root1.getRightSon().setLeftSon(new Node(8));
        root1.getRightSon().setRightSon(new Node(25));

        // Level 4
        root1.getLeftSon().getLeftSon().setRightSon(new Node(44));
        root1.getLeftSon().getRightSon().setLeftSon(new Node(10));
        root1.getRightSon().getLeftSon().setRightSon(new Node(40));
        root1.getRightSon().getRightSon().setRightSon(new Node(60));

        // Level 5
        root1.getLeftSon().getLeftSon().getRightSon().setLeftSon(new Node(28));
        root1.getRightSon().getLeftSon().getRightSon().setLeftSon(new Node(24));
        root1.getRightSon().getLeftSon().getRightSon().getLeftSon().setRightSon(new Node(37));

        // T2
        // level 1
        Node root2 = new Node(30);

        // level 2
        root2.setLeftSon(new Node(35));
        root2.setRightSon(new Node(20));

        // level 3
        root2.getLeftSon().setLeftSon(new Node(2));
        root2.getLeftSon().setRightSon(new Node(7));
        root2.getLeftSon().getRightSon().setRightSon(new Node(10));
        root2.getRightSon().setRightSon(new Node(20));
        root2.getRightSon().getRightSon().setRightSon(new Node(25));

        // level 4
        root2.getLeftSon().getLeftSon().setRightSon(new Node(44));

        // T3
        // level 1
        Node root3 = new Node(35);

        // level 2
        root3.setLeftSon(new Node(7));
        root3.setRightSon(new Node(2));

        root3.getRightSon().setLeftSon(new Node(60));
        root3.getRightSon().getLeftSon().setRightSon(new Node(8));
        root3.getRightSon().getLeftSon().getRightSon().setLeftSon(new Node(24));
        root3.getRightSon().setRightSon(new Node(28));

        // level 3
        root2.getLeftSon().setLeftSon(new Node(10));
        root2.getLeftSon().setRightSon(new Node(37));

        // level 4
        root2.getLeftSon().getRightSon().setLeftSon(new Node(44));

        boolean bol = root1.what(root1, 37);
        boolean bol2 = root1.what(root1, 15);

        System.out.println("Question 3.a) expeted true: " + bol);
        System.out.println("Question 3.a) expeted false: " + bol2);
        
        
        boolean secret3 = Node.secret(root1, root3);
        System.out.println("Question 3.c) expeted true: " + secret3);


        // Question 4 is not in cyllabus

        // Question 5 linked list
        
    }
}
