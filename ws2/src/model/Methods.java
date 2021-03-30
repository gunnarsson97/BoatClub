package model;

import java.util.ArrayList;

public class Methods {
	protected int idCounter =1;
	private ArrayList <Member> member_list;
	public Methods() {
		member_list = new ArrayList<Member>();
	}
	
	protected void setIdCounter(int counter) {
		idCounter=counter;
	}
	
	//create a member
	public void createMember(String Name, long pn) {
		Member member = new Member(Name,pn, this.idCounter++);
		addMember(member);		
	}
	//add member in to member list used mainly in create member
	public void addMember(Member mem){
		Methods.this.member_list.add(mem);
	}
	//create a boat
	public Boat createBoat(int len,BoatType.Types type, String member_id) throws Exception {
			int temp = getMemberById(member_id);
			Boat b = new Boat(len,type,this.idCounter++);
			return b;
	}
	//remove member from memberlist
	public void deleteMember(String id) throws Exception{
		member_list.remove(getMemberById(id));
	}
	
	//returns member index in list
	public int getMemberById(String id) throws Exception {
		for(int i=0; i<member_list.size(); i++) {
			if(member_list.get(i).getId().equals(id)) {
				return i;
			}
		}
		throw new Exception("Member do not exist");
	}
	//return a copy of member list
	public ArrayList <Member> getList(){
		ArrayList <Member> copy = new ArrayList<Member>(member_list);
		return copy;
	}
	//return index of a boat in boat list
	public int getBoatById(int id, ArrayList<Boat> boat_list) throws Exception {
		for(int i=0; i<boat_list.size(); i++) {
			if(boat_list.get(i).getID()==id) {
				return i;
			}
		}
		throw new Exception("Boat do not exist");
	}
}
