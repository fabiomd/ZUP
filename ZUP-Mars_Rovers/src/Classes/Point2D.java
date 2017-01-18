package Classes;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Classe representando um Ponto em um universo 2D com apenas 2 eixos X e Y

public class Point2D {
	
	private int x,y;

	//Construtor da classe 
	public Point2D(int x,int y){
		setX(x);
		setY(y);
	}
	
	//Funcao estatica com intuito de somar dois pontos
	public static Point2D SumPoints(Point2D P1,Point2D P2){
		return new Point2D(P1.getX() + P2.getX(),P1.getY() + P2.getY());
	}
	
	//Getters e Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void Print(){
		System.out.print(getX() + " " +getY());
	}
}
