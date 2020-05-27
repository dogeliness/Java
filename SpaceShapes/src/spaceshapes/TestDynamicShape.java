package spaceshapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicShape {

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
	 */
	@Test
	public void testSimpleMove() {
		DynamicShape shape = new DynamicShape(100, 20, 1, 1, 60, 60);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,60,60)(rectangle 101,21,60,60)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct, and that the shape is filled correctly.
	 */
	@Test
	public void testShapeMoveWithBounceOffRightAndFill() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle filled 110,35,25,35)"
				+ "(rectangle filled 98,50,25,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct, and that the shape is filled correctly.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeftAndFill() {
		DynamicShape shape = new DynamicShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle filled 0,35,25,35)"
				+ "(rectangle filled 12,50,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTop() {
		DynamicShape shape = new DynamicShape(10, 10, 12, -15);
		shape.paint(_painter);
		shape.move(10000, 200);
		shape.paint(_painter);
		shape.move(10000, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,25,35)(rectangle 22,0,25,35)"
				+ "(rectangle 34,15,25,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottom() {
		DynamicShape shape = new DynamicShape(30, 30, 5, 15);
		shape.paint(_painter);
		shape.move(10000, 40);
		shape.paint(_painter);
		shape.move(10000, 40);
		shape.paint(_painter);
		assertEquals("(rectangle 30,30,25,35)(rectangle 35,5,25,35)"
				+ "(rectangle 40,0,25,35)", _painter.toString());
	}

	//For these tests, bouncing off a right/left wall has lesser priority than bouncing off bottom/top walls.
	//E.G should it bounce off a top and right wall simultaneously, it will be unfilled. 
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(140, 140, 20, 20, 50, 50);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 140,140,50,50)(rectangle 150,150,50,50)"
				+ "(rectangle 130,130,50,50)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		DynamicShape shape = new DynamicShape(60, 140, -70, 20, 50, 50);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 60,140,50,50)(rectangle 0,150,50,50)"
				+ "(rectangle 70,130,50,50)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top right corner and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndRight() {
		DynamicShape shape = new DynamicShape(140, 20, 20, -30, 50, 50);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 140,20,50,50)(rectangle 150,0,50,50)"
				+ "(rectangle 130,30,50,50)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top left corner and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndLeft() {
		DynamicShape shape = new DynamicShape(20, 20, -30, -30, 50, 50);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 20,20,50,50)(rectangle 0,0,50,50)"
				+ "(rectangle 30,30,50,50)", _painter.toString());
	}

	//The following tests are to test a bounce off 2 walls, NOT simultaneously as in a "corner".
	//E.G bounces off bottom THEN right, not bottom AND right.
	/**
	 * Test to perform a bounce movement off the right then bottom wall and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffRightThenBottom() {
		DynamicShape shape = new DynamicShape(140, 140, 20, 8, 50, 50);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 140,140,50,50)(rectangle filled 150,148,50,50)"
				+ "(rectangle 130,150,50,50)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left then bottom wall and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffLeftThenBottom() {
		DynamicShape shape = new DynamicShape(60, 140, -70, 20, 40, 30);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 60,140,40,30)(rectangle filled 0,160,40,30)"
				+ "(rectangle 70,170,40,30)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right then top wall and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffRightThenTop() {
		DynamicShape shape = new DynamicShape(170, 25, 12, -15);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 170,25,25,35)(rectangle filled 175,10,25,35)"
				+ "(rectangle 163,0,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the left then top wall and to
	 * ensure that the Shape's position after the movement is correct and is filled correctly
	 */
	@Test
	public void testShapeMoveWithBounceOffLeftThenTop() {
		DynamicShape shape = new DynamicShape(10, 20, -12, -15);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle filled 0,5,25,35)"
				+ "(rectangle 12,0,25,35)", _painter.toString());
	}
	
	/**
	 * Test whether a custom color is correctly set
	 */
	@Test
	public void testColorSet() {
		DynamicShape shape = new DynamicShape(10, 10, 2, 2, 30, 30, Color.magenta);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		System.out.println(_painter.toString());
		assertEquals("(color set: 255,0,255)(rectangle 10,10,30,30)"
				+ "(color set: 255,0,255)(rectangle 12,12,30,30)", _painter.toString());
	}
}
