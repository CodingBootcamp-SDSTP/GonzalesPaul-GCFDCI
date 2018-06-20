public class Gallery
{
	private String id;
	private String caption;
	private String filetype;

	public Gallery(String caption, String filetype, String id) {
		this.caption = caption;
		this.filetype = filetype;
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return(id);
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCaption() {
		return(caption);
	}

	public void setFileType(String filetype) {
		this.filetype = filetype;
	}

	public String getFileType() {
		return(filetype);
	}

	public String toString() {
		return("<Id>" + id + "</Id>" + "<Caption>" + caption + "</Caption>" + "<FileType>" + filetype + "</FileType>");
	}

	public String getDetails() {
		return(id + "@" + caption + "@" + filetype + "@gallery");
	}
}
