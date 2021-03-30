package viewer;

import java.util.Scanner;

import controller.*;
import model.Boat;
import model.BoatType;
import model.Member;

public class Console {
	
	private int input;
	
	protected int getInput() {
		try {
			Scanner scan = new Scanner(System.in);
			input = scan.nextInt();
		return input;
		}catch(Exception e) {
			
		}
		return -1;
	}
	// start screen
	public void startPage() {
		System.out.println("=======================================================");
		System.out.println("Write 0 to Start!");
		System.out.println("Write 10 to Quit!");
		System.out.println("-------------------------------------------------------");
	}
	
	public boolean restart() {
		return input==0;
	}
	public boolean quit() {
		return input==10;
	}
	//choice screen
	public void presentInstructions(){
			System.out.println("=======================================================");
			System.out.println("Write 1 to create a member!");
			System.out.println("Write 2 to display compactlist!");
			System.out.println("Write 3 to display verbosetlist!");
			System.out.println("Write 4 to delete member!");
			System.out.println("Write 5 to change member information!");
			System.out.println("Write 6 to Look at a specific members information!");
			System.out.println("Write 7 to register a boat!");
			System.out.println("Write 8 to delete a boat!");
			System.out.println("Write 9 to change a boats information!");
			System.out.println("Write 10 to Quit!");
			System.out.println("-------------------------------------------------------");
	}
	public void sendAcc() {
		System.out.println("Action succsesfull");
	}

	public void checkInput() {
		input = getInput();
	}
	
	//methods for create a member
	public boolean wantToCreateMember() {
		return input == 1;
	}
	public String memberName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Name:");
		return scan.next();
	}
	public long memberPn() {
		Scanner scan = new Scanner(System.in);
		System.out.println("PersonalNumber (yymmddxxxx):");
		return scan.nextLong();
	}
	
	// compactlist
	public boolean wantToShowCompact() {
		return input == 2;
	}
	//verboselist
	public boolean wantToShowVerbose() {
		return input == 3;
	}
	
	// delete a member methods
	public boolean wantToDeleteMember() {
		return input == 4;
	}
	public String deleteMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Member id:");
		return scan.next();
	}
	//change member and help methods
	public boolean wantToChangeMemberInfo() {
		return input == 5;
	}
	//choice change personalnumber or name
	public boolean changeMemberInfo() {
		System.out.println("Press 1 for Name and any key for PersonalNumber");
		checkInput();
		return input==1;
	
	}
	//take in a name
	public String setName() {
		System.out.println("Name: ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	//take in personalnumber
	public long setPn() {
		System.out.println("PersonalNumber (yymmddxxxx): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLong();
	}
	
	//look at member info
	public boolean wantToLookAtMemberInfo() {
		return input == 6;
	}
	//returns the id of the member
	public String memberToLookAt() {
		System.out.println("Id of member: ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	//Name or personalnumber choice
	public boolean NameOrPn() {
		System.out.println("Enter 1 for Name and any key for PersonalNumber");
		checkInput();
		return input==1;
	}
	// print name
	public void printName(String Name) {
		System.out.println("Member Name: "+Name);
	}
	//print personalnumber
	public void printPn(long pn) {
		System.out.println("PersonalNumber: "+pn);
	}
	
	// register boat
	public boolean wantToRegisterBoat() {
		return input == 7;
	}
	//print the types and take in choice
	public String typeOfBoat() {
		System.out.println("Enter type (Sailboat, Motorsailer, Kayak, Canoe, Other)start with capital-letter: ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	//take in length of the boat
	public int lengthOfBoat() {
		System.out.println("Enter length om the boat (in meters): ");
		checkInput();
		return input;
	}
	//delete boat
	public boolean wantToDeleteBoat() {
		return input == 8;
	}
	// take in the id of a member to aboat
	public String memberOfBoat() {
		System.out.println("Id of member: ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	//take in id of a boat
	public int idOfBoat() {
		System.out.println("Id of boat: ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	//change a boat
	public boolean wantToChangeBoat() {
		return input == 9;
	}
	// choice of what we want to change length or type
	public boolean changeBoat() {
			System.out.println("Enter 1 for Length and any key for Type");
			checkInput();
			return input==1;
	}
	
}
