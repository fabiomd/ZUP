package Classes;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Classe contendo metodo Main

import java.util.ArrayList;
import java.util.Scanner;

import View.View;

//Deve se passar inicialmente o tamanho do mapa
//Dentro do laco sera pedido a posicao inicial e a sequencia de comandos

public class Principal {
	public static void main(String[] args) {
		
		SpaceVehicle Mars_Rovers = new SpaceVehicle();
		ArrayList<String> entrace = new ArrayList<String>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o tamanho do mapa: ");
		Mars_Rovers.mapCommand(scanner.nextLine());
		View view  = new View(Mars_Rovers);
		view.setVisible(true);

		String text = "";
		while(true){
			System.out.print("Posicao Inicial: ");
			text = scanner.nextLine();
			if(text.equals("EXIT") || text.equals(""))
				break;
			entrace.add(text.toUpperCase());
			System.out.print("Commando: ");
			text = scanner.nextLine();
			if(text.equals("EXIT") || text.equals(""))
				break;
			entrace.add(text.toUpperCase());
			Mars_Rovers.Contact(entrace);
			entrace = new ArrayList<String>();
		}
	}
}
