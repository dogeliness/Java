package inventoryman;

import java.util.regex.Pattern;

/**
 * Book represents books in a flat. It has methods to return 2 formatted strings.
 */
public class Book extends Item {
	private String publicationYear;
	private String publisher;
	
	public Book(String bookAuthor, String title, String bookPublicationYear, String bookPublisher, String acquisitionDateStr, String owner, String costStr, String formatStr) throws ItemException {
		super(bookAuthor, title, acquisitionDateStr, owner, costStr, formatStr);
		if (!Pattern.matches(Format.YEAR.toString(), bookPublicationYear)) {
			throw new ItemException("Your year format is incorrect. It should be: YYYY");
		}
		publicationYear = bookPublicationYear;
		publisher = bookPublisher;
	}
	
	public String displayStr() {
		return creator + ", '" + title + "'. (" + publicationYear + ", " + publisher + "). [" + format + ", " + owner + ", " + acqDate + ", " + cost + "]";
	}
	
	public String reportStr() {
		return owner + ": " + creator + ", '" + title + "'. (" + format + ")";
	}
}
