import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Intermediate32Appl {

	public static void main(String[] args) {		

		ArrayList<Company> list = new ArrayList<Company>(Arrays.asList(
				new Company("Google", Arrays.asList("John", "Jane")),
				new Company("Microsoft", Arrays.asList("Tim", "Andrew")),
				new Company("Apple", Arrays.asList("Mike", "Mary")), new Company("Google", Arrays.asList("Tom", "Tim")),
				new Company("Microsoft", Arrays.asList("Peter", "Pam")),
				new Company("Apple", Arrays.asList("John", "Andrew"))));

		Stream.of("hello", "world").flatMap(s -> s.chars().mapToObj(c -> (char) c))
				.forEach(c -> System.out.print(c + " "));
		System.out.println();
		
		Stream.of("hello", "world").mapMulti((str, sink) -> {
			for(char c : str.toCharArray()) {
				sink.accept(c);
			}
		}).forEach(c -> System.out.print(c + " "));
		System.out.println();
		
		list.stream().mapMulti((c, sink) -> {
			for(String n : c.employees) {
				sink.accept(n);
			}
		}).distinct().forEach(System.out::println);

	}

	

	
}
