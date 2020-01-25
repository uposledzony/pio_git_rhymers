package edu.kis.vh.nursery;

/**
 * This class specifies the basic Rhymer of project package.
 */
public class DefaultCountingOutRhymer {

    private static final int MAX_SIZE = 12;
    private static final int START_SIZE = -1;
    private static final int ERROR = -1;
    private int[] numbers = new int[MAX_SIZE];

    private int total = START_SIZE;

    /**
     * This method shows current value of {@code total}.
     * @return current index of Rhymer.
     */
    public int getTotal() {
        return total;
    }

    /**
     * This method sets next element if Rhymer is not full otherwise does nothing.
     * @param in the value to set to the next element
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * This method checks if rhymer is in init state.
     * @return {@code true} if Rhymer is initial otherwise {@code false}.
     */
    public boolean callCheck() {
        return total == START_SIZE;
    }

    /**
     * This method indicates if Rhymer is full
     * @return {@code true} if Rhymer is full otherwise {@code false}.
     */
    public boolean isFull() {
        return total == MAX_SIZE - 1;
    }

    /**
     * This method peeks element on current position.
     * @return {@code ERROR} if Rhymer is empty otherwise the value of current element.
     */
    protected int peekaboo() {
        if (callCheck())
            return ERROR;
        return numbers[total];
    }

    /**
     * This method 'removes' the current element of Rhymer and returns its value if Rhymer has some elements otherwise it returns {@code ERROR}
     * @return value of removed element if exist.
     */
    public int countOut() {
        if (callCheck())
            return ERROR;
        return numbers[total--];
    }
}
