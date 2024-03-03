package T2017.A90;

public class Tester {

    public static void main(String[] args) {
        Item item0 = new Item(10, 60);
        Item item1 = new Item(20, 100);
        Item item2 = new Item(30, 120);
        Item item3 = new Item(15, 200);
        Item[] itemList = { item0, item1, item2, item3 };

        // int res = Question1.knapSack(itemList, 30);

        // System.out.println("Question 1_______________ ");
        // System.out.println("max value: " + res);

        // Q2 not passing all tests
        int[] arr = { 1, 2, 6, 10, 11, 15 };
        int res2 = Question2.findSmallest(arr);

        System.out.println("Question 2_______________ ");
        System.out.println("max number: " + res2);

        // Q3

        // level 1
        Node root = new Node(300);

        // level 2
        Node l = new Node(125);
        Node r = new Node(400);
        
        // level 3
        Node ll = new Node(100);
        Node lr = new Node(200);
        Node rr = new Node(450);

        // level 4
        Node lll = new Node(50);
        Node lrl = new Node(150);
        Node lrr = new Node(250);

        // level 5
        Node lrlr = new Node(170);

        root.setLeftSon(l);
        root.setRightSon(r);

        l.setLeftSon(ll);
        l.setRightSon(lr);

        ll.setLeftSon(lll);

        lr.setLeftSon(lrl);
        lr.setRightSon(lrr);

        lrl.setRightSon(lrlr);

        r.setRightSon(rr);


        Question3.what(root, 150);

    }
}
