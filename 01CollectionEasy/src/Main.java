import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		ArrayList<Users> users = new ArrayList<Users>();
		
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		do {
			
			System.out.println("Options");
			System.out.println("1. Start Sharing");
			System.out.println("2. Update Participants");
			System.out.println("3. Delete Participants");
			System.out.println("4. Close App");
			try {
				choice=scan.nextInt();
				
			} catch (Exception e) {
				
				System.out.println("input must be numeric");
				scan.nextLine();
			}
			
			int number=0;
			
			//START SHARING
			if(choice==1)
			{
				System.out.printf("Input a number [0-100]:"); //INPUT NUMBERS
				
				do {
					try {
						number=scan.nextInt();
					} catch (Exception e) {
						System.out.println("input must be numeric");
						scan.nextLine();
					}
					
				}while(number<1 ||number>100);
				scan.nextLine();
				
				System.out.printf("Could you give me your username [5 - 20 Characters]? ");
				
				String name = null;
				
	
				do {
					try {
						name=scan.nextLine();
						
					} catch (Exception e) {
						System.out.println("input must be unique and 5-20 characters!");
						scan.nextLine();
					}
					if(Users.nameValidation(name, users) == false)
					{
						System.out.println("input must be unique and 5-20 characters!");
					}
				}while(Users.nameValidation(name, users) == false);
				
				
				Users userMain = new Users(name, number);
				users.add(userMain);
//				System.out.println(userMain.name+userMain.numbers);
				
//				for (Users user : users) {
//					System.out.println(user.name+" "+user.numbers);
//				}
				
//				System.out.println("done");
//				System.out.println(users.size());
				
				System.out.println("Press enter to proceed!");
				scan.nextLine();
			}
			else if(choice==2) //UPDATE
			{
				
				int optupdate = 999;
				if(users.size()==0)
				{
					System.out.println("No Data!");
					scan.nextLine();
					scan.nextLine();
					continue;
				}
				else if(optupdate==0)
				{
					break;
				}
				else
				{
					
					do {
						System.out.println("====================================");
						System.out.println("Sharelist");
						System.out.println("====================================");
						for (int i=0;i< users.size();i++) 
						{
							System.out.printf((i+1)+" |"+users.get(i).name+"\t\t\t|"+users.get(i).numbers+"|\n");
						}
						System.out.println("====================================");
						System.out.printf("Which participant you would like to update [1-%d][0 to exit]", users.size());
						try {
							optupdate=scan.nextInt();
						} catch (Exception e) {
							System.out.println("Input must be numeric");
							scan.nextLine();
							
						}
						
						
						if(optupdate>users.size()||optupdate<0)
						{
							scan.nextLine();
							continue;
						}
						else if(optupdate==0)
						{
							break;
						}
	
						int numupdate=-1;
						
						do {
							System.out.printf("Input a number[0-100]: ");
							try {
								numupdate=scan.nextInt();
							} catch (Exception e) {
								System.out.printf("Input a number[0-100]: ");
								scan.nextLine();
							}
						}while(numupdate<1 || numupdate>100);
						
						for(int i=0;i<users.size();i++)
						{
							if(i==optupdate-1)
							{
								users.get(i).numbers=numupdate;
								break;
							}
						}
							
					}while(optupdate != 0 || optupdate>users.size());

						scan.nextLine();
			
				}
					
			}
			else if(choice==3) //DELETE
			{
				int optDelete = 999;
				if(users.size()==0)
				{
					System.out.println("No Data!");
					scan.nextLine();
					scan.nextLine();
					break;
				}
				else if(optDelete==0)
				{
					break;
				}
				else
				{
					
					do {
						if(users.size()==0)
						{
							System.out.println("No Data!");
							scan.nextLine();
							break;
						}
						System.out.println("====================================");
						System.out.println("Sharelist");
						System.out.println("====================================");
						for (int i=0;i< users.size();i++) 
						{
							System.out.printf((i+1)+" |"+users.get(i).name+"\t\t\t|"+users.get(i).numbers+"|\n");
						}
						System.out.println("====================================");
						System.out.printf("Which participant you would like to delete [1-%d][0 to exit]", users.size());
						try {
							optDelete=scan.nextInt();
						} catch (Exception e) {
							System.out.println("Input must be numeric");
							scan.nextLine();
							scan.nextLine();
							
						}
						
						if(optDelete>users.size())
						{
							continue;
						}
						else if(optDelete==0)
						{
							break;
						}
	
						
						
						for(int i=0;i<users.size();i++)
						{
							if(i==optDelete-1)
							{
								users.remove(i);
								System.out.println("Participant successfully removed from event");
								break;
							}
						}
							
					}while(optDelete != 0 || optDelete>users.size());

						scan.nextLine();
				}

			}
			else if(choice==4)
			{
				
				Collections.sort(users, Users.userNameComparator);
				ArrayList<Integer>  numshuffle = new ArrayList<Integer>();
				
				for(int i=0;i<users.size();i++)
				{
					numshuffle.add(users.get(i).numbers);
				}
				
				Collections.shuffle(numshuffle);
				Collections.reverse(numshuffle);
				
				System.out.println("Here's the complete share list");
				System.out.println("Remember, sharing is caring, happy sharing :D");
				System.out.println("+====================================+");
				System.out.println("+Share List                          +");
				System.out.println("+====================================+");
				System.out.println("+ Username              |Before|After+");
				System.out.println("+====================================+");
				
				
				for (int i=0;i< users.size();i++) 
				{
					System.out.printf("|"+"%-25s"+"|%-5d"+"|%-2d"+"|\n",users.get(i).name,users.get(i).numbers,numshuffle.get(i));
					
				}
				System.out.println("+====================================+");
			}
			
		}while(choice!=4);

	
	}
}
