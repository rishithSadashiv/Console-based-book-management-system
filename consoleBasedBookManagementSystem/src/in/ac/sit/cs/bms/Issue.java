package in.ac.sit.cs.bms;

public class Issue {
	
	private String USN;
	private String issueDate;
	private String returnDate;
	private int ISBN;
	public Issue(String uSN, String issueDate, String returnDate, int iSBN) {
		super();
		USN = uSN;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		ISBN = iSBN;
	}
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	@Override
	public String toString() {
		return "Issue [USN=" + USN + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", ISBN=" + ISBN + "]";
	}

	
	

}
