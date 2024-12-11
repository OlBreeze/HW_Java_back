package Comparators;

import java.util.Comparator;

import app.Cat;

public class CompareCatsByWeight implements Comparator<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		return Double.compare(o1.getWeight(), o2.getWeight());
	}

}
