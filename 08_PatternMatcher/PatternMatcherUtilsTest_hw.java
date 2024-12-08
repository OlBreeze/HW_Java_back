import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatternMatcherUtilsTest_hw {

	/**
	 * Build regular expressions to extract all integer numbers from sentence
	 */
	@Test
	public void testTaskA()
	{
		String[] expected = { "3", "25", "888" };
		String regexp = "\\d+";
		String[] actual = PatternMatcherUtils.regexPatternMatcher(regexp, 
				"Today during 3 hours we studied 25 tutorial chapters and built 888 expressions");
		assertArrayEquals(expected, actual);
	}
	
	/**
	 * Build regular expressions to extract price in dollars from sentence
	 */
	@Test
	public void testTaskB()
	{
		String[] expected = { "$1.56", "$550,000" };
		String regexp = "\\$\\d+(.|,)\\d+";
		
		String[] actual = PatternMatcherUtils.regexPatternMatcher(regexp, "Pen costs $1.56 , but house costs $550,000");
		assertArrayEquals(expected, actual);
	}
	
	/**
	 * Write regular expressions to find the full name (first and last name) of all persons with
			first name Jacob in sentence
	 */
	@Test
	public void testTaskC()
	{
		String[] expected = { "Jacob Cohen" };
		
		String regexp = "\\bJacob \\w+";
		String[] actual = PatternMatcherUtils.regexPatternMatcher(regexp, "Abraham Smith, Jacob Cohen, Peter Jacobson, Meir Jacob");
		assertArrayEquals(expected, actual);
	}
	
	/**
	 * Write regular expression to find the full name (first and last name) of all persons with last
			name Jacob (exactly!) or Cohen in the same sentence
	 */
	@Test
	public void testTaskD()
	{
		String[] expected = { "Jacob Cohen", "Meir Jacob" };
		String regexp = "\\w+ (Jacob|Cohen)\\b";
		String[] actual = PatternMatcherUtils.regexPatternMatcher(regexp, "Abraham Smith, Jacob Cohen, Peter Jacobson, Meir Jacob");
		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void testTaskE()
	{
		/*
		 * \\b: Граница слова для захвата полных слов. 
		 * (\\w+): Захватывает первое имя (состоящее из одного или более букв). 
		 * \\1: Обратная ссылка на захваченное имя, чтобы фамилия начиналась с этого имени. 
		 * \\w*: Остальная часть фамилии.
		 * \\b: Граница слова для завершения фамилии.
		 * 
		 * Для повторного использования слова группы используется обозначение \n,  где n — номер группы.
		 * 
		 */
		
		String[] expected = { "Ivan Ivanov", "Oskar Oskarson", "Peter Peterson" };
		String regexp = "\\b(\\w+) \\1\\w*\\b";
		String[] actual = PatternMatcherUtils.regexPatternMatcher(regexp, "Rachel Simpson, Ivan Ivanov, Oskar Oskarson, Meyer Peterson, Peter Peterson");
		assertArrayEquals(expected, actual);
	}

}

