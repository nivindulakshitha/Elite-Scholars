package elitescholarsacademy;
/**
*	@author Nivindu Lakshitha
*	@license Creative Common
*/

import java.util.Scanner;

public class Program {
	
	public static Scanner consoleReader = new Scanner(System.in);
	private static String[] mainMenu = {"Student", "Teacher", "Course", "Grade", "Exit"};
	private static String[] studentMenu = {"Register", "Attendance", "Remove", "Summary", "Exit"};
	private static String[] teacherMenu = studentMenu.clone();
	private static String[] courseMenu = {"Create", "Remove", "Summary", "Exit"};
	private static String[] gradeMenu = {"Summary", "Exit"};
	private static Student[] studentArray = new Student[1000];
	private static Teacher[] teacherArray = new Teacher[1000];
	private static Course[] courseArray = new Course[100];
	private static Grade[] gradeArray = {
			new Grade(1),
			new Grade(2),
			new Grade(3),
			new Grade(4),
			new Grade(5),
			new Grade(6),
			new Grade(7),
			new Grade(8),
			new Grade(9),
			new Grade(10),
			new Grade(11),
			new Grade(12),
			new Grade(13)
	};
	public static boolean programStop = false;
	
	public static void main(String[] args) {
		while (!(programStop)) {
			clearConsole();
			print("[Out] dir: Main menu\n", true);
			openMenu("main", mainMenu);
			print("[Ins] Press <Enter> to return to the main menu or end the session", true);
			consoleReader.nextLine(); //Consume any leftover input
			consoleReader.nextLine();
		}
	}
	
	//Print a menu to the console
	private static void openMenu(String destination, String[] menuItems) {
		for (int index = 0; index < menuItems.length; index++) {
			print("-> " + (index + 1) + ". " + menuItems[index], true);
		}
		
		print("\n[Ins] Select a function below", true);
		
		if (!(handleMenu(destination, takeInt(), menuItems.length))) {
			print("\n[Err] Process has been terminated due to invalid input received\n", true);
			openMenu(destination, menuItems);
		} else {
			return;
		}
	}
	
