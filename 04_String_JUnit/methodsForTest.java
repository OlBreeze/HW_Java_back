package hw_class;

public class methodsForTest {
	
	
	public static void main(String[] args) {
		
		System.out.println(" ------- 1. Palindrome ---------");
		System.out.println(isPalindrome("aba"));  	//  true
		System.out.println(isPalindrome("abcd")); 	//  false
		System.out.println(isPalindrome("aa aa")); 	//  true
		System.out.println(isPalindrome("Abba")); 	//  true
		System.out.println(isPalindrome("  Ab b a  ")); //  true
		System.out.println(isPalindrome("	а роза упала на лапу азора ")); //  true

		System.out.println(" ------- 2. isReverse ---------");
		System.out.println(isReverse("aba", "aba")); //  true
		System.out.println(isReverse("abcd", "asdf"));
		System.out.println(isReverse(" qwerty ", "ytrewq")); //  true

		System.out.println(" ------- 3. printSubStringReverse ---------");
		printSubStringReverse("qWerTy", 1, 4); // TreW
		printSubStringReverse("qweRty", 3, 3); //R

		System.out.println(" ------- 4. printStringInColumn ---------");
		printStringInColumn("sunrise");

		System.out.println(" ------- 5. validPassword ---------");
		
		
		System.out.println("<	dhfs>");
		validPassword("	dhfs");
		
		System.out.println("<	dhfshbwww>");
		validPassword("	dhfshbwww");
		
		System.out.println("<	dhfWhbwww>");
		validPassword("	dhfWhbwww");
		
		System.out.println("< dhfs1hbwww>");
		validPassword("	dhfs1hbwww");
		
		System.out.println("<	dhf~shbwww>");
		validPassword("	dhf~shbwww");
		
		System.out.println("<	D1hf~shbwww>");
		validPassword("	D1hf~shbwww");

		System.out.println(" ------- 6. maxCharIndex ---------");
		System.out.println(maxCharIndex("ddqqqfff       ff"));
		System.out.println(maxCharIndex("d       ff"));
		System.out.println(maxCharIndex("ddd~~~~~"));
		System.out.println(maxCharIndex("     "));
		System.out.println(maxCharIndex(null));
		System.out.println(maxCharIndex(""));
	}
	
	

	/**
	 * The method should return true if string is palindrome and false if is not.
	 * The method must be case insensitive and excluding whitespace characters.
	 * 
	 * @param str
	 * @return true/false
	 */
	public static boolean isPalindrome(String str) {

		if (str == null || str.isBlank()) 
			return false;

		String strStart = str.strip().replace(" ", "").replace("\t", "").toLowerCase();

		int indLeft = 0;
		int indRight = strStart.length() - 1;

		while (indLeft < indRight) {
			if (strStart.charAt(indLeft) != strStart.charAt(indRight)) 
				return false;
			
			indLeft++;
			indRight--;
		}

		return true;
	}

	/**
	 * The method takes 2 strings and returns true if the second string is the
	 * reverse of the first
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isReverse(String str1, String str2) {
		
		if (str1 == null || str2 == null|| str1.isBlank() || str2.isBlank()) 
			return false;
		
		str1 = str1.strip();
		str2 = str2.strip();
		
		if (str1.length() != str2.length()) 
			return false;
		
		int length = str1.length();

		for (int i = 0; i < length; i++) {
			if (str1.charAt(i) != str2.charAt(length - 1 - i)) 
				return false;
		}
		return true;
	}

	/**
	 * 
	 * The method should print a substring of the passed string in reverse
	 */
	public static void printSubStringReverse(String str, int start, int end) {
		
		if (str == null || str.isBlank() || end >= str.length() || start < 0 || start > end) {
			System.out.println("Initial data is wrong!");
			return;
		}
		
		String subReverse = "";

		for (int i = end; i >= start; i--) 
			subReverse += str.charAt(i);
		
		System.out.println(subReverse);
	}

	/**
	 * The method should output the string to the console character by character in
	 * a column. one character per line
	 * 
	 * @param str
	 */
	public static void printStringInColumn(String str) {
		if (str == null || str.isBlank()) {
			System.out.println("Initial data is wrong!");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

	/**
	 * The method should display if password valid or display reason invalid
	 * 
	 * password is valid if: 1. Length 8 or more symbols 2. Contains one or more
	 * uppercase letter 3. Contains one or more lowercase letter 4. Contains one or
	 * more digit 5. Contains one or more special symbols from set ("~","!","-","_")
	 * 
	 * Example valid password: Aa12345~
	 * 
	 * @param password
	 */
	public static void validPassword(String password) {

		password = password.strip();

		if (password == null || password.isBlank() || password.length() < 8) {
			System.out.println("The password must be at least 8 characters long.");
			return;
		}

		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasDigit = false;
		boolean hasSpec = false;

		// String arraySpecSymbols[] = {"~","!","-","_"};

		String specSymbols = "~!,-_";

		for (char ch : password.toCharArray()) {
			if (Character.isUpperCase(ch))
				hasUpperCase = true;
			else if (Character.isLowerCase(ch))
				hasLowerCase = true;

			if (Character.isDigit(ch))
				hasDigit = true;

			if (specSymbols.indexOf(ch) >= 0)
				hasSpec = true;

			if (hasUpperCase && hasLowerCase && hasDigit && hasSpec) {
				System.out.println("Valid password: ".concat(password));
				break;
			}
		}

		if (!hasUpperCase)
			System.out.println("The password must contain at least one uppercase letter.");
		if (!hasLowerCase)
			System.out.println("The password must contain at least one lowercase letter.");
		if (!hasDigit)
			System.out.println("The password must contain at least one digit.");
		if (!hasSpec)
			System.out.println("The password must contain at least one special symbols.");

	}
	
	/**
	 * the method returns the index of the character that occurs most often in the string. If there are several characters that occur the same number of times, then any of them
	 * @param str
	 * @return
	 */
	public static int maxCharIndex(String str) {
		
		if (str == null || str.isEmpty()) 
			return -1;
		
		String s = str;//.strip();// оставлю пробелы
		
		char[] uniqueCharsArr = new char[s.length()]; // массив в котором храним уникальные символы строки
		int[]  countArr  	  = new int[s.length()];  // массив - частота символа в строке
		int maxindArr[] = {0,0}; // перый элемент - индекс, второй - количество, чтоб сразу следить за максимальным количеством
		int ind = 0;
		
		while (s.length() > 0) {
			char ch = s.charAt(0);
			uniqueCharsArr[ind] = ch;

			int lengthStr = s.length();
			s = s.replace("" + ch, ""); //удалили повторяющиеся символы
			
			countArr[ind] = lengthStr - s.length(); // получили разницу в длине строк - частота символа в строке

			if (countArr[ind] > maxindArr[1]) { // переопределяем максимальный элемент в массиве максимумов
				maxindArr[0] = ind;
				maxindArr[1] = countArr[ind];
			}

			ind++;
		}
		
		// наш результат - это символ из массива uniqueCharsArr с индексом maxindArr[0] - найдем его индекс в исходной строке
		return str.indexOf(uniqueCharsArr[maxindArr[0]]);
	}

}
