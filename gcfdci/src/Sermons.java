import java.time.LocalDate;

public class Sermons
{
	private String title;
	private String filetype;
	private LocalDate date;

	public Sermons(String t, String ft, LocalDate date) {
		title = t;
		filetype = ft;
		this.date = date;
	}

	public void setTitle(String t) {
		title = t;
	}

	public String getTitle() {
		return(title);
	}

	public void setFileType(String ft) {
		filetype = ft;
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

	public String toString() {
		return("<Title>" + title + "</Title>" + "<FileType>" + filetype + "</FileType>" + "<Date>" + date + "</Date>");
	}

	public String getDetails() {
		return(title + "@" + filetype + "@" + date + "@sermons");
	}
}
