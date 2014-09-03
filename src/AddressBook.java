import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class AddressBook {

	protected List<Person> adBook = new ArrayList<Person>();
	
	/**
	 * Constructor
	 */
	public AddressBook(){
		this.adBook = readFile();
	}
	
	/**
	 * Read a File and return a List of all entries
	 * @return List of every person in the file read
	 */
	public List<Person> readFile() 
	{
		List<Person> adB = new ArrayList<Person>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/Files/AddressBook.txt"));
			
	        String line = null;

	        while ( (line = br.readLine()) != null ) {

//	        	System.out.println(line);
	        	String[] parts = line.split(",");
	        	Person p = new Person(parts[0], parts[1], parts[2]);
	        	adB.add(p);
	        }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return adB;
	}
	
	public int howManyMale()
	{
		int male = 0;
		for (Person p : this.adBook) {
			male += p.isMale();
		}
		return male;
	}
	
	public Person whoIsTheOldest()
	{
		Person older = this.adBook.get(0);
		
		for (Person p : this.adBook) {
			older = older.isOlder(p);
		}
		return older;
	}
	
	/**
	 * Get Index ofelement by Name
	 * It would have been easier with Map instead of List and add Key as the Name, but
	 * we didn't know if 2 people have the same Name
	 * @param itemName
	 * @return
	 */
	public int getIndex(String itemName)
	{
	    for (int i = 0; i < this.adBook.size(); i++)
	    {
	        Person p = this.adBook.get(i);
	        if (itemName.equals(p.getFirstName()))
	        {
	            return i;
	        }
	    } 

	    return -1;
	}
	
	@Override
	public String toString() {
		int male 	 = this.howManyMale();
		Person older = this.whoIsTheOldest();

		Person bill = this.adBook.get(this.getIndex("Bill"));
		Person paul = this.adBook.get(this.getIndex("Paul"));
		long dayDiff = paul.ageDifference(bill);
		
		return "Address Book:  \n"+
			"-There are "+male+" male in the book.\n"+
			"-The oldest person is: "+older.getName()+" \n"+
			"-Bill is "+dayDiff+" days older than Paul.";
	}

	
	public static void main(String[] args) {
		AddressBook adb = new AddressBook();
		
		System.out.println(adb.toString());
		
//		for (Person p : adb.adBook) {
//			System.out.println(p.toString());
//		}
		
//		int male = adb.howManyMale();
//		Person older = adb.whoIsTheOldest();
//		System.out.println(male);
//		System.out.println(older.toString());
//		
//		Person bill = adb.adBook.get(0);
//		Person paul = adb.adBook.get(1);
//		System.out.println(adb.getIndex("Paul"));
//		paul.ageDifference(bill);
	}
}
