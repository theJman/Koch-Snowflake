import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class SnowflakePanel extends JPanel {

	private static final long serialVersionUID = 652595433849215786L;
	private final double PI = Math.PI;
	private final int initialSideLength = 300;
	//default order
	private int order = 0;
	//amount of side left to draw
	private int amountOfSides = 0;
	//length of the sides
	private int lineLength = 0;
	//cluster line length
	private int clusterLineLength = 0;
	//on off value to determine which way to turn with the next cluster
	private boolean switcher = true;
	
	/**
	 * Creates the panel and sets it's visibility
	 */
	public SnowflakePanel(){
		setVisible(true);
	}
	
	/**
	 * Sets the order and calculates values osing the order and these equations
	 * // 3*4^n amount of sides after iteration
	 * // s/(3^n) length of sides
	 * @param order amount of iterations(up to 2)
	 */
	public void setOrder(int order){
		
		this.order = order;
		
		if (order == 0) {
			//clear window
			super.paintComponent(getGraphics());
			//draw triangle
			int[] xPoints = {getWidth()/2,getWidth()/2-initialSideLength/2,getWidth()/2+initialSideLength/2};
			int[] yPoints = {70, (int)(70+initialSideLength*Math.sin(d2r(60))), (int)(70+initialSideLength*Math.sin(d2r(60)))};
			
			getGraphics().drawPolygon(xPoints, yPoints, 3);
			return;
		}
		amountOfSides =(int) (3 * Math.pow(4, order));
		lineLength = (int)Math.round((initialSideLength / Math.pow(3, order)));
		clusterLineLength =(int)( 2*lineLength + 2*lineLength*Math.cos(PI/3));
		System.out.println("Amount of sides: "+amountOfSides+".\nLine Length: "+lineLength+".");
		paintComponent(getGraphics());
	}
	/**
	 * Paints the Kock SnowFlake
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Point start = new Point(getWidth()/2, 70);
		drawLineCluster(g, start, Line.getEndPoint(start, clusterLineLength, 60));
	}
	
	/**
	 * Recursivly draws a Kock Snowflake useing clusters of 4 lines
	 * @param g graphics to use to draw
	 * @param start start point of cluster
	 * @param end end point of cluster
	 */
	private void drawLineCluster(Graphics g, Point start, Point end){
		
		amountOfSides -= 4;
		if (amountOfSides < 0) {
			return;
		}
		double angle = Math.toDegrees(Math.atan2(end.y-start.y, end.x-start.x));
		if(angle<0)
			angle += 360;
		//create 4 lines 
		Line l1,l2,l3,l4;
		l1 = new Line(start, Line.getEndPoint(start, lineLength,  Math.round(angle)));
		Point tempStartPoint;
		double l2Angle = angle-60;
		if(l2Angle < 0)l2Angle+=360;
		tempStartPoint = l1.getEndPoint();
		l2 = new Line(tempStartPoint, Line.getEndPoint(tempStartPoint, lineLength,  Math.round(l2Angle)));
		
		double l3Angle = angle+60;
		if(l3Angle < 0)l3Angle+=360;
		tempStartPoint = l2.getEndPoint();
		l3 = new Line(tempStartPoint, Line.getEndPoint(tempStartPoint, lineLength, Math.round(l3Angle)));
		
		double l4Angle = angle;
		if(l4Angle < 0)l4Angle+=360;		
		tempStartPoint = l3.getEndPoint();
		l4 = new Line(tempStartPoint, Line.getEndPoint(tempStartPoint, lineLength,  Math.round(l4Angle)));
		//testline
		//g.setColor(Color.red);
		//g.drawLine(start.x, start.y, end.x, end.y);
		//draw 4 lines
		l1.drawLine(g, Color.black);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l2.drawLine(g, Color.black);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l3.drawLine(g, Color.black);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l4.drawLine(g, Color.black);
		

		if (order == 1) {
			drawLineCluster(g, end, Line.getEndPoint(end, clusterLineLength, angle + 120));				
		}
		else if (order == 2){
			if (switcher) {
				switcher = false;
				Point endPoint = Line.getEndPoint(end, clusterLineLength, angle -60 );
				drawLineCluster(g, end, endPoint);
			} else {
				switcher = true;
				Point endPoint = Line.getEndPoint(end, clusterLineLength, angle + 120 );
				drawLineCluster(g, end, endPoint);
			}
		}
		
	}
	/**
	 * Shorter then Math.toRadians
	 * @param deg degrees
	 * @return radians
	 */
	private double d2r(double deg){
		return Math.toRadians(deg);
	}
	
}






