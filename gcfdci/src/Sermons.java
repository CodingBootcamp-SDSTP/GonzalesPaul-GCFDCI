import java.time.LocalDate;

public class Sermons
{
	private String ID;
	private String title;
	private String filetype;
	private LocalDate date;

	public Sermons(String id, String t, String ft, LocalDate date) {
		ID = id;
		title = t;
		filetype = ft;
		this.date = date;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getId() {
		return(ID);
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
}
