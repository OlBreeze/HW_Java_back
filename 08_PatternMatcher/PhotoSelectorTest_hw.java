import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhotoSelectorTest_hw {

	private static final String[] pictures = {
			"Paris\\20140109_090000.jpg", // Town\\year month day _time
			"Paris\\20140201_121005.jpg",				
			"Paris\\20150301_211035.jpg",				
			"Paris\\20150401_110023.gif",
			"Paris\\20150901_181705.jpg",				
			"Paris\\20150501_231035.gif",				
			"London\\20140205_090000.jpg",
			"London\\20140205_121005.jpg",				
			"London\\20140901_211035.gif",				
			"London\\20151001_110023.jpg",
			"London\\20151001_121705.jpg",				
			"London\\20151001_231035.jpg",
			"Chicago\\20130301_120151.png",
			"Chicago\\20130301_201501.png",
			"Chicago\\20150301_120001.png",
			"Chicago\\20151111_232000.png"
	};

	@Test
	void testAllAutumnPhoto() {
		
		String[] exp = {
				"Paris\\20150901_181705.jpg",
				"London\\20140901_211035.gif",				
				"London\\20151001_110023.jpg",
				"London\\20151001_121705.jpg",				
				"London\\20151001_231035.jpg",
				"Chicago\\20151111_232000.png"
		};
	
		String regex = "\\D\\d{4}(09|10|11)";
		assertArrayEquals(exp, PhotoSelector.selectPhoto(pictures, regex));
	}
	
	@Test
	void testAll2015Photo() {
		
		String[] exp = {
				"Paris\\20150301_211035.jpg",				
				"Paris\\20150401_110023.gif",
				"Paris\\20150901_181705.jpg",				
				"Paris\\20150501_231035.gif",				
				"London\\20151001_110023.jpg",
				"London\\20151001_121705.jpg",				
				"London\\20151001_231035.jpg",
				"Chicago\\20150301_120001.png",
				"Chicago\\20151111_232000.png"
		};
	
		String regex = "\\D(2015)\\d{4}_";
		assertArrayEquals(exp, PhotoSelector.selectPhoto(pictures, regex));
}
	
	@Test
	void testAllNightPhoto() { //  (from 18:00 till 24:00)
		
		String[] exp = {
				"Paris\\20150301_211035.jpg",				
				"Paris\\20150901_181705.jpg",				
				"Paris\\20150501_231035.gif",				
				"London\\20140901_211035.gif",				
				"London\\20151001_231035.jpg",
				"Chicago\\20130301_201501.png",
				"Chicago\\20151111_232000.png"
		};


		String regex = "_(1[89]|2[0-3])";
		assertArrayEquals(exp, PhotoSelector.selectPhoto(pictures, regex));
	}
	
	@Test
	void testAllNightChicagoPhoto() { //  (from 18:00 till 24:00)
		
		String[] exp = {
				"Chicago\\20130301_201501.png",
				"Chicago\\20151111_232000.png"
		};
	
		String regex = "Chicago.*_(1[89]|2[0-3])";
		assertArrayEquals(exp, PhotoSelector.selectPhoto(pictures, regex));
	}
		
}
