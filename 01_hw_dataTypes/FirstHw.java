package telran.hw;

public class FirstHw {
	public static void main(String[] args) {
		System.out.println("Char min value = " + getMinCharValue());
		System.out.println("Char max value = " + getMaxCharValue());
		System.out.println();
		
		System.out.println("Byte min value = " + getMinByteValue());
		System.out.println("Byte min value 'speed up' = " + getMinByteSpeedValue());
		System.out.println("Byte max value = " + (byte)(getMinByteSpeedValue()-1));
		System.out.println();
		
		System.out.println("Short min value = " + getMinShortSpeedValue());
		System.out.println("Short max value = " + (short)(getMinShortSpeedValue()-1));
		System.out.println();
		
		
		System.out.println("Int min value 'speed up' = " + getMinIntSpeedValue());
		System.out.println("Int max value = " + (int)(getMinIntSpeedValue()-1));
		System.out.println();
		
		System.out.println("Long min value 'speed up' = " + getMinLongSpeedValue());
		System.out.println("Long max value = " + (long)(getMinLongSpeedValue()-1));
		System.out.println("Long max value 'bit' = " + getMaxLongValueBit());
		
	}
	
	
	//--- CHAR 2 byte = 16 bit
	private static int getMinCharValue() {
		//return 0; 		// самый простой ответ
		
		char res = 500; 	// если я не знаю минимальную границу
		int min = (int) res;
		
		while ((int) res > 0) {
			res += 1;
			if (res < min)
				min = (int) res;
		}
		return (int) min; 
	}

	
	
	private static int getMaxCharValue() {
		char res = 1;
		int max = (int) res;
		
		while ((int) res > 0) {
			res += 1;
			if (res > max)
				max = (int) res;
		}
		return (int) max; 
	}
	    
	//-------  Byte
	private static byte getMinByteValue() {
		byte res = 1;
		while(res>0) {
			res += 1;			
		}
		return res;
	}
	
	// ускоренный способ
	private static byte getMinByteSpeedValue() {
		byte res = 1;
		while(res>0) {
			res *= 2;			
		}
		return res;
	}
	
	// SHORT
	private static short getMinShortSpeedValue() {
		short res = 1;
		while(res>0) {
			res *= 2;			
		}
		return res;
	}
	
	// INT
	private static int getMinIntSpeedValue() {
		int res = 1;
		while(res>0) {
			res *= 2;			
		}
		return res;
	}
	
	
	//----- LONG
	private static long getMinLongSpeedValue() { 
		long res = 1; 
		while(res > 0) 
			res *= 2;
		return res; 
		 }
	
	// ---  битовые сдвиги
	private static long getMaxLongValueBit() { 
		long res = 1; 
		while(res > 0) 
			res<<= 1;
		return res; 
		 }
	
	private static long getMaxLongValue3() { 
	 return ~getMinLongSpeedValue();
	}
	
	//---------------

}
