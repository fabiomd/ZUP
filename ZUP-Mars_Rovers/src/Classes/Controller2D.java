package Classes;

import java.util.ArrayList;

import Directions.Direction;

public class Controller2D {
	
	public Controller2D(){
	}
	
	public void readCommands(ArrayList<String> commands){
		try{
			StartPosition(commands.get(0));
		}catch(NullPointerException e){
			
		}
	}
	
	public void StartPosition(String position){
		position.split(" ");
	}
}
