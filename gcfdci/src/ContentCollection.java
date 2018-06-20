import java.util.ArrayList;
import java.time.LocalDate;

public class ContentCollection
{
	private ArrayList<Content> contents;

	public ContentCollection() {
		contents = new ArrayList<Content>();
	}

	public void addContent(Content content) {
		contents.add(content);
	}

	public void removeContent(Content content) {
		contents.remove(content);
	}

	public ArrayList<Content> getAllContents() {
		return(contents);
	}

	public Content getContentByIndex(int n) {
		return(contents.get(n));
	}

	public int getContentCount() {
		return(contents.size());
	}

	public ArrayList<Content> search(String s) {
		Content c = null;
		ArrayList<Content> ac = new ArrayList<Content>();
		String str = s.toLowerCase();
		for(int i=0; i<getContentCount(); i++) {
			c = getContentByIndex(i);
			if(matches(c, str)) {
				ac.add(c);
			}
		}
		return(ac);
	}

	public boolean matches(Content c, String str) {
		String title = c.getTitle().toLowerCase();
		String details = c.getDetails().toLowerCase();
		if(title.contains(str) || details.contains(str)) {
			return(true);
		}
		return(false);
	}
}
