package elitescholarsacademy;
/**
*	@author Nivindu Lakshitha
*	@license Creative Common
*/

public class Student extends Human { // Inherit from superclass Human
	public Grade grade; //Grade must be Grade object between 1 and 13
	
	public Student (String index, String name) {
		this.index = index;
		this.name = name;
		this.attendaceUp();
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade.value;
	}
}
