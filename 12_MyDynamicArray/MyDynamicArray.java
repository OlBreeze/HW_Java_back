import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MyDynamicArray<T> {
	private static final int CAPACITY = 16;
	private static final int MAX_CAPACITY = Integer.MAX_VALUE - 10;

	private Object[] array;
	private int size; // сколько там элементов

	public MyDynamicArray(int capacity) {
		if (capacity > MAX_CAPACITY)
			capacity = MAX_CAPACITY;
		else if (capacity <= 0)
			capacity = CAPACITY;

		array = new Object[capacity];
		size = 0;
	}

	public MyDynamicArray() {
		this(CAPACITY);
	}

	public boolean add(T obj) {
		if (size == array.length)
			allocateArray();

		array[size++] = obj;

		return true;
	}

	private void allocateArray() {
		int newCapacity = array.length * 2;
		if (newCapacity > MAX_CAPACITY || newCapacity < 0)
			newCapacity = MAX_CAPACITY;

		array = Arrays.copyOf(array, newCapacity);
	}

	private void allocateArray(int count) {
		int newCapacity = array.length + count;
		if (newCapacity > MAX_CAPACITY || newCapacity < 0)
			newCapacity = MAX_CAPACITY;

		array = Arrays.copyOf(array, newCapacity);
	}
	
	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index >= size)
			return null;

		T element = (T)array[index];
		return element;
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			return null;

		T res = (T)array[index];
		if (index < size - 1)
			System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;
		array[size] = null;

		return res;
	}

//	  // Метод для получения массива типа T[]
//	public T[] toArray() {
//        T[] result = (T[]) Array.newInstance(clazz, size);
//        System.arraycopy(array, 0, result, 0, size);
//        return result;
//    }
	// ----- HOMEWORK ------
	/**
	 * The method adds object at the specified index and returns true. Items starting from the passed index must shift to the right. If invalid index is passed (less than zero, or greater than size), the method returns false.
	 */
	public boolean add(T obj, int index) {
		if (index < 0 || index > size)
			return false;

		if (size == array.length)
			allocateArray();

		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;

		size++;

		return true;
	}

	/**
	 * The method returns the index of the last object that matches the passed to the method. 
	 * If such object is not found, the method returns -1
	 */
	public int lastIndexOf(T obj) {
		if (obj == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (array[i] == null)
					return i;
			}
		} else
			for (int i = size - 1; i >= 0; i--)
				if (obj.equals(array[i]))
					return i;

		return -1;
	}

	/**
	 * The method must return true if such an object is contained in the array, and false if it is not.
	 */
	public boolean contains(T obj) {
		return (lastIndexOf(obj) >= 0);
	}

	
	/**
	 * The method must replace the value at the passed index with obj and return true. 
	 * If the index is not correct, the method should return false
	 */
	public boolean set(T obj, int index) {
		if (index < 0 || index >= size)
			return false;

		array[index] = obj;

		return true;
	}

	
	/**
	 * The method should add to your DynamicArray all the elements from the passed
	 * DynamicArray to the end.
	 */
	public void addAll(MyDynamicArray<T> other) {

		if (other == null)
			return;
		
		T[] arrayOther = other.toArray();

		if (arrayOther.length == 0)
			return;

		while (size + other.size > array.length)
			allocateArray();

		System.arraycopy(arrayOther, 0, array, size, other.size);
		size += other.size;
	}

	/**
	 * The method removes all elements from the array passed to the method and
	 * returns true if at least one element was removed and false if none of the
	 * elements were removed.
	 */
	public boolean removeAll(T obj) {
		boolean res = false;

		for (int i = size - 1; i >= 0; i--) {
			if (Objects.equals(array[i], obj)) {
				remove(i);
				res = true;
			}
		}

		return res;
	}
	
	public boolean removeAll_Class(T[] obj) {
		if (obj == null)
			return false;
		
		int oldSize = size;
		int ind;
		for (T el : obj) {
			while ((ind = lastIndexOf(el)) != -1) {
				remove(ind);
			}
		}

		return oldSize != size;
	}
	
	/// Homework 13
	public void addAll(MyDynamicArray<T> other, int index) {
        if (other == null || index < 0 || index > size)
            return;

        T[] otherArray = other.toArray();
        int newSize = size + other.size;
        
        while (newSize > array.length)
            allocateArray(newSize - array.length);
        
        if (index < size) {//сдвинем на размер нового массива
            System.arraycopy(array, index, array, index + other.size, size - index);
        }

        System.arraycopy(otherArray, 0, array, index, other.size); //вставим новый массив

        size = newSize;
    }
	
    public boolean retainAll(MyDynamicArray<T> other) {
    	if (other == null)
			return false;
		
		int oldSize = size;
		
		 for (int i = size - 1; i >= 0; i--) {
				T element = (T) array[i];
				if (!other.contains(element)) {
					remove(i);
				}
			}
         
		return oldSize != size;
    }
    
    public T[] toArray() {
		 T[] copy = (T[]) Arrays.copyOf(array, array.length);
	     return copy;
	}
}
