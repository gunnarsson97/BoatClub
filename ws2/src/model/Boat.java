package model;

public class Boat {

	
	private BoatType.Types boat_type;
	private int boat_length;
	private int boat_id;
	
	public Boat(int length, BoatType.Types type,int id) {
		Boat.this.boat_length = length;
		Boat.this.boat_type = type;
		Boat.this.boat_id = id;
	}
	public int getID() {
		return Boat.this.boat_id;
	}
	public int getLength() {
		return Boat.this.boat_length;
	}
	public BoatType.Types getType() {
		return Boat.this.boat_type;
	}
	public void setLength(int l) {
		Boat.this.boat_length=l;
	}
	public void setType(BoatType.Types t) {
		Boat.this.boat_type=t;
	}
}
