package Comparators;

import java.util.Comparator;

import app.Cat;

public class CompareCatsByName implements Comparator<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
