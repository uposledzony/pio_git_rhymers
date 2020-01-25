package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    private static final int HANOI_INDEX = 3;
    private static final int DATA_COUNT = 15;
    private static final int RHYMERS_COUNT = 3;
    private static final int BOUND = 20;


    public static void main(String[] args) {
        DefaultCountingOutRhymer[] rhymers = getDefaultCountingOutRhymers(new DefaultRhymersFactory());

        countRhymers(rhymers);

        countRhymerRandom(rhymers[HANOI_INDEX]);
        //ctrl + alt + (left or right arrow) are used to navigate to the previous place (cursor) in project files (in Intellij)
        printResults(rhymers);

        printRejectedReport(rhymers[HANOI_INDEX]);

    }

    private static void countRhymerRandom(DefaultCountingOutRhymer rhymer) {
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < DATA_COUNT; i++)
            rhymer.countIn(rn.nextInt(BOUND));
    }

    private static void countRhymers(DefaultCountingOutRhymer[] rhymers) {
        for (int i = 1; i < DATA_COUNT; i++)
            for (int j = 0; j < RHYMERS_COUNT; j++)
                rhymers[j].countIn(i);
    }

    private static void printRejectedReport(DefaultCountingOutRhymer rhymer) {
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymer).reportRejected());
    }

    private static void printResults(DefaultCountingOutRhymer[] rhymers) {
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
    }

    private static DefaultCountingOutRhymer[] getDefaultCountingOutRhymers(RhymersFactory factory) {
        return new DefaultCountingOutRhymer[]{factory.getStandardRhymer(), factory.getFalseRhymer(),
                    factory.getFIFORhymer(), factory.getHanoiRhymer()};
    }

}