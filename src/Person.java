
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {

	protected String firstName;
	protected String lastName;
	protected String gender;
	protected Date date;
	
	/**
	 * Constructor
	 * @param sName
	 * @param sGender
	 * @param sDate
	 */
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
	
	/**
	 * Return the older person between 2 persons
	 * @param p Person
	 * @return Person, the older person
	 */
	public Person isOlder(Person p)
	{
		if(this.date.after(p.date)){
    		return p;
    	}
		else if(this.date.before(p.date)){
    		return this;
    	}

		return this;

	}
	
	/**
	 * Tell if the person is a Male
	 * @return 1 if Male, 0 either
	 */
	public int isMale()
	{
		if(this.gender.equals("Male") )
			return 1;
		return 0;
	}
	
	/**
	 * Return the age difference in day between 2 persons
	 * @param p
	 * @return diff, difference between 2 dates
	 */
	public long ageDifference(Person p)
	{
		long diff = this.date.getTime() - p.date.getTime();
		
//		System.out.println("Difference is "
//		        + (diff / (1000 * 60 * 60 * 24)) + " days.");
//		  
		return diff / (1000 * 60 * 60 * 24);
	}
	
	
	public String getName()
	{
		return firstName+" "+lastName;
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
