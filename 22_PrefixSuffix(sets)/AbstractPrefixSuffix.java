import java.util.ArrayList;
import java.util.Set;

public abstract class AbstractPrefixSuffix implements IPrefixSuffixSearch{
	
	Set<String> collection;
	
	@Override
	public void addWords(String[] words) {
		 for (String word : words) {
			collection.add(word);
		}
	}

	@Override
	public boolean containsWord(String word) {
		return collection.contains(word);
	}

    @Override
    public String[] getWordsWithPrefix(String prefix) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : collection) {
        	//if (word.matches(prefix+".*")) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
    
	@Override
	public String[] getWordsWithSuffix(String suffix) {
		//return array of Strings, which finish with the suffix 
		
		ArrayList<String> result = new ArrayList<>();
        for (String word : collection) {
        	if (word.matches(".*" + suffix))
            //if (word.endsWith(suffix)) 
                result.add(word);
            
        }
        return result.toArray(new String[0]);
		
	}

}

