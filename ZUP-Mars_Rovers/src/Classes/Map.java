package Classes;
/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Classe que representa uma Mapa em duas dimensoes, onde o seu tamanho é passado pelo construtor
public class Map {
	
	private Point2D dimension;
	
	//Construtor da classe
	public Map(int x,int y){
		setDimension(new Point2D(x,y));
	}

	//Funcao para validar se um dado ponto pertence ou nao ha area do mapa
	public boolean ValidePosition(Point2D position){
		return position.getX() <= getDimension().getX() &&  position.getY() <= getDimension().getY();
	}
	
	//Getters e Setters
	public Point2D getDimension() {
		return dimension;
	}

	private void setDimension(Point2D dimension) {
		this.dimension = dimension;
	}
}
