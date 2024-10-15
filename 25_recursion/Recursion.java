
public class Recursion {

	public static void main(String[] args) {
//		f1();
//		f2();
		// =================================
		f1(4);
		System.out.println(factorial(5));
		System.out.println(factorialRecursive(5));

		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println(binarySearch(array, 2));
		System.out.println(binarySearchRecursive(array, 2));
		System.out.println(binarySearch(array, 12));
		System.out.println(binarySearchRecursive(array, 12));

		System.out.println(pow(2, 3));

		System.out.println(fibonacci(4));
		System.out.println(fibonacciRecursive(4));

		printArray(array);

	}

	public static void printArray(int[] ar) {
		printArrayRec(ar, 0);
		System.out.println();
	}

	private static void printArrayRec(int[] ar, int i) {
//		if(i == ar.length)
//			return;
		if (i < ar.length) {
			System.out.print(ar[i] + " ");
			printArrayRec(ar, i + 1);
		}
	}

	public static long fibonacciRecursive(int n) {
		if (n <= 1)
			return n;

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public static long fibonacci(int n) {// 3
		if (n <= 1)
			return n;
		long n1 = 0;
		long n2 = 1;
		long res = n1 + n2;// 1
		while (n > 2) {
			n1 = n2;// 1-1
			n2 = res;// 1-2
			res = n1 + n2;// 2-3
			n--;
		}
		return res;
	}

	public static double pow(double number, int power) {
//		if(power == 0)
//			return 1;
//		return number * pow(number, power - 1);
		return power == 0 ? 1 : number * pow(number, power - 1);
	}

	public static int binarySearchRecursive(int[] ar, int num) {
		return binarySearchRecursive(ar, 0, ar.length - 1, num);
	}

	private static int binarySearchRecursive(int[] ar, int l, int r, int num) {
		if (l > r)
			return -1;
		int middle = (l + r) / 2;
		if (ar[middle] == num)
			return middle;
		if (num > ar[middle])
			l = middle + 1;
		else
			r = middle - 1;
		return binarySearchRecursive(ar, l, r, num);
	}

	public static int binarySearch(int[] ar, int num) {
		int left = 0;
		int right = ar.length - 1;
		int middle;
		while (left <= right) {
			middle = (left + right) / 2;
			if (ar[middle] == num)
				return middle;
			if (num > ar[middle])
				left = middle + 1;
			else
				right = middle - 1;
		}
		return -1;
	}

	public static int factorial(int n) {// 5! = 5 * 4 * 3 * 2 * 1 = 120
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	// fr(5)->fr(4) -> fr(3) -> fr(2) -> fr(1)->fr(0) = 1*1*2*3*4*5 = 120
	public static int factorialRecursive(int n) {
//		if(n == 0) return 1;
//		return n * factorialRecursive(n - 1);
		return n == 0 ? 1 : n * factorialRecursive(n - 1);
	}

	// f1(4)-> f1(3)->f1(2)->f1(1)->f1(0)->f1(-1)!
	public static void f1(int num) {
		if (num < 0)
			return;
		System.out.println(num);
		f1(num - 1);
	}

	public static void f2() {
		f3();
	}

	public static void f3() {
		f2();
	}

}
