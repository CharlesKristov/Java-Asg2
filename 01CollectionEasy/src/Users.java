import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Users{

	public String name;
	public int numbers;
	
	
	//Constructor
	Users(String Name, Integer Numbers){
		this.name=Name;
		this.numbers=Numbers;
	}
	

	//Method
	public static boolean nameValidation(String name, ArrayList<Users>users) {
		
		
		if(name.length()<5 || name.length()>20)
		{
			return false;
		}
		
		
		for (Users user: users) {
			if(name.equals(user.name))
			{
				return false;
			}
		}			
		
		return true;
	}
	
	 public static Comparator<Users> userNameComparator = new Comparator<Users>() {

			public int compare(Users s1, Users s2) {
			   String username1 = s1.name;
			   String username2 = s2.name;

			   //ascending order
			   return username1.compareTo(username2);
			}
	 };
	
}