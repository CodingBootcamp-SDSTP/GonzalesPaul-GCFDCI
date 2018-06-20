import java.time.LocalDate;

public class Content
{
	private String title;
	private String detailss;
	private LocalDate date;

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

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return(date);
	}

	public String toString() {
		return("Title: " + title + ", Details: " + detailss + ", Date: " + date);
	}

	public String getDetails() {
		return(title + "@" + detailss + "@" + date);
	}
}
