package T2017.A84;

public class Node {
    private int _number;
    private Node _leftSon, _rightSon;

    public Node(int num) {
        _number = num;
        _leftSon = null;
        _rightSon = null;
    }

    public int getNumber() {
        return _number;
    }

    public Node getLeftSon() {
        return _leftSon;
    }

    public Node getRightSon() {
        return _rightSon;
    }

    public void setNumber(int number) {
        _number = number;
    }

    public void setLeftSon(Node node) {
        _leftSon = node;
    }

    public void setRightSon(Node node) {
        _rightSon = node;
    }

    // returns true if tree includes num as value of one of the leaves
    public static boolean what(Node root, int num) {
        if (root == null) {
            return false;
        }

        if (root.getNumber() == num) {
            return true;
        }

        return what(root.getLeftSon(), num) || what(root.getRightSon(), num);
    }


    // if t2 is smaller than t1 or t1 dosnt contain any value from t2
    public static boolean secret(Node t1, Node t2) {
        // if we searched all t1
        if (t1 == null) {
            // and we also at the end of t2
            // t1 and t2 same height
            if (t2 == null)
                return true;
            else
                return false;
        }

        // if we searched all t2 before we finished t1
        // t2 is smaller than t1
        if (t2 == null)
            return true;

        // if t1 contains the value of the root of t2
        if (what(t1, t2.getNumber()) == false)
            return false;

        // perform for each left sub tree and right sub tree
        return secret(t1, t2.getLeftSon()) && secret(t1, t2.getRightSon());

    }

    public static void printTree(Node root) {
        printSubtree(root, "", true);
    }

    // Recursive method to print the tree
    private static void printSubtree(Node node, String prefix, boolean isTail) {
        if (node.getRightSon() != null) {
            printSubtree(node.getRightSon(), prefix + (isTail ? "    " : "|   "), false);
        }
        System.out.println(prefix + (isTail ? "└── " : "|── ") + node.getNumber());
        if (node.getLeftSon() != null) {
            printSubtree(node.getLeftSon(), prefix + (isTail ? "    " : "|   "), true);
        }
    }
}
