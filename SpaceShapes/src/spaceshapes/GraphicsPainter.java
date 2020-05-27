package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		//set to default color to draw outline
		_g.setColor(new Color(212, 212, 212));
		_g.drawRect(x, y, width, height);
	}
	
	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}
	
	/**
	 * @see spaceshapes.Painter.fillOval
	 */
	public void fillOval(int x, int y, int width, int height) {
		_g.fillOval(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * @see spaceshapes.Painter.fillRect.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_g.setColor(_g.getColor());
		_g.fillRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.getColor.
	 */
	public Color getColor() {
		return _g.getColor();
		
	}

	/**
	 * @see spaceshapes.Painter.setColor.
	 */
	public void setColor(Color c) {
		_g.setColor(c);
	}
	
	/**
	 * @see spaceshapes.Painter.translate.
	 */
	public void translate(int x, int y) {
		_g.translate(x, y);
	}
	
	/**
	 * @see spaceshapes.Painter.displayText.
	 */
	public void drawCentredText(String str, int x, int y, int width, int height) {
	    FontMetrics fm = _g.getFontMetrics();
        int x1 = x + (width - fm.stringWidth(str)) / 2;
        int y1 = y + height/2;
        if (fm.getAscent() > fm.getDescent()) {
        	y1 += (fm.getAscent() - fm.getDescent()) / 2;
        } else if (fm.getAscent() < fm.getDescent()) {
        	y1 -= (fm.getAscent() - fm.getDescent()) / 2;
        }
        
        
		_g.drawString(str, x1, y1);
	}
}
