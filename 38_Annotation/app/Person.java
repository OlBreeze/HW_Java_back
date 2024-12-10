package tel.app;

import tel.annotation.*;

@Table(name = "TablePerson")
public class Person {
	@Id
	String myId;
	//@Id
	@Index(unique = true)
	String name;
	
	@Index(unique = true)
	int passport;
	
	@Index
	int age;
	@Index
	String country;
	
}
