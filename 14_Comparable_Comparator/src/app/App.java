package app;
import java.util.Arrays;

import Comparators.CompareCatsByAge;
import Comparators.CompareCatsByBreed;
import Comparators.CompareCatsByName;
import Comparators.CompareCatsByWeight;

public class App {

	public static void main(String[] args) {
		Cat[] cats = {new Cat("Whiskers", "Siamese", 	2, 	4.5),
					new Cat("Murzik", 	"Persian", 		3, 	6.6), 
					new Cat("Murzik", 	"Maine Coon", 	5, 	8.0),
					new Cat("Murzik", 	"Bengal", 	10, 4.0),
					new Cat("Murzik", 	"Maine Coon", 	5, 	6.6),
					new Cat("Shadow", 	"Sphynx", 		4, 	3.7),
					new Cat("Ginger", 	"Bengal",	 	2, 	4.8)};
		//1.------------
		Arrays.sort(cats); //first compare by name, then by age, then by weight.
		printCats(cats);
		
		//2.-------------------
//		Write 3 outer Comparators that compare
//		1. by name
//		2. by breed 
//		3. by weight, and then by age

		Arrays.sort(cats, new CompareCatsByName().thenComparing(new CompareCatsByBreed()));
		printCats(cats);
		
		Arrays.sort(cats, new CompareCatsByName().thenComparing(new CompareCatsByAge()));
		printCats(cats);
		
		Arrays.sort(cats, new CompareCatsByName().
				thenComparing(new CompareCatsByBreed().
						thenComparing(new CompareCatsByWeight().
								thenComparing(new CompareCatsByAge()))));
		printCats(cats);
	}
	
	
	private static void printCats(Cat[] cats) {
		for (Cat el : cats) {
			System.out.println("-----------\n" + el );
		}
		System.out.println("===================\n\n");
	}

}
