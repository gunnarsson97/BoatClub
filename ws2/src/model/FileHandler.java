package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	String path;
	public FileHandler(String filePath) {
		path = filePath;
	}

	//save all members and boats in file
	public void saveChanges(ArrayList <Member> list) {
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			for(int i=0; i<list.size(); i++) {
				StringBuilder sb = new StringBuilder();
				Member member = list.get(i);
				sb.append(member.getName()+",");
				sb.append(member.getPn()+",");
				sb.append(member.getId());
				
				for(int j=0; j<member.getboatlist().size(); j++) {
					Boat b = member.getboatlist().get(j);
					sb.append(",0,");
					sb.append(b.getID()+",");
					sb.append(b.getType()+",");
					sb.append(b.getLength());	
				}
	
				pw.println(sb.toString());
						
				}
			pw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
			
			
	}
	int flag=0;
	public void readFile(Methods met) {
		try {
			File file = new File(path);
			Scanner scan = new Scanner(file);
			ArrayList <String> list = new ArrayList<String>();
			while(scan.hasNextLine()){
				list.add(scan.nextLine());
			}

			if(file.length()!=0) {
				loadFile(list,met);
			}
		
			
			
		}catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void loadFile(ArrayList <String> list,Methods met) {
		ArrayList <String> list_2 = list;
		//loop trouhg all members
		int counter=0;
		for(int i=0; i<list_2.size(); i++) {
			String[] temp = list_2.get(i).split(",");
			int id = Integer.parseInt(temp[2]);
			long pn = Long.parseLong(temp[1]);
			Member member = new Member(temp[0],pn,id);	
			if(Integer.parseInt(member.getId())>counter) {
				counter = Integer.parseInt(member.getId())+1;
			}
			//check if we have boats and pich out there onfo
			if(temp.length>=3) {
				for(int j=3; j<temp.length; j=j+4) {
					if(Integer.parseInt(temp[j])==0) {
						int id2 = Integer.parseInt(temp[j+1]);
						BoatType.Types type = BoatType.Types.valueOf(temp[j+2]);
						int length = Integer.parseInt(temp[j+3]);
						Boat b = new Boat(length,type,id2);
						member.addBoat(b);
						if(b.getID()>counter) {
							counter = b.getID()+1;
						}
					}
				}
			}
			met.addMember(member);
		}
		met.setIdCounter(counter);
	}
}
