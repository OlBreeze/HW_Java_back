import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrefixSuffixTest {
	
	AbstractPrefixSuffix myHashSet;
	AbstractPrefixSuffix myTreeSet;
	
	String[] strArray = {"AAA", "BBB", "CCC", "AAwqew", "BBsdcf", "wqewAA", "sdcfBB"}; 
	
	@BeforeEach
	void setUp() throws Exception {
		myHashSet = new PrefixSuffixHashSet();
		myHashSet.addWords(strArray);
		
		myTreeSet = new PrefixSuffixTreeSet();
		myTreeSet.addWords(strArray);
	}

	   @Test
	    public void testContainsWord() {
	        assertTrue(myHashSet.containsWord("AAA"));
	        assertTrue(myTreeSet.containsWord("BBB"));
	        assertTrue(myHashSet.containsWord("CCC"));
	        assertTrue(myTreeSet.containsWord("CCC"));
	        
	        assertFalse(myHashSet.containsWord("DDD"));
	        assertFalse(myTreeSet.containsWord("DDD"));
	    }

	   
	   @Test
	    public void testGetWordsWithPrefix() {
		   // There is result with Suffix
	        String[] arrayHashSetPr = myHashSet.getWordsWithPrefix("AA");
	        String[] arrayTreeSetPr = myTreeSet.getWordsWithPrefix("BB");

	        assertArrayEquals(new String[]{"AAA", "AAwqew"}, arrayHashSetPr);
	        assertArrayEquals(new String[]{"BBB", "BBsdcf"}, arrayTreeSetPr);
	        
	        //-- No Matches
	        arrayHashSetPr = myHashSet.getWordsWithPrefix("V");
	        arrayTreeSetPr = myTreeSet.getWordsWithPrefix("V");

	        assertArrayEquals(new String[]{}, arrayHashSetPr);
	        assertArrayEquals(new String[]{}, arrayTreeSetPr);
	        
	        arrayHashSetPr = myHashSet.getWordsWithPrefix("");
	        assertEquals(7, arrayHashSetPr.length); // all array
	    }
	   
	    @Test
	    public void testGetWordsWithSuffix() {
	    	String[] arrayHashSetSf = myHashSet.getWordsWithSuffix("AA");
	        String[] arrayTreeSetSf = myTreeSet.getWordsWithSuffix("BB");

	        assertArrayEquals(new String[]{"AAA", "wqewAA"}, arrayHashSetSf);
	        assertArrayEquals(new String[]{"BBB", "sdcfBB"}, arrayTreeSetSf);
	        
	      //-- No Matches
	        arrayHashSetSf = myHashSet.getWordsWithSuffix("V");
	        arrayTreeSetSf = myTreeSet.getWordsWithSuffix("V");

	        assertArrayEquals(new String[]{}, arrayHashSetSf);
	        assertArrayEquals(new String[]{}, arrayTreeSetSf);
	        
	        arrayHashSetSf = myHashSet.getWordsWithSuffix("");
	        assertEquals(7, arrayHashSetSf.length); // all array
	    }
}
