package Directions;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

import Classes.Point2D;

// Abstracao de uma dimensao 2D, ou seja com apenas 2 eixos, X e Y

public abstract class Direction2D {
	
	//Influence representao a direcao apontada
	protected Point2D Influence;
	
	//Construtor da classe recebe dois inteiros com o valor da influencia
	public Direction2D(int x,int y){
		this.Influence = new Point2D(x,y);
	}
	
	public Point2D getInfluence(){
		return this.Influence;
	}
	
	public void Print(){
		System.out.print(this.getClass().getSimpleName().toUpperCase().charAt(0));
	}
}
