package T2017.A86;

public class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }

    public int length() {
        int count = 0;
        IntNode current = _head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void setHead(IntNode node) {
        _head = node;
    }

    // the method overall is running through the list
    // adds the current node value to m2
    // if the sum is negative , its initializing it to 0 again
    // but if the sum is a positive integer,
    // we will check if m1 is smaller, if so, we will set m1 to m2

    // note that if all of the list is positive,
    // the method is returning the sum all of the values
    public int method1() {
        // m1 and m2 initialzed at 0
        int m1 = 0, m2 = 0;
        // looping the node list
        for (IntNode p = _head; p != null; p = p.getNext()) {
            // add node value to m2
            m2 = m2 + p.getData();

            // if m2 negative
            if (m2 < 0) {
                // initialize m2 to 0
                m2 = 0;
            }

            // if m1 smaller than m2
            if (m1 < m2) {
                // set m1 to m2 value
                m1 = m2;
            }
        }
        return m1;
    }

}
