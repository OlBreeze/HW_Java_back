
public interface IPrefixSuffixSearch {
	void addWords(String[] words);				//add Strings from array to your set
	boolean containsWord(String word);			//return true, if set contains this String
	String[] getWordsWithPrefix(String prefix);	//return array of Strings, which start with the prefix 
	String[] getWordsWithSuffix(String suffix);	//return array of Strings, which finish with the suffix 

}
