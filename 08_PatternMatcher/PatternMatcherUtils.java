import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherUtils {

private static final String DELIMETER = ";";
	
	public static String[] regexPatternMatcher(String regexp, String str) {
		
		//System.out.println("--- regexp: " + regexp);
		
		if(str == null || str.isBlank()|| regexp == null || regexp.isEmpty())
			return null;
		
		StringBuilder res = new StringBuilder(); 
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(str);
		
		while (matcher.find()) {
			//System.out.println(matcher.start());
			res.append(matcher.group()).append(DELIMETER);
		}
		
		//System.out.println(res);
		
		return res.toString().split(DELIMETER);
	}
}
