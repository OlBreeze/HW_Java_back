import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegExpTest {

	@Test
	void testThreeDigitNumber()
	{
		assertTrue(RegEx.isThreeDigitNumber("123"));
		assertTrue(RegEx.isThreeDigitNumber("100"));
		assertTrue(RegEx.isThreeDigitNumber("999"));
		assertFalse(RegEx.isThreeDigitNumber("000"));
		assertFalse(RegEx.isThreeDigitNumber("007"));
		assertFalse(RegEx.isThreeDigitNumber("1"));
		assertFalse(RegEx.isThreeDigitNumber("11"));
		assertFalse(RegEx.isThreeDigitNumber("1111"));
		assertFalse(RegEx.isThreeDigitNumber("-111"));
		assertFalse(RegEx.isThreeDigitNumber("111.1"));
		assertFalse(RegEx.isThreeDigitNumber("11a"));
		assertFalse(RegEx.isThreeDigitNumber("111$"));
		assertFalse(RegEx.isThreeDigitNumber("%111"));
	}

	@Test
	void testIsPositiveNumberLessThan300()
	{
		assertTrue(RegEx.isPositiveNumberLessThan300("0"));
		assertTrue(RegEx.isPositiveNumberLessThan300("1"));
		assertTrue(RegEx.isPositiveNumberLessThan300("11"));
		assertTrue(RegEx.isPositiveNumberLessThan300("111"));
		assertTrue(RegEx.isPositiveNumberLessThan300("299"));
		assertFalse(RegEx.isPositiveNumberLessThan300("-1"));
		assertFalse(RegEx.isPositiveNumberLessThan300("001"));
		assertFalse(RegEx.isPositiveNumberLessThan300("00"));
		assertFalse(RegEx.isPositiveNumberLessThan300("1.1"));
		assertFalse(RegEx.isPositiveNumberLessThan300("300"));
		assertFalse(RegEx.isPositiveNumberLessThan300("aaa"));
	}

	@Test
	void testIsraelMobile()
	{
		assertFalse(RegEx.isIsraelMobile("(+(972541234567"));
		assertTrue(RegEx.isIsraelMobile("0541234567"));
		assertTrue(RegEx.isIsraelMobile("055-1234567"));
		assertTrue(RegEx.isIsraelMobile("059-123-4567"));
		assertTrue(RegEx.isIsraelMobile("058-123-45-67"));
		assertTrue(RegEx.isIsraelMobile("+972541234567"));
		assertTrue(RegEx.isIsraelMobile("+972-54-123-4-5-6-7"));
		assertTrue(RegEx.isIsraelMobile("(+972)541234567"));
		assertTrue(RegEx.isIsraelMobile("+(972)541234567"));
		assertTrue(RegEx.isIsraelMobile("(054)123-45-67"));
		assertFalse(RegEx.isIsraelMobile("541234567"));
		assertFalse(RegEx.isIsraelMobile("05412345679999"));
		assertFalse(RegEx.isIsraelMobile("0641234567"));
		assertFalse(RegEx.isIsraelMobile("054--1234567"));
		assertFalse(RegEx.isIsraelMobile("0541234567-"));
		assertFalse(RegEx.isIsraelMobile("972541234567"));
		assertFalse(RegEx.isIsraelMobile("0541b34567"));
		assertFalse(RegEx.isIsraelMobile("0541$34567"));
	}

	@Test
	void testIsNumber()
	{
		assertTrue(RegEx.isNumber("0"));
		assertTrue(RegEx.isNumber("-0"));
		assertTrue(RegEx.isNumber("1"));
		assertTrue(RegEx.isNumber("11"));
		assertTrue(RegEx.isNumber("1111"));
		assertTrue(RegEx.isNumber("11111111111"));
		assertTrue(RegEx.isNumber("-1"));
		assertTrue(RegEx.isNumber("-11"));
		assertTrue(RegEx.isNumber("-1111"));
		assertTrue(RegEx.isNumber("-11111111111"));
		assertTrue(RegEx.isNumber("0.1"));
		assertTrue(RegEx.isNumber("-0.1"));
		assertTrue(RegEx.isNumber("1.1"));
		assertTrue(RegEx.isNumber("-1.1"));
		assertTrue(RegEx.isNumber("111.1"));
		assertTrue(RegEx.isNumber("1111111.1111"));
		assertFalse(RegEx.isNumber("1111111,1111"));
		assertFalse(RegEx.isNumber("011"));
		assertFalse(RegEx.isNumber("-011.1111"));
		assertFalse(RegEx.isNumber("11..1111"));
		assertFalse(RegEx.isNumber("-11.11.11"));
		assertFalse(RegEx.isNumber("aaa"));
		assertFalse(RegEx.isNumber("$1111"));
		assertFalse(RegEx.isNumber("11 11"));
		assertFalse(RegEx.isNumber("1111."));
		assertFalse(RegEx.isNumber("1111-"));
		assertFalse(RegEx.isNumber("-111-1"));
		assertFalse(RegEx.isNumber("-.1111"));
	}

	@Test
	void testIsPositiveLessThan1000()
	{
		assertTrue(RegEx.isPositiveLessThan1000("1"));
		assertTrue(RegEx.isPositiveLessThan1000("0"));
		assertTrue(RegEx.isPositiveLessThan1000("11"));
		assertTrue(RegEx.isPositiveLessThan1000("111"));
		assertTrue(RegEx.isPositiveLessThan1000("999"));
		assertFalse(RegEx.isPositiveLessThan1000("1000"));
		assertFalse(RegEx.isPositiveLessThan1000("-1"));
		assertFalse(RegEx.isPositiveLessThan1000("-1.1"));
		assertFalse(RegEx.isPositiveLessThan1000("1.1"));
		assertFalse(RegEx.isPositiveLessThan1000("sss"));
		assertFalse(RegEx.isPositiveLessThan1000("1%"));
		assertFalse(RegEx.isPositiveLessThan1000("1a"));
		assertFalse(RegEx.isPositiveLessThan1000("001"));
	}

	@Test
	void testIsPositiveLessThanEquals255()
	{
		assertTrue(RegEx.isPositiveLessThanEquals255("255"));
		assertTrue(RegEx.isPositiveLessThanEquals255("1"));
		assertTrue(RegEx.isPositiveLessThanEquals255("0"));
		assertFalse(RegEx.isPositiveLessThanEquals255("256"));
		assertFalse(RegEx.isPositiveLessThanEquals255("-255"));
		assertFalse(RegEx.isPositiveLessThanEquals255("-1"));
		assertFalse(RegEx.isPositiveLessThanEquals255("255.1"));
		assertFalse(RegEx.isPositiveLessThanEquals255("25 5"));
		assertFalse(RegEx.isPositiveLessThanEquals255("a"));
	}

	@Test
	void testEmailAddress()
	{
		// there must be @
		// before @ maybe any symbols except whitespace and comma
		// after @ may be any letters or digits or dashes
		// email address should ended either .co.il or .mail.ru
		assertTrue(RegEx.isEmailCoIlMailRu("t%u@12.co.il"));
		assertTrue(RegEx.isEmailCoIlMailRu("t#u@t.mail.ru"));
		assertTrue(RegEx.isEmailCoIlMailRu("12_5-6*@y.co.il"));
		assertTrue(RegEx.isEmailCoIlMailRu("tu@-12.co.il"));
		assertFalse(RegEx.isEmailCoIlMailRu("t,u@12.co.il"));// , - disallowed
		assertFalse(RegEx.isEmailCoIlMailRu("t u@12.co.il"));// space disallowed
		assertFalse(RegEx.isEmailCoIlMailRu("ttu@1#2.co.il"));// after @ the symbol # disallowed
		assertFalse(RegEx.isEmailCoIlMailRu("ttu@12.mail1ru"));// neither .co.il nor mail.ru
		assertFalse(RegEx.isEmailCoIlMailRu("ttu@12co.il"));// neither .co.il nor mail.ru
		assertFalse(RegEx.isEmailCoIlMailRu("ttu12.co.il"));// no @
		assertFalse(RegEx.isEmailCoIlMailRu("ttu@1_2.co.il"));// after @ the symbol _ disallowed
		
	}

	@Test
	void testArithmeticExpression()
	{
	// operands (positive integer numbers), operators either with space or no space between
		// Arithmetic operations + * / -
		assertTrue(RegEx.isArithmeticExpression("2+3 /7"));
		assertTrue(RegEx.isArithmeticExpression("2"));
		assertTrue(RegEx.isArithmeticExpression("2*3 /7"));
		assertTrue(RegEx.isArithmeticExpression(" 2 + 3 / 7"));
		assertFalse(RegEx.isArithmeticExpression("*3 /7"));
		assertFalse(RegEx.isArithmeticExpression("2..5 +8/2"));// ..
		assertFalse(RegEx.isArithmeticExpression("2*5 +8#2"));// # isn't code operation
	}

	@Test
	void testCheckCreditCardNumber()
	{
		assertTrue(RegEx.checkCreditCardNumber("12345678"));
		assertTrue(RegEx.checkCreditCardNumber("1234567890"));
		assertTrue(RegEx.checkCreditCardNumber("1234567887654321"));
		assertFalse(RegEx.checkCreditCardNumber("12345678876543210"));
		assertFalse(RegEx.checkCreditCardNumber("1234567"));
		assertFalse(RegEx.checkCreditCardNumber("123456780A"));
	}

	@Test
	void testCheckDateFormatEU()
	{
		assertTrue(RegEx.checkDateFormatEU("25.01.2020"));
		assertTrue(RegEx.checkDateFormatEU("05.11.2018"));
		assertFalse(RegEx.checkDateFormatEU("32.12.2020"));
		assertFalse(RegEx.checkDateFormatEU("12.15.2020"));
		assertFalse(RegEx.checkDateFormatEU("12/12/2020"));
		assertFalse(RegEx.checkDateFormatEU("2020.12.15"));
		assertFalse(RegEx.checkDateFormatEU("2020-12-15"));
		assertFalse(RegEx.checkDateFormatEU("5.11.2018"));
	}

	@Test
	void testCheckDateFormatUS()
	{
		assertTrue(RegEx.checkDateFormatUS("2020-12-15"));
		assertTrue(RegEx.checkDateFormatUS("2020-05-21"));
		assertFalse(RegEx.checkDateFormatUS("2020-05-32"));
		assertFalse(RegEx.checkDateFormatUS("2020-15-30"));
		assertFalse(RegEx.checkDateFormatUS("2020-121-30"));
	}

	@Test
	void testIsIPv4() {
		assertTrue(RegEx.isIPv4("1.2.3.4"));
		assertTrue(RegEx.isIPv4("255.0.13.40"));
		assertTrue(RegEx.isIPv4("0.0.0.0"));
		assertTrue(RegEx.isIPv4("255.255.255.255"));
		assertFalse(RegEx.isIPv4("256.255.255.255"));
		assertFalse(RegEx.isIPv4("-2.255.255.255"));
		assertFalse(RegEx.isIPv4("255.255.255.255."));
		assertFalse(RegEx.isIPv4("255.255.255"));
		assertFalse(RegEx.isIPv4("255.255"));
		assertFalse(RegEx.isIPv4("255"));
		assertFalse(RegEx.isIPv4(".56.255.255.255"));
	}

}
