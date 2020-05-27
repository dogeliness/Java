package spaceshapes;

import java.awt.Color;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	/**
	 * Logs the fillRect call.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_log.append("(rectangle filled " + x + "," + y + "," + width + "," + height + ")");
		
	}

	public Color getColor() {
		return null;
	}

	/**
	 * Logs the setColor call.
	 */
	public void setColor(Color c) {
		//Only log for custom colors, i.e not white or Shape's default
		if (c != Color.white && c != Shape.shapeColor) {
			_log.append("(color set: " + c.getRed() + "," + c.getGreen() + "," + c.getBlue() + ")");
		}
	}

	/**
	 * The following calls are not logged.
	 */
	public void translate(int x, int y) {
		
	}

	public void drawCentredText(String s, int x, int y, int width, int height) {
		
	}

	public void fillOval(int x, int y, int width, int height) {
		
	}
}