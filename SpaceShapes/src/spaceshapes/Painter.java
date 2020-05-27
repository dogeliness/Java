package spaceshapes;

import java.awt.Color;
/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * rectangle. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	//public void drawRect(int _x, int _y, int _width, int _height, Color color, boolean fill);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a filled oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void fillOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Draws a filled rectangle. Parameters x and y specify the top left corner of the
	 * rectangle. Parameters width and height specify its width and height.
	 */
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Returns the Color of the shape.
	 */
	public Color getColor();
	
	/**
	 * Set the Color of the shape.
	 */
	public void setColor(Color c);
	
	/**
	 * Translate the coordinate system to new origin specified by x and y.
	 */
	public void translate(int x, int y);
	
	/**
	 * Display text. Calculates placement of text based on 
	 */
	public void drawCentredText(String s, int x, int y, int width, int height);
	
}
