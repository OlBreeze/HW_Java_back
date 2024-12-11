package compareArrayInt;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1.equals(o2))
			return 0;

		boolean evenO1 = (o1 % 2 == 0);// + +; - -; + -; - +
		boolean evenO2 = (o2 % 2 == 0);

		if (evenO1 && evenO2)
			return Integer.compare(o1, o2); // o1 - o2;
		else if (!evenO1 && !evenO2)
			return Integer.compare(o2, o1); //o2 - o1;
		else if (evenO1)
			return -1;
		else
			return 1;
	}
}
