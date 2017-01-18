package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import Classes.Map;

@SuppressWarnings("serial")
public class Grid extends JPanel{
	private Map map;

    public Grid(Map map) {
    	setMap(map);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int distBetweenLinesX = (int) (getSize().getWidth() / map.getDimension().getX());
        int distBetweenLinesY = (int) (getSize().getHeight() / map.getDimension().getY());
        
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 800, 500);

        for(int i = 0;i<getSize().getWidth();i++){
        	g.drawLine(distBetweenLinesX * i, 0, distBetweenLinesX*i, (int) getSize().getHeight());
        	g.drawLine(0,distBetweenLinesY * i, (int) getSize().getWidth(), distBetweenLinesY * i);
        }
    }

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
