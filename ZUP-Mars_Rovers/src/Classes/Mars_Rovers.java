package Classes;

import Directions.Direction;

public class Mars_Rovers {

	private Controller2D controller = new Controller2D();
	private Position2D currentPosition = null;
	private Direction directionFaced = null;
	
	public Controller2D getController() {
		return controller;
	}
	public void setController(Controller2D controller) {
		this.controller = controller;
	}
	
	
	public Position2D getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Position2D currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
	public Direction getDirectionFaced() {
		return directionFaced;
	}
	public void setDirectionFaced(Direction directionFaced) {
		this.directionFaced = directionFaced;
	}
}
