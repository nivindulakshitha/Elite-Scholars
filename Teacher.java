package elitescholarsacademy;
/**
*	@author Nivindu Lakshitha
*	@license Creative Common
*/

public class Teacher extends Human { // Inherit from superclass Human
	public Grade grade = null; // Grade must be Grade object between 1 and 13

	public Teacher (String index, String name) {
		this.index = index;
		this.name = name;
		this.attendaceUp();
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		if (grade == null) {
			return 0;
		} else {			
			return this.grade.value;
		}
	}
}

