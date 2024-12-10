package tel.app;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import tel.annotation.*;

public class TableInfoRunner {

	public static void runInfo(Object obj) {
		Class<? extends Object> classOfObj = obj.getClass();

		System.out.print("1.  Table: ");
		Table tab = classOfObj.getAnnotation(Table.class);
		System.out.println(tab != null ? tab.name() : classOfObj.getSimpleName());

		
		Field[] fields = classOfObj.getDeclaredFields();
		System.out.print("2.  Field with ID: ");
		
		List<Field> fID = Arrays.stream(fields)
				.filter(f -> f.isAnnotationPresent(Id.class)).toList();

		if (fID.size() == 0)
			throw new RuntimeException("No Id is defined");
		else if (fID.size() > 1)
			throw new RuntimeException("Id duplication");
		else
			System.out.println(fID.get(0).getName());
		
		System.out.println("3.1. Field with unique Index: ");

		Arrays.stream(fields)
			.filter(f -> f.isAnnotationPresent(Index.class) && f.getAnnotation(Index.class).unique())
				.toList().forEach(f -> System.out.println("\t" + f.getName()));

		System.out.println("3.2. Field with non-unique Index: ");
		Arrays.stream(fields)
			.filter(f -> f.isAnnotationPresent(Index.class) && !f.getAnnotation(Index.class).unique())
				.toList().forEach(f -> System.out.println("\t" + f.getName()));

	}
}