	//Handle menu option selection
	private static boolean handleMenu (String destination, int option, int menuLength) {
		if (option > 0 &&  option <= menuLength) {
			
			if (destination.equals("main")) {
				switch (option) {
					case 1: {
						clearConsole();
						print("[Out] dir: Main menu > Student\n", true);
						openMenu("student",  studentMenu);
						break;
					}
					case 2: {
						clearConsole();
						print("[Out] dir: Main menu > Teacher\n", true);
						openMenu("teacher", teacherMenu);
						break;
					}
					case 3: {
						clearConsole();
						print("[Out] dir: Main menu > Course\n", true);
						openMenu("course", courseMenu);
						break;
					}
					case 4: {
						clearConsole();
						print("[Out] dir: Main menu > Grade\n", true);
						openMenu("grade", gradeMenu);
						break;
					}
					default: {
						print("\n[Out] Exiting...", true);
						programStop = true;
					}
				}
			} else if (destination.equals("student")) {
				handleStudentMenu(option);
				
			} else if (destination.equals("teacher")) {
				handleTeacherMenu(option);
				
			} else if (destination.equals("course")) {
				handleCourseMenu(option);
				
			} else if (destination.equals("grade")) {
				handleGradeMenu(option);
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	//Handle student menu select option
	private static boolean handleStudentMenu(int option) {
		
		if (option > 0 && option < 6) {
			switch (option) {
				case 1: {
					clearConsole();
					print("[Out] dir: Main menu > Student > Register\n", true);
					
					//Form to perform registration process
					print("\n[Out] Registration index (-1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index = consoleReader.next();
					
					while (true) {
						boolean repeat = false;
						
						for (Student student: studentArray) {
							if (student != null && student.index.equals(index)) {
								repeat = true;
								break;
							}
						}
						
						if (repeat) {
							print("\n[Err] Process has been terminated due to duplicate indexes", true);
							System.out.print("\n<- Text value: ");
							index = consoleReader.next();
							continue;
						} else {
							break;
						}
					}
					
					if (index.equals("-1")) {
						print("\n[Out] Exiting...", true);
						return true;
						
					} else if (index.length() < 1 || index.length() > 5) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Name in full", true);
					String name = takeString();
					
					if (name.length() <= 3) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Select gender", true);
					print("-> 1. Male\n-> 2. Female", true);
					int gender = takeInt();
					
					if (gender < 1 || gender > 2) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Grade value (1 - 13)", true);
					int grade = takeInt();
					
					if (grade < 1 || grade > 13) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Private address", true);
					String address = takeString();
					
					if (address.length() <= 5) {
						print("\n[Err] None proper input received & process is terminated", true);
						return true;
					}
					
					for (int i = 0; i < studentArray.length; i++) {
						if (studentArray[i] == null) {
							studentArray[i] = new Student(index.toString().toUpperCase(), name);
							gradeArray[grade - 1].addStudent(index);
							
							switch (gender) {
								case 1: {
									studentArray[i].setGender(true);
									break;
								}
								case 2: {
									studentArray[i].setGender(false);
									break;
								}
							}
							
							studentArray[i].setGrade(gradeArray[grade - 1]);
							studentArray[i].setAddress(address);
							
							print("\n[Suc] New student is registered under index: " + index, true);
							return true;
						}
					}
					
					print("\n[Err] Process is terminated due to space being exceeded", true);
					return true;
				
				} case 2: {
					clearConsole();
					print("[Out] dir: Main menu > Student > Attendance\n", true);
					
					print("\n[Out] Registration index (-1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index = consoleReader.next();
					
					if (index == "-1") {
						print("\n[Out] Exiting...", true);
						return true;
						
					} else if (index.length() < 1 || index.length() > 5) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("-> 1. Present\n-> 2. Absent", true);
					int attendance = takeInt();
					
					if (attendance == 1 || attendance == 2) {
						for (int i = 0; i < studentArray.length; i++) {
							Student student = studentArray[i];
							
							if (student != null && index.equals(student.index)) {
								if (attendance == 1) {
									student.attendaceUp(); //Increases the attendance count
								}
								print("\n[Suc] Modifications have been made to index " + student.index, true);
								return true;
							}
						}
						
						//If the given index does not match with the indexes in the array
						print("\n[Err] Process terminated due to invalid index received", true);
						return true;
					} else {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
				} case 3: {
					clearConsole();
					print("[Out] dir: Main menu > Student > Remove\n", true);
					
					//Get the index to be removed
					print("\n[Out] Registration index (Upper case, -1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index01 = consoleReader.next();
					
					if (index01 == "-1") {
						print("\n[Out] Exiting...", true);
						return true;
					}
					
					//Re-get the index to be removed
					print("\n[Out] Registration index (RE, Upper case)", true);
					System.out.print("\n<- Text value: ");
					String index02 = consoleReader.next();
					
					if (index01.equals(index02)) {
						for (int i = 0; i < studentArray.length; i++) {
							Student student = studentArray[i];
							
							if (student != null && index01.equals(student.index)) {
								print("\n[Suc] Modifications have been made to index " + student.index, true);
								studentArray[i].grade.removeStudent(index01); //Remove the student from the grade
								studentArray[i] = null; //Make the index as null in the array
								return true;
							}
						}
						
						//If the given index does not match with the indexes in the array
						print("\n[Err] Process terminated due to invalid index received", true);
						return true;
						
					} else {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
				} case 4: {
					clearConsole();
					print("[Out] dir: Main menu > Student > Summary\n", true);
					
					print("#\tIndex\tName\t\tGender\tGrade\tAttendance\tAddress", true);
					int i = 0;
					for (Student student: studentArray) {
						if (student != null) {
							i++;
							print(i + ". \t", false);
							print(student.index + "\t", false);
							print(student.name + "\t", false);
							print(String.valueOf(student.getGender()) + "\t", false);
							print(String.valueOf(student.getGrade()) + "\t", false);
							print(String.valueOf(student.getAttendance()) + "\t\t", false);
							print(student.getAddress(), false);
							print("", true);
						}
					}
					
					return true;
					
				} default: {
					print("\n[Out] Exiting...", true);
					return true;
				}
			}
			
		} else {
			return false;
		}
	}
	
	//Handle teacher menu select option
	private static boolean handleTeacherMenu(int option) {
		
		if (option > 0 && option < 6) {
			switch (option) {
				case 1: {
					clearConsole();
					print("[Out] dir: Main menu > Teacher > Register\n", true);
					
					//Form to perform registration process
					print("\n[Out] Registration index (-1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index = consoleReader.next();
					
					while (true) {
						boolean repeat = false;
						
						for (Teacher teacher: teacherArray) {
							if (teacher != null && teacher.index.equals(index)) {
								repeat = true;
								break;
							}
						}
						
						if (repeat) {
							print("\n[Err] Process has been terminated due to duplicate indexes", true);
							System.out.print("\n<- Text value: ");
							index = consoleReader.next();
							continue;
						} else {
							break;
						}
					}
					
					if (index.equals("-1")) {
						print("\n[Out] Exiting...", true);
						return true;
						
					} else if (index.length() < 1 || index.length() > 5) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Name in full", true);
					String name = takeString();
					
					if (name.length() <= 3) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Select gender", true);
					print("-> 1. Male\n-> 2. Female", true);
					int gender = takeInt();
					
					if (gender < 1 || gender > 2) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Teacher of class (optional, 0 to skip)", true);
					int grade = takeInt();
					
					if (grade < 0 || grade > 13) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Private address", true);
					String address = takeString();
					
					if (address.length() <= 5) {
						print("\n[Err] None proper input received & process is terminated", true);
						return true;
					}
					
					for (int i = 0; i < teacherArray.length; i++) {
						if (teacherArray[i] == null) {
							teacherArray[i] = new Teacher(index.toString().toUpperCase(), name);
							
							switch (gender) {
								case 1: {
									teacherArray[i].setGender(true);
									break;
								}
								case 2: {
									teacherArray[i].setGender(false);
									break;
								}
							}
							
							if (grade != 0) {
								teacherArray[i].setGrade(gradeArray[grade - 1]);
							}
							teacherArray[i].setAddress(address);
							
							print("\n[Suc] New teacher is registered under index: " + index, true);
							return true;
						}
					}
					
					print("\n[Err] Process is terminated due to space being exceeded", true);
					return true;
				
				} case 2: {
					clearConsole();
					print("[Out] dir: Main menu > Teacher > Attendance\n", true);
					
					print("\n[Out] Registration index (-1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index = consoleReader.next();
					
					if (index == "-1") {
						print("\n[Out] Exiting...", true);
						return true;
						
					} else if (index.length() < 1 || index.length() > 5) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("-> 1. Present\n-> 2. Absent", true);
					int attendance = takeInt();
					
					if (attendance == 1 || attendance == 2) {
						for (int i = 0; i < teacherArray.length; i++) {
							Teacher teacher = teacherArray[i];
							
							if (teacher != null && index.equals(teacher.index)) {
								if (attendance == 1) {
									teacher.attendaceUp(); //Increases the attendance count
								}
								print("\n[Suc] Modifications have been made to index " + teacher.index, true);
								return true;
							}
						}
						
						//If the given index does not match with the indexes in the array
						print("\n[Err] Process terminated due to invalid index received", true);
						return true;
					} else {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
				} case 3: {
					clearConsole();
					print("[Out] dir: Main menu > Teacher > Remove\n", true);
					
					//Get the index to be removed
					print("\n[Out] Registration index (Upper case, -1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index01 = consoleReader.next();
					
					if (index01 == "-1") {
						print("\n[Out] Exiting...", true);
						return true;
					}
					
					//Re-get the index to be removed
					print("\n[Out] Registration index (RE, Upper case)", true);
					System.out.print("\n<- Text value: ");
					String index02 = consoleReader.next();
					
					if (index01.equals(index02)) {
						for (int i = 0; i < teacherArray.length; i++) {
							Teacher teacher = teacherArray[i];
							
							if (teacher != null && index01.equals(teacher.index)) {
								print("\n[Suc] Modifications have been made to index " + teacher.index, true);
								teacherArray[i] = null; //Make the index as null in the array
								return true;
							}
						}
						
						//If the given index does not match with the indexes in the array
						print("\n[Err] Process terminated due to invalid index received", true);
						return true;
						
					} else {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
				} case 4: {
					clearConsole();
					print("[Out] dir: Main menu > Teacher > Summary\n", true);
					
					print("#\tIndex\tName\t\tGender\tGrade\tAttendance\tAddress", true);
					int i = 0;
					for (Teacher teacher: teacherArray) {
						if (teacher != null) {
							i++;
							print(i + ". \t", false);
							print(teacher.index + "\t", false);
							print(teacher.name + "\t", false);
							print(String.valueOf(teacher.getGender()) + "\t", false);
							print(String.valueOf(teacher.getGrade()) + "\t", false);
							print(String.valueOf(teacher.getAttendance()) + "\t\t", false);
							print(teacher.getAddress(), false);
							print("", true);
						}
					}
					
					return true;
					
				} default: {
					print("\n[Out] Exiting...", true);
					return true;
				}
			}
			
		} else {
			return false;
		}
	}

	//Handle course menu select option
	private static boolean handleCourseMenu(int option) {
		
		if (option > 0 && option < 5) {
			switch (option) {
				case 1: {
					clearConsole();
					print("[Out] dir: Main menu > Course > Create\n", true);
					
					//Form to perform registration process
					print("\n[Out] Registration index (-1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index = consoleReader.next();
					
					while (true) {
						boolean repeat = false;
						
						for (Course course: courseArray) {
							if (course != null && course.index.equals(index)) {
								repeat = true;
								break;
							}
						}
						
						if (repeat) {
							print("\n[Err] Process has been terminated due to duplicate indexes", true);
							System.out.print("\n<- Text value: ");
							index = consoleReader.next();
							continue;
						} else {
							break;
						}
					}
					
					if (index.equals("-1")) {
						print("\n[Out] Exiting...", true);
						return true;
						
					} else if (index.length() < 1 || index.length() > 5) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					print("\n[Out] Name", true);
					String name = takeString();
					
					if (name.length() <= 3) {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
					
					Course theCourse = new Course(index, name);
					
					print("\n[Out] Compatible grades (1,2,3,...)", true);
					print("\n<- Text value: ", false);
					String grade = consoleReader.next();
					for (String gradeElement: grade.strip().split(",")) {
						grade = gradeElement.trim();
						if (grade.length() < 1 ||  grade.length() > 2) {
							continue;
						}
						int intGrade = Integer.parseInt(grade);
						if (intGrade > 0 && intGrade < 14) {
							theCourse.setGrade(intGrade);
						}
						try {
							
						} catch (Exception error) {}
					}
					
					print("\n[Out] Taught by", true);
					String teacher = takeString();
					for (Teacher teacherElement: teacherArray) {
						if (teacherElement != null && teacherElement.index.toLowerCase().equals(teacher.trim().toLowerCase())) {
							theCourse.setTeacher(teacherElement);
							break;
						}
					}
					
					for (int i = 0; i < courseArray.length; i++) {
						if (courseArray[i] == null) {
							courseArray[i] = theCourse;

							print("\n[Suc] New course is registered under index: " + index, true);
							return true;
						}
					}
					break;
				}
				
				case 2: {
					clearConsole();
					print("[Out] dir: Main menu > Course > Remove\n", true);
					
					//Get the index to be removed
					print("\n[Out] Registration index (Upper case, -1 to exit)", true);
					System.out.print("\n<- Text value: ");
					String index01 = consoleReader.next();
					
					if (index01.equals("-1")) {
						print("\n[Out] Exiting...", true);
						return true;
					}
					
					//Re-get the index to be removed
					print("\n[Out] Registration index (RE, Upper case)", true);
					System.out.print("\n<- Text value: ");
					String index02 = consoleReader.next();
					
					if (index01.equals(index02)) {
						for (int i = 0; i < courseArray.length; i++) {
							Course course = courseArray[i];
							
							if (course != null && index01.equals(course.index)) {
								print("\n[Suc] Modifications have been made to index " + course.index, true);
								//teacherArray[i].grade.removeStudent(index01); //Remove the student from the grade
								courseArray[i] = null; //Make the index as null in the array
								return true;
							}
						}
						
						//If the given index does not match with the indexes in the array
						print("\n[Err] Process terminated due to invalid index received", true);
						return true;
						
					} else {
						print("\n[Err] Process has been terminated due to invalid input received", true);
						return true;
					}
				}
				
				case 3: {
					clearConsole();
					print("[Out] dir: Main menu > Course > Summary\n", true);
					
					print("#\tIndex\tName\t\tGrades\t\t\t\t\tTeacher", true);
					int i = 0;
					for (Course course: courseArray) {
						if (course != null) {
							i++;
							print(i + ".\t", false);
							print(course.index + "\t", false);
							print(course.name + "\t\t", false);
							print(String.valueOf(course.getGrades()) + "\t\t", false);
							Teacher teacher = course.getTeacher();
							if (teacher == null) {
								print("null", false);
							} else {
								print(teacher.name, false);
							}
							print("", true);
						}
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	//Handle grade menu select option
	private static boolean handleGradeMenu(int option) {
		if (option > 0 && option < 3) {
			switch (option) {
				case 1: {
					clearConsole();
					print("[Out] dir: Main menu > Grade > Summary\n", true);
					
					print("#\tIndex\tCount\tTeacher", true);
					int i = 0;
					for (Grade grade: gradeArray) {
						if (grade != null) {
							i++;
							print(i + ".\t", false);
							print(grade.value + "\t", false);
							print(grade.getCount() + "\t", false);
							
							for (Teacher teacher: teacherArray) {
								if (teacher != null && teacher.grade.value == grade.value) {
									print(teacher.name, false);
								}
							}
							
							print("", true);
						}
					}
					return true;
				} case 2: {
					print("\n[Out] Exiting...", true);
					return true;
				}
			}
		}
		
		print("\n[Err] Process has been terminated due to invalid input received", true);
		return false;
	}
		
	//Clear the console exist text
	private static void clearConsole() {
		try {
			
			if (System.getProperty("os.name").contains("Windows"))  {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\\033[H\\033[2J");
				System.out.flush();
			}
			
			//Print the header as clear the console
			printHeader();
			
		} catch (Exception error) {}
	}

	//Prints the header text to the console
	
	private static void printHeader() {
		System.out.println("\n\tELITE SCHOLARS ACADEMY");
		System.out.println("    Student Management System [SMS]");
		System.out.println("---------------------------------------\n");
	}

	//This method will be printing values to the console
	
	public static void print(String text, boolean newLine) {
		System.out.print(text);
		
		if (newLine) {
			System.out.print("\n");
		}
	}

	//Returns integer input to referenced point
	
	public static int takeInt() {
		System.out.print("\n<- Integer value: ");
		return consoleReader.nextInt();
	};

	//Returns integer input to referenced point
	
	public static String takeString() {
		System.out.print("\n<- Text value: ");
		consoleReader.nextLine(); //Consume any leftover input
		return consoleReader.nextLine();
	};
}