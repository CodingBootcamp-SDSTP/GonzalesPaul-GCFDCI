import java.util.ArrayList;
import java.time.LocalDate;

public class AnnouncementsCollection
{
	ArrayList<Announcements> announcements;
	
	public AnnouncementsCollection() {
		announcements = new ArrayList<Announcements>();
	}

	public void addAnnouncement(Announcements announcement) {
		announcements.add(announcement);
	}

	public void removeAnnouncement(Announcements announcement) {
		announcements.remove(announcement);
	}

	public ArrayList<Announcements> getAllAnnouncements() {
		return(announcements);
	}

	public Announcements getAnnouncementsByIndex(int n) {
		return(announcements.get(n));
	}

	public int getAnnouncementsCount() {
		return(announcements.size());
	}

	public ArrayList<Announcements> search(String s) {
		Announcements a = null;
		ArrayList<Announcements> aa = new ArrayList<Announcements>();
		String str = s.toLowerCase();
		for(int i=0; i<getAnnouncementsCount(); i++) {
			a = getAnnouncementsByIndex(i);
			if(matches(a, str)) {
				aa.add(a);
			}
		}
		return(aa);
	}

	public boolean matches(Announcements a, String str) {
		String title = a.getTitle().toLowerCase();
		String details = a.getDetails().toLowerCase();
		String filetype = a.getFileType().toLowerCase();
		if(title.contains(str) || details.contains(str) || filetype.contains(str)) {
			return(true);
		}
		return(false);
	}
}
