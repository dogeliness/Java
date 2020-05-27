package spaceshapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Background {
	
	// === Constants for default values. ===
	protected static final int DEFAULT_HEIGHT = 100;
	protected static final int DEFAULT_WIDTH = 100;
	protected static final int DEFAULT_STAR_COUNT = 10;
	protected static final Color DEFAULT_STAR_COLOR = Color.black;
	
	// === Instance values. ===
	protected int _height;
	protected int _width;
	protected int _starCount;
	protected Color _starColor;
	
	// This array stores the "stars"
	ArrayList<OvalShape> stars = new ArrayList<OvalShape>();
	
	/**
	 * Creates a Background object with default values for instance variables.
	 */
	public Background() {
		_height = DEFAULT_HEIGHT;
		_width = DEFAULT_WIDTH;
		_starCount = DEFAULT_STAR_COUNT;
		setStars();
	}
	
	/**
	 * Creates a Background object with a specified height, width and star count.
	 */
	public Background(int height, int width, int stars) {
		_height = height;
		_width = width;
		_starCount = stars;
		setStars();
	}
	
	/**
	 * Create the "stars" for the background.
	 */
	public void setStars() {
		for (int i = 0; i < _starCount; i++) {
			//a random location for the star in the background
			int x = ThreadLocalRandom.current().nextInt(0, _width - 5);
			int y = ThreadLocalRandom.current().nextInt(0, _height - 5);
			stars.add(new OvalShape(x, y, 0, 0, 7, 7));
		}
	}
	
	/**
	 * Display the "stars" for the background.
	 */
	public void displayStars(Painter painter) {
		for (OvalShape shape : stars) {
			// Chance for the star to "blink"
			if (ThreadLocalRandom.current().nextInt(0, 150) < 2) {
				shape._blink = !shape._blink;
			}
			shape.paintBg(painter);
		}
	}
}
