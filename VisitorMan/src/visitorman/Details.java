package visitorman;

//This class stores formatted strings of each host, for easy access.
public class Details {
	private String _hostDetails;
	private String _email;

	//Constructor
	public Details(String familyName, String givenName, String email) {
		_email = email;
		_hostDetails = (familyName + ", " + givenName + ". " + email);
		System.out.println("A Details object was created");
	}

	//get formatted string containing host details
	public String getDetails() {
		return _hostDetails;
	}

	//used from other classes to test for host
	public String getEmail() {
		return _email;
	}
}