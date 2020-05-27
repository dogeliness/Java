package spaceshapes;

import java.util.ArrayList;
import java.util.List;

public class CarrierShape extends Shape {

	//This list stores the CarrierShape's children shapes
	protected List<Shape> subShapes = new ArrayList<Shape>();
	
	/**
	 * Creates a CarrierShape object with default values for state.
	 */
	public CarrierShape() {
		super();
	}
	
	/**
	 * Creates a CarrierShape object with specified location values and default values for other states.
	 */
	public CarrierShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a CarrierShape object with specified values for location, velocity and direction, default values for other states.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	/**
	 * Creates a CarrierShape object with Creates a CarrierShape object with specified values for location, velocity, direction, width and height.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	/**
	 * Moves a CarrierShape object (including its children) within the bounds specified by arguments width and height.
	 */
	@Override
	public void move(int width, int height) {
		super.move(width, height);
		for (Shape shape : subShapes) {			
			shape.move(_width, _height);
		}
	}
	
	/**
	 * Paints a CarrierShape object by drawing a rectangle around its bounding box.
	 * The CarrierShape object's children are then painted.
	 */
	public void paint(Painter painter) {
		painter.drawRect(_x,_y,_width,_height);
		painter.translate(_x,  _y);
		for (Shape shape : subShapes) {
			shape.paint(painter);
		}
		painter.translate(-_x, -_y);
		
		super.paint(painter);
	}
	
	/**
	 * Adds a Shape to a CarrierShape object. If successful, a two-way link is established between CarrierShape 
	 * and the added Shape object.
	 * @param shape the shape to be added
	 * @throws IllegalArgumentException if trying to add a Shape to a CarrierShape where the Shape is already a child within a CarrierShape instance.
	 * Also thrown when a Shape does not fit in the bounds of the CarrierShape object.
	 */
	void add(Shape shape) throws IllegalArgumentException {
			if (shape.x() < this._x || shape.x() + shape.width() > _x + _width || shape.y() < _y || shape.y() + shape.height() > _y + _height) {
				throw new IllegalArgumentException();
			} else if (parentShape != null) {
				throw new IllegalArgumentException();
			} else {
				subShapes.add(shape);
				shape.parentShape = this;
			}
	}
	
	/**
	 * Removes a particular Shape from a CarrierShape instance. Once removed, the two-way link is destroyed.
	 * This method has no effect if the Shape specified is not a child of the CarrierShape.
	 * @param shape the shape to be removed.
	 */
	void remove(Shape shape) {
		for (Shape child : subShapes) {
			if (child.equals(shape)) {
				subShapes.remove(child);
				child.parentShape = null;
				break;
			}
		}
	}
	
	/**
	 * Return the Shape at a specified position within a CarrierShape. An exception is thrown if index is out of bounds.
	 * @param index the specified index position.
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		return subShapes.get(index);
	}

	/**
	 * Returns the number of children within a CarrierShape object.
	 */
	public int shapeCount() {
		return subShapes.size();
	}
	
	/**
	 * Returns the index of a specified child within a CarrierShape object. 
	 * If the shape is not a child, returns -1; otherwise returns index.
	 * @param shape the shape whose index is requested.
	 */
	public int indexOf(Shape shape) {
		return subShapes.indexOf(shape);
	}
	
	/**
	 * Returns true if the Shape argument is a child of the CarrierShape
	 * object where this method is called, otherwise false.
	 */
	public boolean contains(Shape shape) {
		if (subShapes.indexOf(shape) != -1) {
			return true;
		} else {
			return false;
		}
	}
}
