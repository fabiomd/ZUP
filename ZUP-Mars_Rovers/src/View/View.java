package View;
import javax.swing.JFrame;

import Classes.Map;

public class View {
	
	public View(Map map){
		Grid grid = new Grid(map);
        JFrame window = new JFrame();
        window.setSize(840, 560);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(grid);
        window.setVisible(true);
	}
}
