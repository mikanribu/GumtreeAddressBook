
import java.util.Date;


public class Person {

	protected String firstName;
	protected String lastName;
	protected String gender;
	protected Date date;
	
	public Person(String sName, String sGender, Date sDate)
	{
		String[] allName = sName.split(" ");
		this.firstName = allName[0];
		this.lastName = allName[1];
		this.gender = sGender;
		this.date = sDate;

		
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
