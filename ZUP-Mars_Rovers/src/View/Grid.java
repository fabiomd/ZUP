package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Classes.Map;

@SuppressWarnings("serial")
public class Grid extends JPanel{
	private Map map;
	private Image Image;
	private ImageIcon robot;
    private boolean test = true;
	private int distBetweenLinesX;
	private int distBetweenLinesY;
	private int correctionX;
	private int correctionY;
    
    
    public Grid(Map map) {
    	setMap(map);
    	setRobot(new ImageIcon("Robot.png"));
    	setImage(robot.getImage());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        distBetweenLinesX = (int) (getSize().getWidth() / map.getDimension().getX());
        distBetweenLinesY = (int) (getSize().getHeight() / map.getDimension().getY());
        correctionX = (int)(distBetweenLinesX*.3f);
        correctionY = (int)(distBetweenLinesY*.3f);
      
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 800, 500);

        for(int i = 0;i<getSize().getWidth();i++){
        	g.drawLine(distBetweenLinesX * i, 0, distBetweenLinesX*i, (int) getSize().getHeight());
        	g.drawLine(0,distBetweenLinesY * i, (int) getSize().getWidth(), distBetweenLinesY * i);
        }
        if(test)
        	DrawRobot(g,0,0);
        test = false;
    }

    public void EraseRobot(Graphics g, int x,int y){
        g.clearRect(correctionX/2, correctionY/2, distBetweenLinesX - correctionX, distBetweenLinesY - correctionY);
    }
    
    public void DrawRobot(Graphics g,int x,int y){
    	g.drawImage(Image, correctionX/2, correctionY/2, distBetweenLinesX - correctionX, distBetweenLinesY - correctionY, null);
    }
    
	public Map getMap() {
		return map;
	}

	private void setMap(Map map) {
		this.map = map;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	public ImageIcon getRobot() {
		return robot;
	}

	public void setRobot(ImageIcon robot) {
		this.robot = robot;
	}

	public int getDistBetweenLinesX() {
		return distBetweenLinesX;
	}

	public void setDistBetweenLinesX(int distBetweenLinesX) {
		this.distBetweenLinesX = distBetweenLinesX;
	}

	public int getDistBetweenLinesY() {
		return distBetweenLinesY;
	}

	public void setDistBetweenLinesY(int distBetweenLinesY) {
		this.distBetweenLinesY = distBetweenLinesY;
	}

	public int getCorrectionX() {
		return correctionX;
	}

	public void setCorrectionX(int correctionX) {
		this.correctionX = correctionX;
	}

	public int getCorrectionY() {
		return correctionY;
	}

	public void setCorrectionY(int correctionY) {
		this.correctionY = correctionY;
	}

}
