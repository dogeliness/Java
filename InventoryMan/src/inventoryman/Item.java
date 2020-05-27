package inventoryman;
/**
* The Item class is an abstract class that represents "Items" stored in the flat, i.e Books and Music. It has comparators to sort by creator, title or date of items. 
*/
import java.util.Comparator;
import java.util.regex.Pattern;

public abstract class Item {
	protected String title;
	protected String acqDate;
	protected String owner;
	protected String cost;
	protected String format;
	protected String creator;
	
	public Item(String itemCreator, String itemTitle, String acquisitionDateStr, String itemOwner, String itemCostStr, String itemFormatStr) throws ItemException {
		if (!Pattern.matches(Format.COST.toString(), itemCostStr)) {
			throw new ItemException("Your cost format is incorrect. It must have a $ followed by numbers, a . and 2 decimal places.");
		}
		
		if (!Pattern.matches(Format.DATE.toString(), acquisitionDateStr)) {
			throw new ItemException("Your date format is incorrect. It should be: YYYY-MM-DD");
			
		}
		creator = itemCreator;
		title = itemTitle;
		acqDate = acquisitionDateStr;
		owner = itemOwner;
		cost = itemCostStr;
		format = itemFormatStr;	
	}
	
	//These are used to sort the items by various factors
	public static Comparator<Item> sortByCreator = new Comparator<Item>() {
		
		@Override
		public int compare(Item item1, Item item2) {
			return item1.creator.compareTo(item2.creator);
		}
	}; 
	
	public static Comparator<Item> sortByTitle = new Comparator<Item>() {
		
		@Override
		public int compare(Item item1, Item item2) {
			return item1.title.compareTo(item2.title);
		}
	}; 
	
	public static Comparator<Item> sortByDateAcq = new Comparator<Item>() {
		@Override
		public int compare(Item item1, Item item2) {
			return item1.acqDate.compareTo(item2.acqDate);
		}
	};
	
	//This is to get the unique identifier for each item
	public String[] getItemIdentifier() {
		String[] identity = {creator, title, format};
		return identity;
	}
	
	//Extract the year out of the date
	public String yearAcq() {
		return acqDate.substring(0,4);
	}
	
	public String creatorName() {
		return creator;
	}
	
	//These are for the subclasses to implement, each has their own unique string
	public abstract String displayStr();
	
	public abstract String reportStr();
}
