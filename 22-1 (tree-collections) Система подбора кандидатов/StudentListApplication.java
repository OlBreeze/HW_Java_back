package hashsetexample;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentListApplication {
	static final String INTRO = "Please enter information about student: \"Full name, Group, Student id\"";
	static final String INVALID_INPUT = "Invalid input! Must be in format: \"String, String, Numeric String\"";
	static final String INPUT_REGEX = "\\s*[A-Z][a-z]+\\s+[A-Z][a-z]+\\s*,\\s*[A-Z][a-z]+-[0-9]{1,2}\\s*,\\s*[0-9]{6,9}\\s*";
	
	static Scanner scanner = new Scanner(System.in);
	static Set<Student> students = new HashSet<>();
 	
	public static void main(String[] args) {
		
//		for (;;) {    // ==  while(true) {}
//			
//		}
		
		while(true) {
			System.out.print(INTRO + "\n----> ");
			String input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("end")) {
				printAllStudents();
				break;
			}
			
			if (!checkInput(input)) {
				System.out.println("\n" + INVALID_INPUT + "\n");
				continue;
			}
			
			Student student = createStudentFromInput(input);
			System.out.println(String.format("Student with id '%d' %s!\n", student.getStudentId(),
																(students.add(student) ? "was successfully added" : "already exists"))); //O(1)	
		}
	}

	private static Student createStudentFromInput(String input) {
		String[] values = input.trim().split("\\s*,\\s*");
		String fullName = values[0].replaceAll("\\s+", " ");
		Student student = new Student(Integer.parseInt(values[2]), fullName, values[1]);
		return student;
	}

	private static void printAllStudents() {
		System.out.println((students.isEmpty() ? "No students" : "List of students:"));
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static boolean checkInput(String input) {
		return input.matches(INPUT_REGEX);
	}
}
