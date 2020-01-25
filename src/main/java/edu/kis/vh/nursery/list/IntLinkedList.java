package edu.kis.vh.nursery.list;

public class IntLinkedList {

    private static final int ERROR = -1;

    public Node getLast() {
        return last;
    }


    private Node last;

    //TODO Is limitation necessary for this class? Better solution could be create IntLimitedLinkedList that inherits behaviour of IntLinkedList and moreover adds limitation of size.
    private int i;

    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.setNext(new Node(i));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    //TODO it is needed to specify implementation of this method to indicate if list is full or not (or remove if field 'i' for size limitation is not necessary in this class).
    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty())
            return ERROR;
        return last.getValue();
    }

    public int pop() {
        if (isEmpty())
            return ERROR;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }

    //TODO specify if this method is necessary in this class.
    public int getI() {
        return i;
    }

}
class Node {

    private int value;
    private Node prev;
    private Node next;

    public Node(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}