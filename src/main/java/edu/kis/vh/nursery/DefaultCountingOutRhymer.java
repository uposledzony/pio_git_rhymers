package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int maxSize = 12;
    private static final int startSize = -1;
    private int[] numbers = new int[maxSize];

    private int total = startSize;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == startSize;
    }

    public boolean isFull() {
        return total == maxSize - 1;
    }

    protected int peekaboo() {
        if (callCheck())
            return -1;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return -1;
        return numbers[total--];
    }

}
