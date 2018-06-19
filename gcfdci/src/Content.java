import java.time.LocalDate;

public class Content
{
	private String title;
	private String details;
	private LocalDate date;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return(title);
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return(details);
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return(date);
	}

	public String toString() {
		return("Title: " + title + ", Details: " + details + ", Date: " + date);
	}

	public String getDetails() {
		return(title + "@" + date);
	}
}
