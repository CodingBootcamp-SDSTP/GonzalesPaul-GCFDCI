import java.util.ArrayList;
import java.time.LocalDate;

public class AnnouncementCollection
{
	ArrayList<Announcement> announcements;
	
	public AnnouncementCollection() {
		announcements = new ArrayList<Announcement>();
	}

	public void addAnnouncement(Announcement announcement) {
		announcements.add(announcement);
	}

	public void removeAnnouncement(Announcement announcement) {
		announcements.remove(announcement);
	}

	public ArrayList<Announcement> getAllAnnouncements() {
		return(announcements);
	}

	public Announcement getAnnouncementByIndex(int n) {
		return(announcements.get(n));
	}

	public int getAnnouncementCount() {
		return(announcements.size());
	}

	public ArrayList<Announcement> search(String s) {
		Announcement a = null;
		ArrayList<Announcement> aa = new ArrayList<Announcement>();
		String str = s.toLowerCase();
		for(int i=0; i<getAnnouncementCount(); i++) {
			a = getAnnouncementByIndex(i);
			if(matches(a, str)) {
				aa.add(a);
			}
		}
		return(aa);
	}

	public boolean matches(Announcement a, String str) {
		String id = a.getId().toLowerCase();
		String title = a.getTitle().toLowerCase();
		String details = a.getDetails().toLowerCase();
		String filtype = a.getVenue().toLowerCase();
		LocalDate date = a.getDate();
		if(id.contains(str) || title.contains(str) || details.contains(str) || filetype.contains(str) || date.contains(LocalDate)) {
			return(true);
		}
		return(false);
	}
}
