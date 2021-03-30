package model;


import java.util.ArrayList;

public class Member {
	private String member_name ="";
	private long member_pn;
	private String member_id;
	ArrayList<Boat> boat_list = new ArrayList<Boat>();
	
	public Member(String name, long pn,int id) {
		member_name = name;
		member_pn = pn;
		member_id = Integer.toString(id);
	}
	public Member(String name, long pn, String id) {
		member_name = name;
		member_pn = pn;
		member_id = id;
	}
	
	public void addBoat(Boat myboat) {
		this.boat_list.add(myboat);
	}
	public void removeBoat(int id) throws Exception {
		for(int i=0; i<Member.this.boat_list.size(); i++) {
			if(Member.this.boat_list.get(i).getID()==id) {
				Member.this.boat_list.remove(i);
				return;
			}
		}
		throw new Exception("Boat do not exist");
	}
	
	
	//get the details of member
	public String getName() {
		return Member.this.member_name;
	}
	
	public String getId() {
		return Member.this.member_id;
	}
	public long getPn() {
		return Member.this.member_pn;
	}
	public int getNumberBoats() {
		return Member.this.boat_list.size();
	}
	public ArrayList<Boat> getboatlist(){
		ArrayList<Boat> copy = new ArrayList<Boat>(boat_list);
		return copy;
	}
	public void setMemberName(String Name) {
		Member.this.member_name = Name;
	}
	public void setMemberPn(long pn) {
		Member.this.member_pn = pn;
	}



}
