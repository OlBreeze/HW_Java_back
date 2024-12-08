## Implements methods and test them by JUnitests: 

1. public static boolean isPalindrome(String str);   
    The method should return true if string is palindrome and false if is not. The method must be case insensitive and excluding whitespace characters.  
    Examples:  
    "aba" -> true  
    "abcd" -> false  
    "aa aa" -> true  
    "Abba" -> true  
    "  Ab b a  " -> true  
 
2. public static boolean isReverse(String str1, String str2)   
The method takes 2 strings and returns true if the second string is the reverse of the first   
 
3. public static void printSubStringReverse(String str, int start, int end)   
The method should print a substring of the passed string in reverse   
 
4. public static void printStringInColumn(String str)   
The method should output the string to the console character by character in a column. one character per line   
 
### Advanced tasks   
5. public static void validPassword(String password);     
    The method should display if password valid or display reason invalid   
 
    password is valid if:   
    1. Length 8 or more symbols   
    2. Contains one or more uppercase letter   
    3. Contains one or more lowercase letter   
    4. Contains one or more digit   
    5. Contains one or more special symbols from set ("~","!","-","_")   
 
    Example valid password: Aa12345~  
6. advanced ******метод возвращает индекс  символа, который встречается чаще всего в строке.  
   Если символов несколько, которые встречаются одинаковое количество раз, то любого из них.  
   public static int maxCharIndex(String s)   
          s->"ddcccabbbbb"    
                 return 6 

