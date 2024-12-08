import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {
	
	private static final String DELIMETER = ";";
	
	public static String[] selectPhoto(String[] pictures, String regex) {
		//System.out.println("--- regex: " + regex);
		
		if(pictures == null || pictures.length == 0 || regex == null || regex.isEmpty())
			return null;
		
		StringBuilder res = new StringBuilder(); 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("");
		
		for(int i=0; i<pictures.length; i++) {
			if(pictures[i] == null)
				continue;
			
			matcher.reset(pictures[i]);
			if(matcher.find()){//true
				//System.out.println(matcher.group());
				res.append(pictures[i]).append(DELIMETER);}
		}
		
		//System.out.println(res);
		
		return res.toString().split(DELIMETER);
	}

}
