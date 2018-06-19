import java.time.LocalDate;

public class Announcements
{
	private String title;
	private String details;
	private String filetype;
	private LocalDate date;

	public Announcements(String title, String details, String filetype, LocalDate date) {
		this.title = title;
		this.details = details;
		this.filetype = filetype;
		this.date = date;
	}

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

	public void setFileType(String filetype) {
		this.filetype = filetype;
	}

	public String getFileType() {
		return(filetype);
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return(date);
	}

}
