package Classes;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Classe contendo metodo Main

import java.util.ArrayList;

import View.View;


public class Principal {
	public static void main(String[] args) {
		
		SpaceVehicle Mars_Rovers = new SpaceVehicle();
		ArrayList<String> entrace = new ArrayList<String>();
		
		entrace.add("1 2 N");
		entrace.add("LMLMLMLMM");
		Mars_Rovers.mapCommand("5 5");
		Mars_Rovers.Contact(entrace);
		entrace = new ArrayList<String>();
		entrace.add("3 3 E");
		entrace.add("MMRMMRMRRM");
		Mars_Rovers.Contact(entrace);
		View view  = new View(Mars_Rovers);
	}
}
