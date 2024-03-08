package elitescholarsacademy;
/**
*	@author Nivindu Lakshitha
*	@license Creative Common
*/

class Human {
	protected String index;
	protected String name;
	private boolean gender; //True stands for male and opposite for female
	private String address;
	private int attendance = 0;
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void attendaceUp() {
		this.attendance++;
	}
	
	public boolean getGender() {
		return this.gender;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getAttendance() {
		return this.attendance;
	}
}
