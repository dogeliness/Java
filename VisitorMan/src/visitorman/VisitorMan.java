package visitorman;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage visitors. When a visitor arrives, he must check in by providing his name, the organisation
 * he belongs to, his email address, and specify who he is visiting. 
 * In order to receive a visitor, the host must be registered, which is done by providing her name
 * and email address.
 * All names and email addresses must be unique.
 * All names consist of a given name and a family name. A name may be formatted as either
 * "formal" or "informal"
 * The formal format is family name followed by comma, followed by a space, followed by the given name.
 * The informal format is given name followed by space, followed family name.
 * 
 * <P>SOFTENG251 2020 Assignment 2. Copyright Ewan Tempero, The University of Auckland, 2020.
 */
public class VisitorMan {
	private String _organisationName;
	private List<Party> _hosts = new ArrayList<Party>();
	private List<LogEntry> _entries = new ArrayList<LogEntry>();
	private List<Details> _details = new ArrayList<Details>();
	private VisitorLog _newLog;

	/**
	 * Create a VisitorMan object for the specified organisation.
	 * @param organisationName The name of the organisation whose visitors are being managed.
	 */
	public VisitorMan(String organisationName) {
		_organisationName = organisationName;
		System.out.println("A VisitorMan object was created for organisation:" + _organisationName);
		_newLog = new VisitorLog(_organisationName);
	}
	/**
	 * Register someone as able to host a visitor. It is assumed that there is always 
	 * both a given and a family name, that the host's name is unique (no other hosts 
	 * with the same name), and the email address is unique.
	 * @param familyName The family name of the host
	 * @param givenName The given name of the host
	 * @param email The email address of the host.
	 */
	public void registerHost(String familyName, String givenName, String email) {
		//Creates Party object to store host and Details object to store formatted details
		Party newHost = new Party(familyName, givenName, email, true);
		Details newDetails = new Details(familyName, givenName, email);
		_details.add(newDetails);
		_hosts.add(newHost);
	}

	/**
	 * Provide a string that describes the host with the specified email address.
	 * @param emailAddress The email address of the host to describe.
	 * @return A string describing the host, with format FORMAL_NAME ". " EMAIL_ADDRESS. 
	 * Returns null if there is no host with the email address.
	 */
	public String showHostDetails(String emailAddress) {
		for (int i = 0; i < _details.size(); i++) {
			Details currentHost = _details.get(i);
			if (currentHost.getEmail() == emailAddress) {
				//get formatted host details for specified host
				return currentHost.getDetails();
			}
		}
		//no host with the email
		return null;
	}

	/**
	 * Provide a list of strings describing all the registered hosts.
	 * Each string should use the same format as {@link #showHostDetails(String)} 
	 * and in the order that the hosts were registered.
	 * @return A list of string with host details.
	 */
	public List<String> getRegisteredHosts() {
		//store host details
		List<String> hostDetails = new ArrayList<String>();

		for (int i = 0; i < _details.size(); i++) {
			//retrieve formatted string for each host
			Details currentDetail = _details.get(i);
			hostDetails.add(currentDetail.getDetails());
		}
		return hostDetails;
	}

	/**
	 * Record that a visitor with the specified details is visiting the
	 * host with the specified email address on the date given and starting
	 * at the specified time. There are always both given and family names,
	 * and names and email addresses are unique.
	 * @param familyName The family name of the visitor
	 * @param givenName The given name of the visitor
	 * @param organisation The organisation the visitor is from
	 * @param visitorEmail The email address of the visitor
	 * @param hostEmail The email address of the host the visitor is visiting
	 * @param visitDate The date of the visit (ISO8601 format)
	 * @param visitStartTime The time of the start of the visit (ISO8601 format)
	 */
	public void checkIn(String familyName, String givenName, String organisation, String visitorEmail, 
			String hostEmail, String visitDate, String visitStartTime) {
		//Check if host exists
		if (showHostDetails(hostEmail) != null) {
			for (int i = 0; i < _hosts.size(); i++) {
				Party currentParty = _hosts.get(i);
				if (currentParty.getHostEmail() == hostEmail) {
					String hostGName = currentParty.getHostGivenName();
					String hostFName = currentParty.getHostFamilyName();

					//Create party object for visitor and host
					Party newVisit = new Party(hostFName, hostGName, hostEmail, false, familyName, 
							givenName, visitorEmail, organisation);

					//Create LogEntry object for the party and the visit information
					LogEntry newEntry = new LogEntry(newVisit, visitDate, visitStartTime);

					_hosts.add(newVisit);
					_entries.add(newEntry);
					break;
				}
			}
		}
	}

	/**
	 * Record that the visitor with the specified email address checked
	 * out at the specified time.
	 * @param emailAddress The visitor's email address.
	 * @param checkOutTime The checkout time (ISO8601 format)
	 */
	public void checkOut(String emailAddress, String checkOutTime) {
		//Get the object with the visitor's email address
		for (int i = 0; i < _entries.size(); i++) {
			LogEntry currentEntry = _entries.get(i);
			if (currentEntry.getVisitorEmail() == emailAddress) {
				currentEntry.signOut(checkOutTime);
			}
		}
	}

	/**
	 * Return a report of all the visitors current on site, that is,
	 * those that have checked in but not checked out.
	 * The report is a list of strings (one string per visitor, with the format 
	 * INFORMAL_NAME " (" ORGANISATION "). " EMAIL_ADDRESS
	 * @return A list of strings with the visitors on site.
	 */
	public List<String> getVisitorsOnSite() {
		List<String> currentVisitors = new ArrayList<String>();
		for (int i = 0; i < _entries.size(); i++) {
			LogEntry currentEntry = _entries.get(i);
			if (currentEntry.getCheckoutTime() == "") {
				String fname = currentEntry.getVisitGivenName();
				String lname = currentEntry.getVisitFamilyName();
				String organisation = currentEntry.getOrganisation();
				String email = currentEntry.getVisitorEmail();

				currentVisitors.add(fname + " " + lname  + " (" + organisation + "). " + email);
			}
		}
		return currentVisitors;
	}
	/**
	 * Return a report of the complete visitor log as a list of strings (one string
	 * per line in the report). The first line of the report is the company name. The
	 * remaining lines are, in order of arrival, one line per visitor giving full details
	 * of visitor, their check in time, and their check out time (or empty if they are
	 * still on site).
	 * @return The report for the visitor log.
	 */
	public List<String> getVisitorLogReport() {
		return _newLog.getLogReport(_entries);
	}
}