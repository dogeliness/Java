package spaceshapes;

import java.awt.Color;

public class DynamicShape extends Shape {

	private Color color = Color.white;
	private boolean fill = false;
	/**
	 * Default constructor that creates a DynamicShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicShape() {
		super();
	}
	
	public DynamicShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color c) {
		super(x, y, deltaX, deltaY, width, height);
		color = c;
	}
	
	/**
	 * Use parent move method while also checking to fill/outline the shape.
	 */
	@Override
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		//Should the shape reach a "corner", it will only have a shape outline
		if ((nextX <= 0 || nextX + _width >= width) && (nextY <= 0 || nextY + _height >= height)) {
			fill = false;
		} else {
			if (nextX <= 0 || nextX + _width >= width) {
				fill = true;
			}

			if (nextY <= 0 || nextY + _height >= height) {
				fill = false;
			}
		}
		
		super.move(width, height);
	}
	
	public void paint(Painter painter) {
		if (painter.getColor() != color) {
			painter.setColor(color);
		}
		if (!fill) {
			painter.drawRect(_x,_y,_width,_height);
		} else {
			painter.fillRect(_x,_y,_width,_height);
		}
		
		//set back to "default" color for other shapes (212, 212, 212)
		painter.setColor(shapeColor);
		
		super.paint(painter);
	}
}
