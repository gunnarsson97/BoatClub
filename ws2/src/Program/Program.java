package Program;

import model.Methods;

public class Program {

	public static void main(String[] args){
		controller.ControllerMain c = new controller.ControllerMain();
		viewer.Console con = new viewer.Console();
		Methods met = new Methods();
		while(c.start(con,met));
		
	}

}
