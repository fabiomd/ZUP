package View;

/*
 * Author: Fábio Moreira Duarte
 * Date : 01/18/2017
 * */

//Responsavel pela arquitetura do mapa, o tracado das linhas e desenho do veiculo

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Classes.Map;
import Classes.SpaceVehicle;

@SuppressWarnings("serial")
public class Grid extends JPanel{
	private Map map;
	private Image Image;
	private ImageIcon robot;
	private int distBetweenLinesX;
	private int distBetweenLinesY;
	private int correctionX;
	private int correctionY;
	private SpaceVehicle spaceV;
	
    public Grid(SpaceVehicle spaceV) {
    	setSpaceV(spaceV);
    	setMap(getSpaceV().getMap());
    	setRobot(new ImageIcon("Robot.png"));
    	setImage(robot.getImage());
    }
    
    //Essa é uma funcao abstrata nativa do JPanel que quando chamada desenha os comandos nela contido
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        distBetweenLinesX = (int) (getSize().getWidth() / map.getDimension().getX());
        distBetweenLinesY = (int) (getSize().getHeight() / map.getDimension().getY());
        correctionX = (int)(distBetweenLinesX*.5f);
        correctionY = (int)(distBetweenLinesY*.5f);
      
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 800, 500);

        for(int i = 0;i<getSize().getWidth();i++){
        	g.drawLine(distBetweenLinesX * i, 0, distBetweenLinesX*i, (int) getSize().getHeight());
        	g.drawLine(0,distBetweenLinesY * i, (int) getSize().getWidth(), distBetweenLinesY * i);
        }
        DrawRobot(g,getSpaceV().getCurrentPosition().getX(),getSpaceV().getMap().getDimension().getY() - getSpaceV().getCurrentPosition().getY());
    }

    //Tem como objetivo atualizar a image atual do robo, para causar efeito de rotacao
    public void Update(){
    	if(getSpaceV().getDirectionFaced()!=null){
    		switch(getSpaceV().getDirectionFaced().getClass().getSimpleName()){
    		case "North":
    			setRobot(new ImageIcon("RobotN.png"));
    			setImage(robot.getImage());
    			break;
    		case "West":
    			setRobot(new ImageIcon("RobotW.png"));
    			setImage(robot.getImage());
    			break;
    		case "South":
    			setRobot(new ImageIcon("RobotS.png"));
    			setImage(robot.getImage());
    			break;
    		case "East":
    			setRobot(new ImageIcon("RobotE.png"));
    			setImage(robot.getImage());
    			break;
    		}
    	}
    	//Repaint uma funcao nativa do JPanel ira chamar novamente paintComponent, assim redesenhando na janela
    	repaint();
    }
    
    //Desenha a image atual do robo nas coordenadas passadas com calculo da correcao
    
    public void DrawRobot(Graphics g,int x,int y){
    	g.drawImage(Image, x * distBetweenLinesX + correctionX/2, y * distBetweenLinesY + correctionY/2, distBetweenLinesX - correctionX, distBetweenLinesY - correctionY, null);
    }
    
    //Getters e Setters
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

	public SpaceVehicle getSpaceV() {
		return spaceV;
	}

	public void setSpaceV(SpaceVehicle spaceV) {
		this.spaceV = spaceV;
	}

}
