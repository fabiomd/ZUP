package Classes;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Essa classe define o que um veiculo espacial necessita
//Todo veiculo deve possuir um Controller2D
//Sua posicao atual
//A direcao que esta observando
//E o mapa da regiao em sua volta

import java.util.ArrayList;

import Directions.Direction2D;

public class SpaceVehicle {

	private Controller2D controller = new Controller2D(this);
	private Point2D currentPosition = null;
	private Direction2D directionFaced = null;
	private Map map = null;
	private Event event = null;
	
	//Funcao para setar as dimensao do map, passada por string
	public void mapCommand(String command){
		controller.SetMap(command);
	}
	
	//Funcao por onde os comandos deve ser passado com intuito de controlar o veiculo
	public void Contact(ArrayList<String> commands){
		getController().readCommands(commands);
		try{
			getCurrentPosition().Print();
			System.out.print(" ");
			getDirectionFaced().Print();
			System.out.println("");
		}catch(NullPointerException e){
			System.out.println(e + ": Falha ao inicializar posicao ou direcao");
		}
	}
	
	
	//Getters e Setters
	public Controller2D getController() {
		return controller;
	}
	public void setController(Controller2D controller) {
		this.controller = controller;
	}
	
	
	public Point2D getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Point2D currentPosition) {
		if(map.ValidePosition(currentPosition)){
			this.currentPosition = currentPosition;
			if(getEvent()!=null)
				getEvent().Action();
		}
	}
	
	
	public Direction2D getDirectionFaced() {
		return directionFaced;
	}
	public void setDirectionFaced(Direction2D directionFaced) {
		this.directionFaced = directionFaced;
		if(getEvent()!=null)
			getEvent().Action();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
