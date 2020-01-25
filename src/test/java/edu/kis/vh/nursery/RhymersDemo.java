package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    private static final int HANOI_INDEX = 3;
    private static final int DATA_COUNT = 15;
    private static final int RHYMERS_COUNT = 3;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();

        DefaultCountingOutRhymer[] rhymers = {factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

        for (int i = 1; i < DATA_COUNT; i++)
            for (int j = 0; j < RHYMERS_COUNT; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < DATA_COUNT; i++)
            rhymers[HANOI_INDEX].countIn(rn.nextInt(20));
		//ctrl + alt + (left or right arrow) are used to navigate to the previous place (cursor) in project files (in Intellij)
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[HANOI_INDEX]).reportRejected());

    }

}