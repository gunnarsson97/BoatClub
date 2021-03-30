package controller;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.*;
import viewer.CompactVerboseView;

public class ControllerMain {
	public ControllerMain() {}
	
	FileHandler fh = new FileHandler("Database.txt");
	int flag=0;
	public boolean start(viewer.Console con, Methods method){
		con.startPage();
		con.checkInput();
		Methods met = method;
		if(con.restart()){
			//if we start for first type load data from file set flag and continue
			if(flag==0) {
				flag=1;
				fh.readFile(met);
			}
			
			con.presentInstructions();
			con.checkInput();
			try {
				// if we want to quit
				if(con.quit()) {
					fh.saveChanges(met.getList());	//save changes in txt file
					return false;
				}
				//create a new member
				if(con.wantToCreateMember()) {
					String Name = con.memberName();
					long pn = con.memberPn();
					met.createMember(Name,pn);
					con.sendAcc();
				}
				CompactVerboseView mylist = new CompactVerboseView();
				//compactlist
				if(con.wantToShowCompact()){
					mylist.compactList(met.getList());
					con.sendAcc();
				}
				//verboselist
				if(con.wantToShowVerbose()){
					mylist.verboseList(met.getList());
					con.sendAcc();
				}
				// want to delete a member
				if(con.wantToDeleteMember()){
					String id = con.deleteMember(); //get id of member to delete
					met.deleteMember(id); //delete
					con.sendAcc();
				}
				// if we want tom change members information
				if(con.wantToChangeMemberInfo()){
					String id = con.memberToLookAt(); // get member id
					// if we want to change name
					if(con.changeMemberInfo()) {	
						String Name = con.setName(); // get new name
						met.getList().get(met.getMemberById(id)).setMemberName(Name); //set Name
						con.sendAcc();
					}
					//if we want to change personalnumber
					else {
						long pn = con.setPn(); // get new Personalnumber
						met.getList().get(met.getMemberById(id)).setMemberPn(pn); //set personalnumber
						con.sendAcc();
					}
				}
				// if we want to lock at serten members information
				if(con.wantToLookAtMemberInfo()) {
					String id = con.memberToLookAt();	//get member id
					//if we want name
					if(con.NameOrPn()) {	
						con.printName(met.getList().get(met.getMemberById(id)).getName()); //print the name of member
						con.sendAcc();
					}
					// if we want personalnumber
					else { 
						con.printPn(met.getList().get(met.getMemberById(id)).getPn()); //print Personalnumber
						con.sendAcc();
					}		
				}
				//if we want to register a boat
				if(con.wantToRegisterBoat()) {
					String id = con.memberToLookAt();	//get the member id 
					String type = con.typeOfBoat();	//get type of boat
					try {					
						BoatType.Types typeEnum = BoatType.Types.valueOf(type); //set the type
						int length = con.lengthOfBoat();	//get length of boat
						Boat b = met.createBoat(length,typeEnum,id); //create boat
						met.getList().get(met.getMemberById(id)).addBoat(b); // add boat to member list
						con.sendAcc();	
					}catch(Exception e) {
						throw new Exception("Member Id or Boat / Type not valid!");
					}
				}
				//if we want to delete a boat
				if(con.wantToDeleteBoat()) {
					String id = con.memberOfBoat();	//get member id of the boat owner
					int id_boat = con.idOfBoat();	// get boat id
					met.getList().get(met.getMemberById(id)).removeBoat(id_boat); // get members index in list and get it and remove it
					con.sendAcc();
				}
				// if we want to change a boat
				if(con.wantToChangeBoat()) {
					String id = con.memberOfBoat();
					int boat_id = con.idOfBoat();
					try {
						if(con.changeBoat()) {
							ArrayList <Member> memberList=met.getList();	// get the boat list
							Member m = memberList.get(met.getMemberById(id));	//get the member with the member id of the boat
							int l = con.lengthOfBoat();	//length of boat
							m.getboatlist().get(met.getBoatById(boat_id, m.getboatlist())).setLength(l); // set the length
						}
						else {
							ArrayList <Member> memberList=met.getList();
							Member m = memberList.get(met.getMemberById(id));
							String t = con.typeOfBoat();	//type of boat
							BoatType.Types type=BoatType.Types.valueOf(t); //string to type
							m.getboatlist().get(met.getBoatById(boat_id, m.getboatlist())).setType(type); //set the type
						}
					}catch(Exception e) {
						throw new Exception("Member Id or Boat / Type not valid!");
					}
					
				}
			}catch (Exception e) {
				System.out.println("Something went wrong! Try again!");
				System.out.println(e.getMessage());
			}
		}
		else if(con.quit()) {
			fh.saveChanges(met.getList());	//save changes in txt file
			return false;
		}
		return true;
	}
	
	

}
