package hw_class;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.Test;
import static hw_class.methodsForTest.*;


class methodsForTestTest {

	@Test
	void testIsPalindrome() {
		assertTrue(isPalindrome("aba"));
		assertTrue(isPalindrome("aa aa"));
		assertTrue(isPalindrome("Abba"));
		assertTrue(isPalindrome("  Ab b a  "));
		assertTrue(isPalindrome("	а роза упала на лапу азора "));
		
		assertFalse(isPalindrome(null));
		assertFalse(isPalindrome("abcd"));
		assertFalse(isPalindrome("wawefs"));
		assertFalse(isPalindrome("	"));
	}


	@Test
	void testIsReverse() {
		assertTrue(isReverse("aba", "aba"));
		assertTrue(isReverse(" qwerty	", "ytrewq"));
		
		assertFalse(isReverse(" qw", "ytrewq"));
		assertFalse(isReverse("", "ytrewq"));
		assertFalse(isReverse(null, "ytrewq"));
		assertFalse(isReverse("fcdcf", null));
		
	}

	@Test
	void testMaxCharIndex() {
		assertEquals(maxCharIndex("ddqqqfffff"), 5);
		assertEquals(maxCharIndex("d       ff"), 1);
		assertEquals(maxCharIndex(null), -1);
	}

}
