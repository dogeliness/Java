package spaceshapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHexagonShape {

	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 * The height and width is set to be 60 in order to generate a regular hexagon.
	 */
	@Test
	public void testSimpleMove() {
		HexagonShape shape = new HexagonShape(100, 20, 1, 1, 60, 60);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 120,20,140,20)(line 140,20,160,50)(line 160,50,140,80)(line 140,80,120,80)"
				+ "(line 120,80,100,50)(line 100,50,120,20)(line 121,21,141,21)(line 141,21,161,51)"
				+ "(line 161,51,141,81)(line 141,81,121,81)(line 121,81,101,51)(line 101,51,121,21)", 
				_painter.toString());
	}
	
	/**
	 * Test to construct a small "hexagon" correctly (4-sided)
	 */
	@Test
	public void testSmallHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 5, 5, 30, 30);
		shape.paint(_painter);
		assertEquals("(line 115,50,100,35)(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)", _painter.toString());
	}
	
	/**
	 * Test to construct a regular hexagon correctly (6-sided)
	 */
	@Test
	public void testRegularHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 1, 1, 200, 200);
		shape.paint(_painter);
		assertEquals("(line 120,20,280,20)(line 280,20,300,120)(line 300,120,280,220)"
				+ "(line 280,220,120,220)(line 120,220,100,120)(line 100,120,120,20)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15, 80, 80);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 120,20,160,20)(line 160,20,180,60)(line 180,60,160,100)(line 160,100,120,100)"
				+ "(line 120,100,100,60)(line 100,60,120,20)(line 75,35,115,35)(line 115,35,135,75)"
				+ "(line 135,75,115,115)(line 115,115,75,115)(line 75,115,55,75)(line 55,75,75,35)"
				+ "(line 63,50,103,50)(line 103,50,123,90)(line 123,90,103,130)(line 103,130,63,130)"
				+ "(line 63,130,43,90)(line 43,90,63,50)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(10, 20, -12, 15, 80, 80);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 30,20,70,20)(line 70,20,90,60)(line 90,60,70,100)(line 70,100,30,100)"
				+ "(line 30,100,10,60)(line 10,60,30,20)(line 20,35,60,35)(line 60,35,80,75)"
				+ "(line 80,75,60,115)(line 60,115,20,115)(line 20,115,0,75)(line 0,75,20,35)"
				+ "(line 32,50,72,50)(line 72,50,92,90)(line 92,90,72,130)(line 72,130,32,130)"
				+ "(line 32,130,12,90)(line 12,90,32,50)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(10, 90, -12, 15, 80, 80);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 30,90,70,90)(line 70,90,90,130)(line 90,130,70,170)(line 70,170,30,170)"
				+ "(line 30,170,10,130)(line 10,130,30,90)(line 20,55,60,55)(line 60,55,80,95)"
				+ "(line 80,95,60,135)(line 60,135,20,135)(line 20,135,0,95)(line 0,95,20,55)"
				+ "(line 32,40,72,40)(line 72,40,92,80)(line 92,80,72,120)(line 72,120,32,120)"
				+ "(line 32,120,12,80)(line 12,80,32,40)", _painter.toString());
	}
}