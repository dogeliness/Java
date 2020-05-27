package inventoryman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class is used to represent Owners in the flat. Owners their own unique Items, i.e Music and Books. 
 */
public class Owner {
	private String ownerName;
	private ArrayList<Music> myMusic = new ArrayList<Music>();
	private ArrayList<Book> myBooks = new ArrayList<Book>();
	
	public Owner(String name) {
		ownerName = name;
	}
	
	public static Comparator<Owner> sortByOwner = new Comparator<Owner>() {
		@Override
		public int compare(Owner o1, Owner o2) {
			return o1.ownerName.compareTo(o2.ownerName);
		}
	};
	
	public void addMusic(Music music) {
		myMusic.add(music);
	}
	
	public void addBook(Book book) {
		myBooks.add(book);
	}
	
	public String getName() {
		return ownerName;
	}

	
	//Return a List containing the specified Owner's Music collection, sorted by creator.
	public List<String> ownerMusic() {
		List<String> reportMusic = new ArrayList<String>();
		Collections.sort(myMusic, Item.sortByCreator);
		
		for (Music music: myMusic) {
			reportMusic.add(music.reportStr());
		}
		
		return reportMusic;
	}
	
	//Return a List containing the specified Owner's Book collection, sorted by creator.
	public List<String> ownerBooks() {
		List<String> reportBooks = new ArrayList<String>();
		Collections.sort(myBooks, Item.sortByCreator);
		
		for (Book book: myBooks) {
			reportBooks.add(book.reportStr());
		}
		
		return reportBooks;
	}
}
