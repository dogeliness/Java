package visitorman;

//Used to store information about a single visit. It is also used for signing visitors out and in. 
public class LogEntry {
	private Party _visitParty;
	private String _checkInTime;
	private String _checkInDay;
	private String _checkOut = "";

	//LogEntry objects contain the visitor and host information, as well as check in/out information
	public LogEntry(Party visitParty, String checkInDay, String checkInTime) {
		_visitParty = visitParty;
		_checkInDay = checkInDay;
		_checkInTime = checkInTime;
		System.out.println("A LogEntry Object was created");
	}

	//Get visitor and host details from Party object
	public String getVisitorEmail() {
		return _visitParty.getVisitorEmail();
	}

	public String getVisitGivenName() {
		return _visitParty.getVisitGivenName();
	}

	public String getVisitFamilyName() {
		return _visitParty.getVisitFamilyName();
	}

	public String getOrganisation() {
		return _visitParty.getOrganisation();
	}

	public String getHostGivenName() {
		return _visitParty.getHostGivenName();
	}

	public String getHostFamilyName() {
		return _visitParty.getHostFamilyName();
	}

	//Retrieve check in/out information
	public String getCheckInDay() {
		return _checkInDay;
	}

	public String getCheckInTime() {
		return _checkInTime;
	}

	public String getCheckoutTime() {
		return _checkOut;
	}

	public void signOut(String checkOutTime) {
		_checkOut = checkOutTime;
	}
}
