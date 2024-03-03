package T2017.A90;

public class Question3 {
    public static void what(Node node, int num) {
        if (node != null) {
            // if node value > num
            if (node.getNumber() > num) {
                // what left son
                what(node.getLeftSon(), num);
                // print value
                System.out.println(node.getNumber());
                // what right son
                what(node.getRightSon(), num);
            }
            // else
            if (node.getNumber() <= num)
                // what right son
                what(node.getRightSon(), num);
        }
    }

    // the method performs an in-order (L-M-R) search for
    // the roots bigger than num , 
    // it ends up printing all the tree values bigger than num

}
