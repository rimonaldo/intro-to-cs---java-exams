package T2017.A84;

public class IntNode {
    private int _value;
    private IntNode _next;

    public IntNode(int value, IntNode node) {
        _value = value;
        _next = node;
    }

    public IntNode getNext() {
        return _next;
    }

    public int getValue() {
        return _value;
    }

    public void setNext(IntNode node) {
        _next = node;
    }

    public void setValue(int value) {
        _value = value;
    }

}
