## 1. Write three Annotation types for mapping between any class and any table:
  ### 1.1. @Table 
          1.1.1 Only for Type (Annotation may be used only for class/interface/enum)
          1.1.2 Parameter: table name as a String - mandatory 
  ### 1.2 @Id
          1.2.1 Only for Field (Annotation may be used only for a field)
          1.2.2 No parameter
  ### 1.3 @Index
         1.3.1 Only for Field (Annotation may be used only for a field)
         1.3.2 Parameter: unique . Boolean type designated either unique or non-unique field values. Default value: false
       
## 2. Write class TableInfoRunner with the public static method runInfo(Object obj) that displaying out the following info
      Table: <table name> (In the case the annotation @Table is missing the table name should be a class name without package name.   
      For getting a class name see the doc of the class Class)  
      Id: the field name that is annotated with @Id. If no such field exists the method should throw RuntimeException with   
      the message “No Id is defined”. If there are more than one field with the annotation @Id the method should throw RuntimeException with the message “Id duplication”  
     Unique Indexes: the list of the field names annotated with the annotation Index having unique *value* true  
      Non-unique Indexes: the list of the field names annotated with the annotation Index having unique *value* false  


## 3. Write class Person containing some fields for the testing of TableInfoRunner functionality. For testing whole functionality you should put different annotations from the developed in the #1
## 4. Write class TableInfoAppl with the public static method main for running tests and see the info/exceptions/messages 
