### 1. Write a Cat class with fields
  String name  
  String breed  
  Integer age  
  Double weight  
  
  Implement the Comparable interface, and the natural comparison algorithm will be: first compare by name, then by age, then by weight.  
  
Write 3 outer Comparators that compare  
  1. by name  
  2. by breed   
  3. by weight, and then by age.  
  
In App, create an array of 5 objects. Sort them first in natural order, then using outer Comparators  
  
2. Write code of the class OddEvenComparator implementing Comparator with the method compare for sorting an array of Integers in the order:
    The even integers should go before odd numbers in the ascending order. The odd integers should  
    go after the even ones in the descending order. Write Junit Test Case for class OddEvenComparator.  
Integer[] origin = {1,2,3,4,5,6,7,8,9,3}  
Integer[] expected = {2,4,6,8,9,7,5,3,3,1}  
