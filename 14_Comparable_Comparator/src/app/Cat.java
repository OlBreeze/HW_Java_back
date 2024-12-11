package app;

public class Cat implements Comparable<Cat> {
	String name;
	String breed;
	Integer age;
	Double weight;
	
	public Cat(String name, String breed, Integer age, Double weight) {
		super();
		this.name 	= name;
		this.breed 	= breed;
		this.age 	= age;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public Integer getAge() {
		return age;
	}

	public Double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ",\tbreed=" + breed + ",\tage=" + age + ",\tweight=" + weight + "]";
	}

	@Override
	public int compareTo(Cat o) {
		int compName = name.compareToIgnoreCase(o.name);
		return compName != 0? compName: 
			age.compareTo(o.age) != 0? age.compareTo(o.age) : weight.compareTo(o.weight);
	}
	
	

}
