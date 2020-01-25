package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    private static final int COUNTS = 888;
    private static final int TEST_VALUE = 4;
    private static final int STACK_CAPACITY = 12;
    private static final int EMPTY_STACK_VALUE = -1;

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        rhymer.countIn(TEST_VALUE);
        Assert.assertEquals(TEST_VALUE,  rhymer.peekaboo());
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        Assert.assertTrue(rhymer.callCheck());

        rhymer.countIn(COUNTS);

        Assert.assertFalse(rhymer.callCheck());
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        checkStackCalls(rhymer);

        Assert.assertTrue(rhymer.isFull());
    }

    private void checkStackCalls(DefaultCountingOutRhymer rhymer) {
        for (int i = 0; i < STACK_CAPACITY; ++i) {
            Assert.assertFalse(rhymer.isFull());
            rhymer.countIn(COUNTS);
        }
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());

        rhymer.countIn(TEST_VALUE);

        Assert.assertEquals(TEST_VALUE, rhymer.peekaboo());
        Assert.assertEquals(TEST_VALUE, rhymer.peekaboo());
    }

    @Test
    public void testDefaultCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());

        rhymer.countIn(TEST_VALUE);

        Assert.assertEquals(TEST_VALUE, rhymer.countOut());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
    }

    @Test
    public void testHanoiCountOut(){
        DefaultRhymersFactory factory = new DefaultRhymersFactory();
        HanoiRhymer hanoiRhymer = (HanoiRhymer) factory.getHanoiRhymer();
        Assert.assertEquals(EMPTY_STACK_VALUE, hanoiRhymer.countOut());

        hanoiRhymer.countIn(TEST_VALUE);

        Assert.assertEquals(TEST_VALUE, hanoiRhymer.countOut());
        Assert.assertEquals(EMPTY_STACK_VALUE, hanoiRhymer.countOut());
    }

    @Test
    public void testFIFOCountOut(){
        DefaultRhymersFactory factory = new DefaultRhymersFactory();
        FIFORhymer hanoiRhymer = (FIFORhymer) factory.getFIFORhymer();
        Assert.assertEquals(EMPTY_STACK_VALUE, hanoiRhymer.countOut());

        hanoiRhymer.countIn(TEST_VALUE);

        Assert.assertEquals(TEST_VALUE, hanoiRhymer.countOut());
        Assert.assertEquals(EMPTY_STACK_VALUE, hanoiRhymer.countOut());
    }

    @Test
    public void testIntLinkedListEmpty(){
        IntLinkedList linkedList = new IntLinkedList();
        Assert.assertTrue(linkedList.isEmpty());
        Assert.assertEquals(EMPTY_STACK_VALUE, linkedList.top());
    }

    @Test
    public void testIntLinkedListPushTopPop(){
        IntLinkedList linkedList = new IntLinkedList();
        final int FIRST = 23;
        final int SECOND = 22;
        linkedList.push(FIRST);
        linkedList.push(SECOND);
        Assert.assertFalse(linkedList.isEmpty());
        Assert.assertEquals(SECOND,linkedList.top());
        Assert.assertEquals(SECOND,linkedList.pop());
        Assert.assertNotEquals(SECOND,linkedList.top());
        Assert.assertEquals(FIRST,linkedList.pop());
        Assert.assertTrue(linkedList.isEmpty());
    }
}
