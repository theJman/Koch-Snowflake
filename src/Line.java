import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class Line {
	private Point start;
	private Point end;
	/**
	 * Creates a line from one point to another
	 * @param startPoint
	 * @param endPoint
	 */
	public Line(Point startPoint, Point endPoint){
		start = startPoint;
		end = endPoint;
	}
	/**
	 * Draws the line of color c
	 * @param g graphics to use to draw
	 * @param c color to draw
	 */
	public void drawLine(Graphics g, Color c){
		g.setColor(c);
		g.drawLine(start.x, start.y, end.x, end.y);
	}
	/**
	 * Gets the length of the line
	 * @return length
	 */
	public double getLength(){
		return Math.sqrt(Math.pow(start.x-end.x, 2) + Math.pow(start.y-end.y, 2));
	}
	/**
	 * Gets the lines endpoint
	 * @return the endPoint
	 */
	public Point getEndPoint(){
		return end;
	}
	
	/**
	 * Calculates the endPoint of a line with a start point a length and an angle
	 * @param start
	 * @param length
	 * @param angle
	 * @return
	 */
	public static Point getEndPoint(Point start, int length, double angle){
		angle = Math.round(angle);
		angle = Math.toRadians(angle);
		double PI = Math.PI;
		double x=0,y=0;
		
		if (angle < 0) {
			angle += 2*PI;
		}
		if(angle <= PI/2){
			x = length * Math.cos(angle);
			y = length * Math.sin(angle);
		}
		else if(angle <= PI){
			angle -= PI/2;
			x = -1 * length * Math.sin(angle);
			y = length * Math.cos(angle);
		}
		else if(angle <= 3*PI/2){
			angle -= PI;
			x = -1 * length * Math.cos(angle);
			y = -1 * length * Math.sin(angle);
		}
		else if(angle <= 2 * PI){
			angle -= 3*PI/2;
			x = length * Math.sin(angle);
			y = -1 * length * Math.cos(angle);
		}
		
		return new Point(start.x + (int)x, start.y + (int)y);
	}
}
