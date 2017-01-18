package View;
import javax.swing.JFrame;

import Classes.SpaceVehicle;

public class View {
	
	public View(SpaceVehicle spaceV){
		Grid grid = new Grid(spaceV.getMap());
        JFrame window = new JFrame();
        window.setSize(840, 560);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MAPA");
        window.add(grid);
        window.setVisible(true);
	}
}
