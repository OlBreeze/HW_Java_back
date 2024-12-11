package compareArrayInt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class OddEvenComparatorTest {

	@Test
	void test() {

		Integer[] origin 	= {1,2,3,4,5,6,7,8,9,3};
		Integer[] expected 	= {2,4,6,8,9,7,5,3,3,1};
		
		Arrays.sort(origin, new OddEvenComparator());
		System.out.println(Arrays.toString(origin));
		
		assertArrayEquals(expected, origin);
	}

}
