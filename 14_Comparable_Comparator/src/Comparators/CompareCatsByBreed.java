package Comparators;

import java.util.Comparator;

import app.Cat;

public class CompareCatsByBreed implements Comparator<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getBreed().compareTo(o2.getBreed());
	}

}
