

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateAppl {

	public static void main(String[] args) {
		Movie[] movies = { new Movie("The Shawshank Redemption", 1994, 9.3), 
				new Movie("The Godfather", 1972, 9.2),
				new Movie("The Dark Knight", 2008, 9.0),
				new Movie("The Lord of the Rings: The Return of the King", 2003, 8.9),
				new Movie("Pulp Fiction", 1994, 8.9), 
				new Movie("Schindler's List", 1993, 8.9),
				new Movie("Forrest Gump", 1994, 8.8), 
				new Movie("Inception", 2010, 8.7),
				new Movie("Inception", 2010, 8.7),
				new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, 8.8),
				new Movie("The Lord of the Rings: The Two Towers", 2002, 8.7) };
		//================filter===
		Arrays.stream(movies).filter(m -> m.rating > 8.9).forEach(System.out::println);
		System.out.println("=================================================");
		//================sorted===
//		Arrays.stream(movies).sorted().forEach(System.out::println);
		Arrays.stream(movies).sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))
		.forEach(System.out::println);
		System.out.println("=================================================");
		//================map======
		Arrays.stream(movies).map(m -> m.rating).forEach(System.out::println);
		System.out.println("=================================================");
		//=================distinct====
		Arrays.stream(movies).distinct().forEach(System.out::println);	
		System.out.println("=================================================");
		//=================limit=======
		Arrays.stream(movies).distinct().limit(3).forEach(System.out::println);
		System.out.println("=================================================");
		//=================skip========
		Arrays.stream(movies).limit(3).skip(2).forEach(System.out::println);
		System.out.println("=================================================");
		Arrays.stream(movies).skip(2).limit(3).forEach(System.out::println);
		System.out.println("=================================================");
		//=================peek========
		List<Movie> res = Arrays.stream(movies).peek(m -> m.rating = 100).toList();
		System.out.println(res);
		Arrays.stream(movies).forEach(System.out::println);
		System.out.println("=================================================");
		//=================takeWhile===
		Stream.of(1,2,3,4,5,6,7,1,2,3).takeWhile(n -> n < 5).forEach(System.out::println);
		System.out.println("=================================================");
		//=================dropWhile===
		Stream.of(1,2,3,4,5,6,7,1,2,3).dropWhile(n -> n < 5).forEach(System.out::println);
		System.out.println("=================================================");
		//=================mapToDouble=
		double res2 = Arrays.stream(movies).mapToDouble(m -> m.rating).average().orElse(0);
		System.out.println(res2);
		System.out.println("=================================================");
		//=================mapToInt====
		int res3 = Arrays.stream(movies).mapToInt(m -> m.year).min().orElse(0);
		System.out.println(res3);
		System.out.println("=================================================");
		//=================mapToLong==
		long res4 = Stream.of(1,2,3,4,5,6,7,8,1,2,3).filter(n -> n % 2 == 0).mapToLong(n -> n).sum();
		System.out.println(res4);
		System.out.println("=================================================");
		//=================mapToObj or boxed==
		System.out.println(lottery(6, 1, 36));
		System.out.println("=================================================");
		//=================flatMap or flatMapToInt or flatMapToDouble or flatMapToLong
		Stream.of("a b c", "d r w").flatMap(str -> Arrays.stream(str.split(" ")))
		.map(s -> s.toUpperCase()).sorted((s1, s2) -> s2.compareTo(s1))
		.forEach(System.out::println);
		
		//2,3,0,1,3 -> 01201230010123
		
		Stream.of(2,3,0,1,3).flatMapToInt(n -> IntStream.range(0, n + 1))
		.forEach(System.out::print);
		
		ArrayList<Company> list = new ArrayList<Company>(Arrays.asList(
                new Company("Google", Arrays.asList("John", "Jane")),
                new Company("Microsoft", Arrays.asList("Tim", "Andrew")),
                new Company("Apple", Arrays.asList("Mike", "Mary")),
                new Company("Google", Arrays.asList("Tom", "Tim")),
                new Company("Microsoft", Arrays.asList("Peter", "Pam")),
                new Company("Apple", Arrays.asList("John", "Andrew"))
                ));
		
		list.stream().flatMap(c -> c.employees.stream()).distinct().forEach(System.out::println);
		
		displayMovieTitlesStream(movies, 1994, 8);
	}
	
	public static List<Integer> lottery(int count, int min, int max){
	//	new Random().ints(min, max + 1).distinct().limit(count).sorted().boxed().toList();
		return new Random().ints(min, max + 1).distinct().limit(count).sorted().mapToObj(n -> n).toList();
	}

	private static void displayMovieTitlesStream(Movie[] movies, int year, double rating) {
		Arrays.stream(movies).filter(m -> m.year == year && m.rating >= rating)
		.sorted((m1, m2) -> {
			int res = Double.compare(m1.rating, m2.rating);
			return res == 0 ? m1.title.compareTo(m2.title) : res;
		}).map(m -> m.title).forEach(System.out::println);
		
	}	
}
