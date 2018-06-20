import java.time.LocalDate;

public class Announcements
{
	private String title;
	private String detailss;
	private String filetype;
	private LocalDate date;

	public Announcements(String title, String detailss, String filetype, LocalDate date) {
		this.title = title;
		this.detailss = detailss;
		this.filetype = filetype;
		this.date = date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return(title);
	}

	public void setDetailss(String detailss) {
		this.detailss = detailss;
	}

	public String getDetailss() {
		return(detailss);
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

	public String toString() {
		return("<Title>" + title + "</title>" + "<Details>" + detailss + "</Details>" + "<FileType>" + filetype + "</FileType>" + "<Date>" + date + "</Date>");
	}

	public String getDetails() {
		return(title + "@" + detailss + "@" + filetype + "@" + date + "@announcements");
	}
}
