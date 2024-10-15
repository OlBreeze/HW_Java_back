package homework;

import java.util.Arrays;

public class RecursionApp {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };

		reverseArray(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println("------------- arraySum ---------------");
		System.out.println(arraySum(array));
		
		System.out.println("--------------- pow -------------------");
		System.out.println(pow(10, 0));
		System.out.println(pow(10, 4));
		System.out.println(pow(10, -4));
		
		System.out.println("--------------------- isSubstring -------------");
		System.out.println(isSubstring("papapda", "pap"));
		System.out.println(isSubstringRecursive("papapda", "papdw"));
		System.out.println(isSubstringRecursive2("papapda", "papdw"));
		
		System.out.println("---------------- print100Numbers ------------------");
		print100Numbers(92);
	}

	// ------ reverseArray ----------
	public static void reverseArray(int[] arr) {
		
		if (arr != null && arr.length > 0) {
			reverseArrayRecursive(arr, 0, arr.length - 1);
		}

	}

	public static void reverseArrayRecursive(int[] arr, int left, int right) {
		if (left != right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			reverseArrayRecursive(arr, left + 1, right - 1);
		} else
			System.out.println();
	}

	
	// -------- arraySum ----------------

	public static int arraySum(int[] array) {
		return array != null && array.length > 0 ? countSum(array, 0) : 0;
	}

	private static int countSum(int[] array, int i) {
		return i < array.length ? array[i] + countSum(array, ++i) : 0;
	}

	// --------------- pow ----
	public static double pow(double number, int power) {
		return power == 0 ? 1 
				: power > 0 ? number * pow(number, power - 1) 
						: 1 / (number * pow(number, - power - 1));
	}

	// ----------- isSubstring -----
	public static boolean isSubstring(String string, String substr) {
		if (string == null || substr == null || string.length() < substr.length()||substr.length() == 0)
			return false;
		
		for (int i = 0; i < string.length(); i++) {
			if (string.substring(i, Math.min(i + substr.length(), string.length())).equals(substr)) 
					return true;
		}
		
		return false;
	}
	
	public static boolean isSubstringRecursive(String string, String substr) {
		if (string == null || substr == null || string.length() < substr.length()||substr.length() == 0)
			return false;
		 
//		if (string.substring(0, Math.min(substr.length(), string.length())).equals(substr))
//			return true;
//		else
//			return isSubstringRecursive(string.substring(1), substr);
		
		return string.substring(0, Math.min(substr.length(), string.length())).equals(substr)? true: isSubstringRecursive(string.substring(1), substr);
	}
	
	public static boolean isSubstringRecursive2(String string, String substr) {
	    if (string == null || substr == null || string.length() < substr.length() || substr.length() == 0) 
	        return false;
	    
	    return string.startsWith(substr) || isSubstringRecursive2(string.substring(1), substr);
	}
	
	//----------------- print100Numbers ------------
	public static void print100Numbers_cycle(int i) {
		for (; i <= 100; i++) {
			System.out.print(i + " ");
		}
	}
	
	public static void print100Numbers_rec1(int i) {
		if (i > 0 && i <= 100) {
			System.out.print(i + " ");
			print100Numbers_rec1(i+1);
		}
		else
			System.out.println();
	}
	
	// without  conditions
	public static void print100Numbers(int i) {
		try {
			int k = 1/(100-i);
			System.out.print(i + " ");
			print100Numbers(i+1);
		} catch (Exception e) {
			System.out.println();
		}
	}
}
