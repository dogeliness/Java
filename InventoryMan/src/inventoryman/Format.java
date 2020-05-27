package inventoryman;

/** 
 * Format stores the patterns used to test for correct cost and date formats. 
 */

public enum Format {
	COST("\\$\\d+\\.\\d{2}"), YEAR("\\d{4}"), DATE("\\d{4}-\\d{2}-\\d{2}");

	private String regex;
	
	private Format(String string) {
		this.regex = string;
	}
	
	@Override
	public String toString() {
		return regex;
	}

}
