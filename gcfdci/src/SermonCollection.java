import java.util.ArrayList;

public class SermonCollection
{
	ArrayList<Sermon> sermons;

	public SermonCollection() {
		sermons = new ArrayList<Sermon>();
	}

	public void addSermon(Sermon sermon) {
		sermons.add(sermon);
	}

	public void removeSermon(Sermon sermon) {
		sermons.remove(sermon);
	}

	public ArrayList<Sermon> getAllSermons() {
		return(sermons);
	}

	public Sermon getSermonByIndex(int n) {
		return(sermons.get(n));
	}

	public int getSermonCount() {
		return(sermons.size());
	}

	public Sermon getSermonById(String id) {
		Sermon sermon = null;
		for(int i=0; i<getSermonCount(); i++) {
			if(getSermonByIndex(i).getId().equalsIgnoreCase(id)) {
				sermon = getSermonByIndex(i);
			}
		}
		return(sermon);
	}

	public ArrayList<Sermon> search(String s) {
		Sermon se = null;
		ArrayList<Sermon> sl = new ArrayList<Sermon>();
		String str = s.toLowerCase();
		for(int i=0; i<getSermonCount(); i++) {
			se = getSermonByIndex(i);
			if(matches(se, str)) {
				sl.add(se);
			}
		}
		return(sl);
	}
 
	public boolean matches(Sermon s, String str) {
		String id = s.getId().toLowerCase();
		String title = s.getTitle().toLowerCase();
		String filetype = s.getFileType().toLowerCase();
		LocalDate date = s.getDate();
		if(id.contains(str) || title.contains(str) || filetype.contains(str) || date.contains(str)) {
			return(true);
		}
		return(false);
	}
}
