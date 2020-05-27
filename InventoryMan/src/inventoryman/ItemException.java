package inventoryman;

/**
 * This exception is thrown for incorrect formatting (date, cost) when creating a new item.
 */
@SuppressWarnings("serial")
public class ItemException extends Exception {

	public ItemException(String message) {
		super(message);
	}
	
	
}
