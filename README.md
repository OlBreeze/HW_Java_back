# HW_Java_back
This set contains my solutions for Java backend homeworks

### Write application PrefixSuffix 

with interface

public interface IPrexixSuffixSearch
{
	void addWords(String[] words);                //add Strings from array to your set
	boolean containsWord(String word);            //return true, if set contains this 
	StringString[] getWordsWithPrefix(String prefix);   //return array of Strings, which start with the prefix 
	String[] getWordsWithSuffix(String suffix);   //return array of Strings, which finish with the suffix 
 }

//---------------

You must to write 2 implementation 
- for HashSet
- for TreeSet

You will not have duplicate code in your implementations

