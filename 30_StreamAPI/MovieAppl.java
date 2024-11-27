package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// функциональное программирование с 8 джавы

public class MovieAppl {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Movie[] movies = { new Movie("The Shawshank Redemption", 1994, 9.3), new Movie("The Godfather", 1972, 9.2),
				new Movie("The Dark Knight", 2008, 9.0),
				new Movie("The Lord of the Rings: The Return of the King", 2003, 8.9),
				new Movie("Pulp Fiction", 1994, 8.9), new Movie("Schindler's List", 1993, 8.9),
				new Movie("Forrest Gump", 1994, 8.8), new Movie("Inception", 2010, 8.7),
				new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, 8.8),
				new Movie("The Lord of the Rings: The Two Towers", 2002, 8.7) };

		displayMovieTitles(movies, 1994, 8);
		// =====================================================
		// создание stream (sours methods)
		// 1. from array
		Stream<Movie> s = Arrays.stream(movies);
		// 2. from collection
		List<Movie> list = new ArrayList<Movie>(Arrays.asList(movies));
		Stream<Movie> s2 = list.stream();
		// 3. from values
		Stream<Integer> s3 = Stream.of(1, 2, 3, 4, 5, 6, 78, 9); // любые обекты
		Stream<Movie> s4 = Stream.of(movies); // любые обекты
		// 4. from String
		IntStream s5 = "Hello".chars();// разбери строку на символы и отправь в стрим
		// 5. builder
		Stream<Integer> ss5 = Stream.<Integer>builder().add(1).add(2).add(3).add(4).build();
		// 6. Infinity stream
		IntStream.iterate(1, x -> x * 2).limit(15).forEach(x -> System.out.print(x + " "));
		// генератор значений с 1 по формуле *2 ограничено 15 чисел и потом напечатает
		System.out.println();
		Stream.generate(() -> "hello").limit(5).forEach(x -> System.out.print(x + " "));
		System.out.println();
		Stream.generate(() -> new Random().nextBoolean()).limit(5).forEach(x -> System.out.print(x + " "));

		// -------------- our task ----------------
		displayMovieTitlesStream(movies, 1994, 8);

	}

	// получить фильмы конкр года выпуска (и по рейтингу)
	// отсортировать по рейтингу и потом в алфавитном порядке фильмы
	// вывести только наименования

	private static void displayMovieTitlesStream(Movie[] movies, int year, double rating) {
		Arrays.stream(movies).filter(t -> t.year == year && t.rating >= rating)
		.sorted((o1,o2)->{
			int res = Double.compare(o1.rating, o2.rating);
			return res == 0 ? o1.title.compareTo(o2.title) : res;
		}).map( m-> m.title).forEach(System.out::println);
	}

	// наше обычное решение
	private static void displayMovieTitles(Movie[] movies, int year, double rating) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		for (Movie m : movies) {
			if (m.year == year && m.rating >= rating)
				list.add(m);
		}

		list.sort(new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				int res = Double.compare(o1.rating, o2.rating);
				return res == 0 ? o1.title.compareTo(o2.title) : res;
			}
		});

		for (Movie m : list) {
			System.out.println(m.title);
		}
	}
}
