package Comparators;

import java.util.Comparator;

import app.Cat;

public class CompareCatsByAge implements Comparator<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getAge().compareTo(o2.getAge());
	}

}
