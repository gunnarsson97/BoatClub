package viewer;

import java.util.ArrayList;

import model.Boat;
import model.Member;

public class CompactVerboseView {
	public CompactVerboseView() {}
	//build up compactlist
	public void compactList(ArrayList <Member> list) {

		ArrayList<String> CompactList = new ArrayList<String>();
		for (int i=0; i<list.size();i++) {
			StringBuilder sb=new StringBuilder();
			sb.append("Name: "+list.get(i).getName());
			sb.append(", ");
			sb.append("ID: "+list.get(i).getId());
			sb.append(", ");
			sb.append("Number of boats: "+list.get(i).getNumberBoats());
			CompactList.add(sb.toString());
			System.out.println(sb.toString());
		}
	}
	//build up verboselist
	public void verboseList(ArrayList <Member> list) {
		ArrayList<String> verboseList = new ArrayList<String>();
		for (int i=0; i<list.size();i++) {
			StringBuilder sb=new StringBuilder();
			sb.append("Name: "+list.get(i).getName());
			sb.append(", ");
			sb.append("PersonalNumber: "+list.get(i).getPn());
			sb.append(", ");
			
			for (int y=0; y<list.get(i).getboatlist().size(); y++) {
				Boat b=(list.get(i).getboatlist().get(y));
				sb.append(" Boat "+(y+1)+"- Length: "+b.getLength()+" ID: "+b.getID()+" Type: "+b.getType());
			}
			
			verboseList.add(sb.toString());
			System.out.println(sb.toString());
		}
	}
}
