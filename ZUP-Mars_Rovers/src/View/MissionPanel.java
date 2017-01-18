package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import Classes.Map;

@SuppressWarnings("serial")
public class MissionPanel extends JFrame{
	private Map map;
	
	public MissionPanel(Map map){
		setMap(map);
		setTitle("Map");
		setVisible(true);
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void paint(Graphics g){
		int linesize = 1;
		for(int i=0;i<map.getDimension().getX();i++){
			g.fillRect(getSize().width/map.getDimension().getX() * i, 0, linesize, getSize().height);
		}
		for(int i=0;i<map.getDimension().getY();i++){
			g.fillRect(0,getSize().width/map.getDimension().getX() * i,getSize().height,linesize);
		}
	}

	public Map getMap() {
		return map;
	}

	private void setMap(Map map) {
		this.map = map;
	}
}
