package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

    //TODO It isn't necessary method - we currently subclassing DefaultCountingOutRhymer and we have access from FIFORhymer to public and protected properties and methods of DefaultCountingOutRhymer.
    public DefaultCountingOutRhymer getTemp() {
        return temp;
    }

    private DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
