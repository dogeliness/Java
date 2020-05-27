package inventoryman;

import java.util.regex.Pattern;

/**
 * Music class represents music items in a flat. It has methods to return 2 formatted strings.
 */
public class Music extends Item {
	private String releaseDate;
	
	
	public Music(String musicArtist, String title, String musicReleaseDate, String acquisitionDateStr, 
			String owner, String costStr, String formatStr) throws ItemException {
		super(musicArtist, title, acquisitionDateStr, owner, costStr, formatStr);
		if (!Pattern.matches(Format.DATE.toString(), musicReleaseDate)) {
			throw new ItemException("Your date format is incorrect. It should be: YYYY-MM-DD");
		}
		releaseDate = musicReleaseDate;
	}
	
	public String displayStr() {
		return "'" + title + "' by " + creator + ", " + releaseDate + ". (" + format + ", " + owner + ", " + acqDate + ", " + cost + ")";
	}
	
	public String reportStr() {
		return owner + ": '" + title + "' by " + creator + " (" + format + ")";
	}
}
