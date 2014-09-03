import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class AddressBook {

	protected List<Person> adBook = new ArrayList<Person>();
	
	public AddressBook(){
		this.adBook = readFile();
	}
	
	public List<Person> readFile() 
	{
		List<Person> adB = new ArrayList<Person>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/Files/AddressBook.txt"));
			
	        String line = null;

	        while ( (line = br.readLine()) != null ) {

	        	System.out.println(line);
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
	
	
	public static void main(String[] args) {
		AddressBook adb = new AddressBook();
		
//		for (Person p : adb.adBook) {
//			System.out.println(p.toString());
//		}
		
		int male = adb.howManyMale();
		Person older = adb.whoIsTheOldest();
		System.out.println(male);
		System.out.println(older.toString());
	}
}
