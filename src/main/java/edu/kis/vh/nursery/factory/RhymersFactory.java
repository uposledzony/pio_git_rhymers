package edu.kis.vh.nursery.factory;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;

	//TODO I'm convinced that instead of interface we should create abstract class that should be factory and contain one static method that returns specfied object of DefaultCountingOutRhymer.
	public interface RhymersFactory {
	
		DefaultCountingOutRhymer getStandardRhymer();
		
		DefaultCountingOutRhymer getFalseRhymer();
		
		DefaultCountingOutRhymer getFIFORhymer();
		
		DefaultCountingOutRhymer getHanoiRhymer();
		
	}
