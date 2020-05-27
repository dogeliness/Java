package spaceshapes;

public class HexagonShape extends Shape {
	/**
	 * Default constructor that creates a HexagonShape instance whose instance
	 * variables are set to default values.
	 */
	public HexagonShape() {
		super();
	}
	 
	public HexagonShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a HexagonShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance 
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
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	/**
	 * Paints this HexagonShape object using the supplied Painter object.
	 */
	public void paint(Painter painter) {
		if (_width < 40) {
			painter.drawLine(_x + _width/2, _y + _height, _x, _y + _height/2);
			painter.drawLine(_x, _y + _height/2, _x + _width/2, _y);
			painter.drawLine(_x + _width/2, _y, _x + _width, _y + _height/2);
			painter.drawLine(_x + _width, _y + _height/2, _x + _width/2, _y + _height);
		
		} else {
			painter.drawLine(_x + 20,_y, _x + _width - 20, _y);
			painter.drawLine(_x + _width - 20, _y, _x + _width, _y + _height/2);
			painter.drawLine(_x + _width, _y + _height/2, _x + _width - 20, _y + _height);
			painter.drawLine(_x + _width - 20, _y + _height, _x + 20, _y + _height);
			painter.drawLine(_x + 20, _y + _height, _x, _y + _height/2);
			painter.drawLine(_x, _y + _height/2, _x + 20,_y);
		}
		super.paint(painter);
	}
}