package T2017.A86;

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


    // this method compares between the left son and right son of a node
    // it returns the left son's value only of its bigger than the right son's value
    // it does that recursivly , meaning overall its summing the biggest overall path
    // but it prioritized the right side over the left side
    public static int what(Node node) {
        // x and y vals are 0
        int x = 0;
        int y = 0;

        // if got left son
        if (node.getLeftSon() != null) {
            // x 
            x = what(node.getLeftSon());
        }
        // if no left son , x still 0

        // if got right son
        if (node.getRightSon() != null) {
            // y
            y = what(node.getRightSon());
        }
        // if no right son, y still 0

        // if x is bigger
        if (x > y) {
            // x? -> node value + x
            return (node.getNumber() + x);
        } else {
            // if x not bigger
            return (node.getNumber() + y);
        }
    }
}
