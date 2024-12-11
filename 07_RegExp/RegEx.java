
public class RegEx {

	public static boolean isThreeDigitNumber(String str) {
		String regExp = "[1-9]\\d{2}";
		return str.matches(regExp);
	}

	public static boolean isPositiveNumberLessThan300(String str) {
		//0-299 0-9 | 10 - 99 |100 - 299
		String regExp = "[1-9]?\\d|[12]\\d{2}";
		return str.matches(regExp);
	}

	public static boolean isIsraelMobile(String str) {
		//[prefix]5\\d[-?\\d]{7}
		String regExp = "((\\+972-?|\\+\\(972\\)-?|\\(\\+972\\)-?)|\\(?0)5\\d\\)?(-?\\d){7}";
		return str.matches(regExp);		
	}

	public static boolean isNumber(String str) {
		String regExp = "-?(0|[1-9]\\d*)(\\.\\d+)?";
		return str.matches(regExp);
	}

	public static boolean isPositiveLessThan1000(String str) {
		//0 | 1 - 9 | 10 - 99 | 100 - 999
		String regExp = "0|[1-9]\\d{0,2}";
		return str.matches(regExp);
	}

	public static boolean isPositiveLessThanEquals255(String str) {
		//0-255 0-9 10-99 100 - 199 200 - 249  250 -255
		String regExp = "0|[1-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5]";
		return str.matches(regExp);
	}

	public static boolean isEmailCoIlMailRu(String str) {
		String regExp = "[^\\s,@]+@[a-zA-Z\\d-]+\\.(co\\.il|mail\\.ru)";
		return str.matches(regExp);
	}

	public static boolean isArithmeticExpression(String str) {
		String regExp = "\\s*\\d+(\\s*[+*/-]\\s*\\d+)*\\s*";
		return str.matches(regExp);
	}

	public static boolean checkCreditCardNumber(String str) {
		String regex = "\\d{8,16}";
		return str.matches(regex);
	}

	public static boolean checkDateFormatEU(String str) {
		//assertTrue(StringExpressions.checkDateFormatEU("25.01.2020")); 
		// 01-09 12[\\d] 3[01]
		String regex = "(0[1-9]|[12]\\d|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}";
		return str.matches(regex);
	}
	
	public static boolean checkDateFormatUS(String string) {
		return string.matches("\\d{4}-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))");
	}
	
		public static boolean isIPv4(String string) {
		String regex_0_255 = "\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5]";
		String regex = String.format("((%1$s)\\.){3}(%1$s)", regex_0_255);
//		String regex = String.format("((%s)\\.){3}(%s)", regex_0_255, regex_0_255);
//		System.out.printf("%10s mama %4$d %.2f %c", "hello", 2, 1.1, 123);
		return string.matches(regex);
	}
}
