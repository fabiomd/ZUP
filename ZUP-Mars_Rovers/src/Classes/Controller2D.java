package Classes;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

import java.util.ArrayList;

import Directions.*;

// Esta classe tem como objetivo controlar a posicao e direcao de um veiculo espacial

public class Controller2D {
	
	private SpaceVehicle spaceV;
	
	//Construtor da classe, recebe um veiculo espacial
	
	public Controller2D(SpaceVehicle spaceV){
		setSpaceV(spaceV);
	}
	
	public void SetMap(String map){
		String[] location = map.split(" ");
		try{
			getSpaceV().setMap(new Map(Integer.parseInt(location[0]),Integer.parseInt(location[1])));
		}catch(IndexOutOfBoundsException e){
			System.out.println(e + ": Formato de entrada incorreto");
		}catch(NullPointerException e){
			System.out.println(e + ": Falha ao inicializar mapa");
		}
	}
	//Funcao responsavel pela leitura dos comandos passados atravez de strings
	
	public void readCommands(ArrayList<String> commands){
		try{
			//Primeiramente colocamos o veiculo na posicao de inicio
			
			DeployCoordinates(commands.get(0));
			//Esse laco decide os comandos a serme feitos de acordo com o caracter lido
			for(int i=0;i<commands.get(1).length();i++){
				switch(commands.get(1).charAt(i)){
				case 'M':
					Move();
					break;
				case 'L':
					TurnLeft();
					break;
				case 'R':
					TurnRight();
					break;
				}
			}
			
		}catch(IndexOutOfBoundsException e){
			System.out.println(e + ": Formato de entrada incorreto");
		}catch(NullPointerException e){
			System.out.println(e + ": Falha ao inicializar posicao ou direcao");
		}
	}

	//Seta a posicao inicial no mapa
	private void DeployCoordinates(String position) throws IndexOutOfBoundsException,NullPointerException{
		String[] location = position.split(" ");
		getSpaceV().setCurrentPosition(new Point2D(Integer.parseInt(location[0]) ,Integer.parseInt(location[1])));
		switch(location[2]){
		case "N":
			getSpaceV().setDirectionFaced(new North());
			break;
		case "S":
			getSpaceV().setDirectionFaced(new South());
			break;
		case "W":
			getSpaceV().setDirectionFaced(new West());
			break;
		case "E":
			getSpaceV().setDirectionFaced(new East());
			break;
		}
	}
	
	//Move o veiculo de acordo com a direcao em que ele se encontra
	private void Move() throws NullPointerException{
		getSpaceV().setCurrentPosition(Point2D.SumPoints(getSpaceV().getCurrentPosition(), getSpaceV().getDirectionFaced().getInfluence()));;
	}
	
	//Faz um giro em +90º modificando a direcao conforme a direcao anterior a esquerda
	private void TurnLeft(){
		switch(getSpaceV().getDirectionFaced().getClass().getSimpleName()){
		case "North":
			getSpaceV().setDirectionFaced(new West());
			break;
		case "South":
			getSpaceV().setDirectionFaced(new East());
			break;
		case "West":
			getSpaceV().setDirectionFaced(new South());
			break;
		case "East":
			getSpaceV().setDirectionFaced(new North());
			break;
		}
	}
	
	//Faz um giro em -90º modificando a direcao conforme a direcao anterior a direita
	private void TurnRight(){
		switch(getSpaceV().getDirectionFaced().getClass().getSimpleName()){
		case "North":
			getSpaceV().setDirectionFaced(new East());
			break;
		case "South":
			getSpaceV().setDirectionFaced(new West());
			break;
		case "West":
			getSpaceV().setDirectionFaced(new North());
			break;
		case "East":
			getSpaceV().setDirectionFaced(new South());
			break;
		}
	}

	//Getters e Setters
	private SpaceVehicle getSpaceV() {
		return spaceV;
	}

	private void setSpaceV(SpaceVehicle spaceV) {
		this.spaceV = spaceV;
	}
}
