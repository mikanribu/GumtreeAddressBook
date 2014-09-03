
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {

	protected String firstName;
	protected String lastName;
	protected String gender;
	protected Date date;
	
	public Person(String sName, String sGender, String sDate)
	{
		String[] allName = sName.split(" ");
		this.firstName = allName[0].trim();
		this.lastName = allName[1].trim();
		this.gender = sGender.trim();
		
		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			this.date = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName
				+ ", gender=" + this.gender + ", date=" + this.date + "]";
	}
	
	public int isMale()
	{
		if(this.gender.equals("Male") )
			return 1;
		return 0;
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
