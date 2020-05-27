package inventoryman;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class InventoryManImpl implements InventoryMan {
	
	private String flatName;
	private ArrayList<Music> allMusic = new ArrayList<Music>();
	private ArrayList<Book> allBooks = new ArrayList<Book>();
	private ArrayList<Item> allItems = new ArrayList<Item>();
	private ArrayList<Owner> allOwners = new ArrayList<Owner>();
	
	public InventoryManImpl(String fName) {
		flatName = fName;
	}
	
	public String addBook(String author, String title, String publicationYear, String publisher,
			String acquisitionDateStr, String owner, String costStr, String formatStr) {
		try {
			Book newBook = new Book(author, title, publicationYear, publisher, acquisitionDateStr, owner, costStr, formatStr);
			allBooks.add(newBook);
			
			//check if we need to create a new Owner object 
			boolean ownerExists = false;
			for (Owner person: allOwners) {
				//add book to Owner object if Owner already exists
				if (person.getName() == owner) {
					person.addBook(newBook);
					ownerExists = true;
				}
			}
			
			//if no such owner exists yet then create one and add the book to its owner
			if (!ownerExists) {
				Owner newOwner = new Owner(owner);
				allOwners.add(newOwner);
				newOwner.addBook(newBook);
			}
			
		} catch (Exception e) {
			//this exception occurs if there is an incorrect format, an ItemException is thrown
			return "ERROR: " + e.getMessage();
		}
		return "Success";
	}
	
	public String addMusic(String artist, String title, String releaseDateStr, String acquisitionDateStr, 
			String owner, String costStr, String formatStr) {
		try {
			Music newMusic = new Music(artist, title, releaseDateStr, acquisitionDateStr, owner, costStr, formatStr);
			allMusic.add(newMusic);
			
			//check if owner exists; if it does, add music to it. If it does not, create a new one. 
			boolean ownerExists = false;
			for (Owner person: allOwners) {
				if (person.getName() == owner) {
					person.addMusic(newMusic);
					ownerExists = true;
				}
			}
			//create new owner if no owner exists
			if (!ownerExists) {
				Owner newOwner = new Owner(owner);
				allOwners.add(newOwner);
				newOwner.addMusic(newMusic);
			}
			
		} catch (Exception e) {
			//error for incorrect format of date or cost
			return "ERROR: " + e.getMessage();
		}
		return "Success";
	}
	

	public String getItemToDisplay(String creator, String title, String formatStr) {
		try {
			//add all items to our ArrayList of items
			refreshItems();
			for (Item item: allItems) {
				//get creator, title and format of the item
				String[] details = item.getItemIdentifier();
				if (details[0].equals(creator) && details[1].equals(title) && details[2].equals(formatStr)) {
					return item.displayStr();
				}
			}
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
		
		return "exit";
	}
	
	public List<String> getAll(String order) {
		refreshItems();
		
		List<String> manyItems = new ArrayList<String>();
		
		//sort manyItems based on specified order
		if (order == "Creator") {
			Collections.sort(allItems, Item.sortByCreator);
		} else if (order == "Title") {
			Collections.sort(allItems, Item.sortByTitle);
		} else if (order == "Acquisition") {
			Collections.sort(allItems, Item.sortByDateAcq);
		} else {
			return null;
		}
		for (Item item: allItems) {
			//add all the displayStr of sorted items
			manyItems.add(item.displayStr());
		}
		
		return manyItems;
	}
	
	public List<String> getItemsAcquiredInYear(String year) {
		refreshItems();
		
		ArrayList<Item> itemInYear = new ArrayList<Item>();
		List<String> itemStr = new ArrayList<String>();
		
		//only get the items obtained in specified year
		for (Item item: allItems) {
			if (item.yearAcq().equals(year)) {
				itemInYear.add(item);
			}
		}
		
		//sort by date acquired
		Collections.sort(itemInYear, Item.sortByDateAcq);
		
		for (Item item: itemInYear) {
			itemStr.add(item.displayStr());
		}
		
		return itemStr;
	}
	
	public List<String> getCreators() {
		refreshItems();
		List<String> creators = new ArrayList<String>();
		
		//add unique creator names to the list
		for (Item item: allItems) {
			String creator = item.creatorName();
			if (!creators.contains(creator)) {
				creators.add(creator);
			}
		}
		//sort by creator name
		java.util.Collections.sort(creators);
		
		return creators;
	}
	
	
	
	public List<String> getFlatReport() {
		List<String> report = new ArrayList<String>();
		report.add(flatName);
		
		Collections.sort(allOwners, Owner.sortByOwner);
		
		//add in order of owner name
		for (Owner owner: allOwners) {
			//add all the owner's books to to the report
			for (String bookStr: owner.ownerBooks()) {
				report.add(bookStr);
			}
			//then add all the owner's music to the report
			for (String musicStr: owner.ownerMusic()) {
				report.add(musicStr);
			}	
		}
		
		return report;
	}
	
	public void refreshItems() {
		//add all items, needs to be done for each method requiring allItems it in case new items were added.
		allItems = new ArrayList<Item>();
		allItems.addAll(allMusic);
		allItems.addAll(allBooks);
	}
}
