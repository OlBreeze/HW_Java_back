package hashsetexample;

import java.util.Objects;

public class Student {
	private Integer studentId;
	private String fullName;
	private String group;

	public Student(Integer studentId, String fullName, String group) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.group = group;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getGroup() {
		return group;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentId, other.studentId);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", group=" + group + "]";
	}
}
