public class Gallery
{
	private String caption;
	private String filetype;

	public Gallery(String caption, String filetype) {
		this.caption = caption;
		this.filetype = filetype;
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
}
