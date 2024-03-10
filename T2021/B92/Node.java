package T2021.B92;

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

    public static void printPostOrder(Node root) {
        if (root != null) {
            printPostOrder(root.getLeftSon());
            printPostOrder(root.getRightSon());
            System.out.print(root.getNumber() + " ");
        }
    }

    public static int find(Node root, int num) {
        if (root == null) {
            return -1;
        }

        if (root.getNumber() == num) {
            return num;
        } else if (root.getNumber() < num) {
            int k = find(root.getRightSon(), num);
            if (k == -1)
                return root.getNumber();
            else {
                return k;
            }
        } else if (root.getNumber() > num) {
            return find(root.getLeftSon(), num);

        }
        return -1;

    }

    public static void main(String[] args) {
        // Node root = new Node(40);

        // Node l = new Node(50);
        // Node r = new Node(70);

        // Node ll = new Node(60);
        // Node lr = new Node(55);
        // Node rl = new Node(75);
        // Node rr = new Node(85);

        // Node lll = new Node(30);
        // Node llr = new Node(20);

        // root.setLeftSon(l);
        // root.setRightSon(r);

        // l.setLeftSon(ll);
        // l.setRightSon(lr);
        // r.setLeftSon(rl);
        // r.setRightSon(rr);

        // ll.setLeftSon(lll);
        // ll.setRightSon(llr);

        // root.printPostOrder(root);

        Node root = new Node(60);

        Node l = new Node(40);
        Node r = new Node(70);

        Node ll = new Node(30);
        Node lr = new Node(50);
        Node lrl = new Node(47);
        Node lrr = new Node(55);
        Node lrll = new Node(43);

        Node lll = new Node(20);

        root.setLeftSon(l);
        root.setRightSon(r);

        l.setLeftSon(ll);
        l.setRightSon(lr);
        lr.setLeftSon(lrl);
        lr.setRightSon(lrr);
        lrl.setLeftSon(lrll);

        ll.setLeftSon(lll);

        int res = root.find(root, 15);

        System.out.println(res);

    }
}