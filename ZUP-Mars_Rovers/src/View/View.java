package View;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */


//Expecificacoes da janela com mapa, tamanho e componentes

import Classes.Event;
import Classes.SpaceVehicle;

public class View {
	private JFrame window;
	private Grid grid;
	
	public View(SpaceVehicle spaceV){
		setGrid(new Grid(spaceV));
		spaceV.setEvent(new Event(this));
		setWindow(new JFrame());
		getWindow().setSize(840, 560);
		getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getWindow().setResizable(false);
		getWindow().setTitle("MAPA");
		getWindow().add(getGrid());
	}

	public void UpdateScene(){
		getGrid().Update();
	}
	
	public void setVisible(boolean visible){
		getWindow().setVisible(visible);
	}
	
	public JFrame getWindow() {
		return window;
	}

	private void setWindow(JFrame window) {
		this.window = window;
	}

	public Grid getGrid() {
		return grid;
	}

	private void setGrid(Grid grid) {
		this.grid = grid;
	}
}
