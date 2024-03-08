package elitescholarsacademy;
/**
*	@author Nivindu Lakshitha
*	@license Creative Common
*/

import java.util.Arrays;

public class Course {
	public String index;
	public String name;
	private int grades[] = new int[13];
	private Teacher teacher = null;
	
	public Course (String index, String name) {
		this.index = index;
		this.name = name;
	}
	
	public void setTeacher (Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getTeacher () {
		return this.teacher;
	}
	
	public void setGrade (int grade) {
		this.grades[grade - 1] = grade;
	}
	
	public String getGrades () {
		return Arrays.toString(this.grades);
	}
}
