package T2017.A86;

public class IntNode {
    private int _data;
    private IntNode _next;

    public IntNode(int data, IntNode node) {
        _data = data;
        _next = node;
    }

    public IntNode getNext() {
        return _next;
    }

    public int getData() {
        return _data;
    }

    public void setNext(IntNode node) {
        _next = node;
    }

    public void setValue(int data) {
        _data = data;
    }

}
