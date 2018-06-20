import java.util.ArrayList;
import java.time.LocalDate;

public class SermonCollection
{
	ArrayList<Sermons> sermons;
	private LocalDate date;

	public SermonCollection() {
		sermons = new ArrayList<Sermons>();
	}

	public void addSermons(Sermons sermon) {
		sermons.add(sermon);
	}

	public void removeSermons(Sermons sermon) {
		sermons.remove(sermon);
	}

	public ArrayList<Sermons> getAllSermons() {
		return(sermons);
	}

	public Sermons getSermonByIndex(int n) {
		return(sermons.get(n));
	}

	public int getSermonCount() {
		return(sermons.size());
	}

	public ArrayList<Sermons> search(String s) {
		Sermons se = null;
		ArrayList<Sermons> sl = new ArrayList<Sermons>();
		String str = s.toLowerCase();
		for(int i=0; i<getSermonCount(); i++) {
			se = getSermonByIndex(i);
			if(matches(se, str)) {
				sl.add(se);
			}
		}
		return(sl);
	}

	public boolean matches(Sermons c, String str) {
		String title = c.getTitle().toLowerCase();
		String filetype = c.getFileType().toLowerCase();
		LocalDate date = c.getDate();
		if(title.contains(str) || filetype.contains(str)) {
			return(true);
		}
		return(false);
	}
}
