import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyDynamicArrayTest {
	MyDynamicArray<Integer> myArray = new MyDynamicArray<>();
	
	@BeforeEach
	void setUp() throws Exception {
		myArray.add(1);
		myArray.add(2);
		myArray.add(3);
		myArray.add(null);
		myArray.add(3);
		myArray.add(4);
		myArray.add(5);
		//myArray.add("hcj");
	}
	
	@Test
	void testAdd() {
		System.out.printf("-=> Array for test:\n%1s\n\n", Arrays.toString(myArray.toArray()));
		
		myArray.add(36, 3);
		myArray.add(37, 3);
		myArray.add(38, 3);
		myArray.add(39, 3);
		myArray.add(40, 3);
		myArray.add(41, 3);
		
		Object[] exp = {1, 2, 3, 41, 40, 39, 38, 37, 36, null, 3, 4, 5, null, null, null};
		assertArrayEquals(exp, myArray.toArray());
		
		System.out.printf("---1. add:\n%1s\n",Arrays.toString(myArray.toArray()));
		
		assertFalse(myArray.add(100, 100)); 
		assertFalse(myArray.add(100, -5)); 
		
	}
	
	@Test
	void testLastIndexOf() {
		assertEquals(6, myArray.lastIndexOf(5));
		assertEquals(-1, myArray.lastIndexOf(400));
		assertEquals(3, myArray.lastIndexOf(null));
	}
	
	
	@Test
	void testContains() {
		assertTrue(myArray.contains(5));
		assertTrue(myArray.contains(null));
		
		assertFalse(myArray.contains(500));
		//System.out.printf("---3. contains:\n%1s\n", Arrays.toString(myArray.getArray()));
	}
	
	@Test
	void testSet() {
		assertTrue(myArray.set(50, 0));
		assertFalse(myArray.set(50, -5));
		assertFalse(myArray.set(50, 500));
		
		Object[] exp = {50, 2, 3, null, 3, 4, 5, null, null, null, null, null, null, null, null, null};
		assertArrayEquals(exp, myArray.toArray());
		
		System.out.printf("---4. set:\n%1s\n", Arrays.toString(myArray.toArray()));
	}
	
	@Test
	void testAddAll() {
		
		MyDynamicArray<Integer> myArray1 = new MyDynamicArray<>();
		
		myArray1.add(7);
		myArray1.add(7);
		myArray1.add(7);
		myArray1.add(7);
		myArray1.add(7);
		
		myArray.addAll(myArray1);
		
		Object[] exp = {1, 2, 3, null, 3, 4, 5, 7, 7, 7, 7, 7, null, null, null, null};
		assertArrayEquals(exp, myArray.toArray());
		
		
		myArray.addAll(null); // без изменений
		assertArrayEquals(exp, myArray.toArray());
		
		System.out.printf("---5. addAll:\n%1s\n", Arrays.toString(myArray.toArray()));
	}
	
	@Test
	void testRemoveAll() {
		
		Object[] exp = {1, 2, null, 4, 5, null, null, null, null, null, null, null, null, null, null, null};
		myArray.removeAll(3);
		assertArrayEquals(exp, myArray.toArray()); 
		
		Object[] exp1 = {1, 2, 4, 5, null, null, null, null, null, null, null, null, null, null, null, null};
		myArray.removeAll(null);
		assertArrayEquals(exp1, myArray.toArray()); 
		
		System.out.printf("---6. removeAll(: del 3, null):\n%1s\n", Arrays.toString(myArray.toArray()));
	}
	
	@Test
	void testRemoveAll_Class() {
		Integer[] ArrayInt = {2,4};
		Object[] exp = {1, 3, null, 3, 5, null, null, null, null, null, null, null, null, null, null, null};
		
		myArray.removeAll_Class(ArrayInt);
		
		assertArrayEquals(exp, myArray.toArray());
		
		System.out.printf("---7. RemoveAll_Class():\n%1s\n", Arrays.toString(myArray.toArray()));
		
	}
	
	@Test
	void testAddAll_13hw() {
		MyDynamicArray<Integer> myArray1 = new MyDynamicArray<>();

		myArray1.add(7);
		myArray1.add(7);
		myArray1.add(7);
		myArray1.add(7);
		myArray1.add(7);

		myArray.addAll(myArray1,3);

		Object[] exp = { 1, 2, 3, 7, 7, 7, 7, 7, null, 3, 4, 5, null, null, null, null};
		assertArrayEquals(exp, myArray.toArray());
		
		Object[] exp1 = { 1, 2, 3, 7, 7, 7, 7, 7, null, 3, 4, 5, 7, 7, 7, 7, 7};
		myArray.addAll(myArray1,12); // capacity = +1 = 17

		myArray.addAll(null, 5); // без изменений
		assertArrayEquals(exp1, myArray.toArray());

		System.out.printf("---8. addAll(obj, ind ):\n%1s\n", Arrays.toString(myArray.toArray()));
	}
	
	@Test
	void testRetainAll_13hw() {
		MyDynamicArray<Integer> myArray1 = new MyDynamicArray<>();

		myArray1.add(1);
		myArray1.add(2);
		myArray1.add(3);
		
		myArray.retainAll(myArray1);
		
		Object[] exp = { 1, 2, 3, 3, null, null, null, null, null, null, null, null, null, null, null, null};
		
		assertArrayEquals(exp, myArray.toArray());
		assertFalse(myArray.retainAll(null));
		
		System.out.printf("---9. RetainAll:\n%1s\n", Arrays.toString(myArray.toArray()));
		
	}
}
