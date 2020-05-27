package visitorman;

import java.util.ArrayList;
import java.util.List;

//Generate a visitor log when needed. 
public class VisitorLog {
	private String _organisationName;

	public VisitorLog(String organisationName) {
		_organisationName = organisationName;
		System.out.println("A VisitorLog Object was created");
	}

	/**
	 * Generate a log report
	 * @param hosts List of existing parties
	 * @return The report containing the visitor log
	 */
	public List<String> getLogReport(List<LogEntry> entry) {
		List<String> logReport = new ArrayList<String>();
		//Organisation Name is the first item in the list
		logReport.add(_organisationName);

		for (int i = 0; i < entry.size(); i++) {
			LogEntry currentLog = entry.get(i);
			//Add all existing visits to the log report
			String fname = currentLog.getVisitGivenName();
			String lname = currentLog.getVisitFamilyName();
			String organisation = currentLog.getOrganisation();
			String email = currentLog.getVisitorEmail();
			String hfName = currentLog.getHostGivenName();
			String hlName = currentLog.getHostFamilyName();
			String visitDay = currentLog.getCheckInDay();
			String checkIn = currentLog.getCheckInTime();
			String checkOut = currentLog.getCheckoutTime();

			//Format string
			if (checkOut == "") {
				logReport.add(lname + ", " + fname + " (" + organisation + "). " + email + " visiting " +  hlName + ", " + hfName + 
						". Arrived:" + visitDay + "T" + checkIn + ". On site.");
			} else {
				logReport.add(lname + ", " + fname + " (" + organisation + "). " + email + " visiting " +  hlName + ", " + hfName + 
						". Arrived:" + visitDay + "T" + checkIn + ". Left:" + checkOut);
			}

		}
		return logReport;
	}
}
