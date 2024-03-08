package elitescholarsacademy;
/**
*	@author Nivindu Lakshitha
*	@license Creative Common
*/

public class Grade {
	public int value;
	private int count = 0;
	private String[] studentArray = new String[1000];
	
	public Grade(int value) {
		this.value = value;
	}
	
	public void addStudent (String index) {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] == null) {
				studentArray[i] = index;
				this.count++;
				break;
			}
		}
	}
	
	public void removeStudent (String index) {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] != null && studentArray[i].equals(index)) {
				studentArray[i] = null;
				this.count--;
				break;
			}
		}
	}
	
	public int getCount () {
		return this.count;
	}
}