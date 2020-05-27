package visitorman;

//Represents information about hosts, visitors and the visits
public class Party {

	private String _hostFamilyName;
	private String _hostGivenName;
	private String _hostEmail;
	private boolean _isHost;

	private String _visitFamilyName;
	private String _visitGivenName;
	private String _visitEmail;
	private String _organisation;


	/**
	 * Create a Party object for a specified host.
	 * @param hostFamilyName the family name of the host
	 * @param hostGivenName the given name of the host
	 * @param hostEmail email of the host
	 * @param isHost determines whether or not this instance will store a host 
	 */
	public Party(String hostFamilyName, String hostGivenName, String hostEmail, boolean isHost) {
		_hostFamilyName = hostFamilyName;
		_hostGivenName = hostGivenName;
		_hostEmail = hostEmail;
		_isHost = isHost;
		System.out.println("A Party Object was created for host " + hostGivenName + " " + hostFamilyName);
	}

	/**
	 * Create a Party object for a specified host and visitor.
	 * @param hostFamilyName the family name of the host
	 * @param hostGivenName the given name of the host
	 * @param hostEmail email of the host
	 * @param isHost determines whether or not this instance will store a host details or a party
	 * @param visitFamilyName family name of the visitor
	 * @param visitGivenName given name of the visitor
	 * @param visitEmail email of the visitor
	 * @param organisation the organisation the visitor belongs to
	 */
	public Party(String hostFamilyName, String hostGivenName, String hostEmail, boolean isHost, String visitFamilyName, 
			String visitGivenName, String visitEmail, String organisation) {
		_hostFamilyName = hostFamilyName;
		_hostGivenName = hostGivenName;
		_hostEmail = hostEmail;
		_isHost = isHost;
		_visitFamilyName = visitFamilyName;
		_visitGivenName = visitGivenName;
		_visitEmail = visitEmail;
		_organisation = organisation;

		System.out.println("A Party Object was created for visitor " + visitGivenName + " " + visitFamilyName);
	}

	//These methods get the fields in the party for other classes
	public String getHostEmail() {
		return _hostEmail;
	}

	public String getHostFamilyName() {
		return _hostFamilyName;
	}

	public String getHostGivenName() {
		return _hostGivenName;
	}

	public boolean getIsHost() {
		return _isHost;
	}

	public String getVisitorEmail() {
		return _visitEmail;
	}

	public String getVisitFamilyName() {
		return _visitFamilyName;
	}

	public String getVisitGivenName() {
		return _visitGivenName;
	}

	public String getOrganisation() {
		return _organisation;
	}
}
