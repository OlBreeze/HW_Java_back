import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalAppl {

	public static void main(String[] args) {
		Movie[] movies = { new Movie("The Shawshank Redemption", 1994, 9.3), 
				new Movie("The Godfather", 1972, 9.2),
				new Movie("The Dark Knight", 2008, 9.0),
				new Movie("The Lord of the Rings: The Return of the King", 2003, 8.9),
				new Movie("Pulp Fiction", 1994, 8.9), new Movie("Schindler's List", 1993, 8.9),
				new Movie("Forrest Gump", 1994, 8.8), new Movie("Inception", 2010, 8.7),
				new Movie("Inception", 2010, 8.7),
				new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, 8.8),
				new Movie("The Lord of the Rings: The Two Towers", 2002, 8.7) };
		
		ArrayList<Company> list = new ArrayList<Company>(Arrays.asList(
				new Company("Google", Arrays.asList("John", "Jane")),
				new Company("Microsoft", Arrays.asList("Tim", "Andrew")),
				new Company("Apple", Arrays.asList("Mike", "Mary")), new Company("Google", Arrays.asList("Tom", "Tim")),
				new Company("Microsoft", Arrays.asList("Peter", "Pam")),
				new Company("Apple", Arrays.asList("John", "Andrew"))));
		
		//================ reduce ===
		System.out.println(Stream.of(1,2,3,4,5,6,7,8).reduce(1, (acc, n) -> acc * n));
		System.out.println(Stream.of(1,2,3,4,5,6,7,8).reduce((acc, n) -> acc * n).orElse(0));
		
		System.out.println(Stream.of(1,2,3,4,5,6,7,8)
				.reduce(0, (acc, n) -> n % 2 == 0 ? acc + n : acc));
		
		System.out.println(Arrays.stream(movies).filter(m -> m.year == 1994).count()); // count - это вариант reduce
		
		System.out.println(Arrays.stream(movies).mapToDouble(m -> m.rating).min().orElse(0));
		
		System.out.println(Arrays.stream(movies).map(m -> m.title).max(String::compareTo).get());
		
		System.out.println(Arrays.stream(movies).mapToDouble(m -> m.rating).average().orElse(0));
		
		DoubleSummaryStatistics s = Arrays.stream(movies).mapToDouble(m -> m.rating).summaryStatistics();
		
		System.out.printf("Sum = %.2f, min = %.2f, max = %.2f, count = %d, average = %.2f\n",
				s.getSum(), s.getMin(), s.getMax(), s.getCount(), s.getAverage());
		//=================
		System.out.println(Arrays.stream(movies).noneMatch(m -> m.year == 2002));
		System.out.println(Arrays.stream(movies).anyMatch(m -> m.year == 2002));
		System.out.println(Arrays.stream(movies).allMatch(m -> m.year > 1900));
		//=================
		System.out.println(Arrays.stream(movies).distinct().findFirst().get());
		//=================
		Stream.of(1,2,3,4,5).forEach(e -> System.out.print(e));
		System.out.println();
		Stream.of(1,2,3,4,5).forEachOrdered(e -> System.out.print(e));
		System.out.println();
		Stream.of(1,2,3,4,5).parallel().forEach(e -> System.out.print(e));
		System.out.println();
		Stream.of(1,2,3,4,5).parallel().forEachOrdered(e -> System.out.print(e));
		System.out.println();
		//=================collection====
		List<String> listStr = Arrays.stream(movies).map(m -> m.title).distinct()
				.collect(Collectors.toList());
		System.out.println(listStr);
		listStr.add("Film1");
		System.out.println(listStr);
		
		listStr = Arrays.stream(movies).map(m -> m.title).distinct().toList();
		System.out.println(listStr);
//		listStr.add("Film1");
		
		Set<Integer> set = Arrays.stream(movies).map(m -> m.year).collect(Collectors.toSet());
		System.out.println(set);
		set.add(1);
		System.out.println(set);
		
		set = Arrays.stream(movies).map(m -> m.year).collect(Collectors.toUnmodifiableSet());
//		set.add(1);
		
		Map<String, Double> map = Arrays.stream(movies).distinct()
				.collect(Collectors.toMap(m -> m.title, m -> m.rating));
		System.out.println(map);
		
		map = Arrays.stream(movies)
				.collect(Collectors.toMap(m -> m.title, m -> m.rating, (r1, r2) -> (r1 + r2)/2));
		System.out.println(map);
		
		Map<String, Integer> map1 = Stream.of("Java", "JavaScript", "React", "Kotlin")
				.collect(Collectors.toMap(s1 -> s1, String::length));
		System.out.println(map1);
		
		LinkedList<String> list1 = Arrays.stream(movies).map(m -> m.title)
				.collect(Collectors.toCollection(()->new LinkedList<>()));
		System.out.println(list1);
		list1 = Arrays.stream(movies).map(m -> m.title)
				.collect(Collectors.toCollection(LinkedList::new));
		System.out.println(list1);
		
		LinkedHashMap<String, Integer> map2 = Stream.of("Java", "JavaScript", "React", "Kotlin")
				.collect(Collectors.toMap(s1 -> s1, String::length, (l1,l2)->l1, LinkedHashMap::new));
		System.out.println(map2);
		//=====================
		Map<Double, List<Movie>> map3 = Arrays.stream(movies)
				.collect(Collectors.groupingBy(m -> m.rating));
		System.out.println(map3);
		
		Map<Integer, List<String>> map4 = Stream.of("Java", "JavaScript", "React", "Kotlin", "Mama")
				.collect(Collectors.groupingBy(String::length));
		System.out.println(map4);
		
		
		String res = Stream.of("Java", "JavaScript", "React", "Kotlin", "Rubi")
				.collect(Collectors.teeing(Collectors.minBy(Comparator.comparing(String::length))
						, Collectors.maxBy(Comparator.comparing(String::length))
						, (min, max) -> min.orElse(null) + " - " + max.orElse(null)));
		System.out.println(res);
		
	}

}
