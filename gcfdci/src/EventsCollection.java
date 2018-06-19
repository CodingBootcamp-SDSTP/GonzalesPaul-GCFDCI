import java.util.ArrayList;
import java.time.LocalDate;

public class EventsCollection
{
	ArrayList<Event> events;
	
	public EventCollection() {
		events = new ArrayList<Event>();
	}

	public void addEvent(Event event) {
		events.add(event);
	}

	public void removeEvent(Event event) {
		events.remove(event);
	}

	public ArrayList<Event> getAllEvents() {
		return(events);
	}

	public Event getEventByIndex(int n) {
		return(events.get(n));
	}

	public int getEventCount() {
		return(events.size());
	}

	public ArrayList<Event> search(String s) {
		Event e = null;
		ArrayList<Event> ae = new ArrayList<Event>();
		String str = s.toLowerCase();
		for(int i=0; i<getEventCount(); i++) {
			e = getEventByIndex(i);
			if(matches(e, str)) {
				ae.add(e);
			}
		}
		return(ae);
	}

	public boolean matches(Event e, String str) {
		String id = e.getId().toLowerCase();
		String title = e.getTitle().toLowerCase();
		String details = e.getDetails().toLowerCase();
		LocalDate date_time = e.getDate();
		String venue = e.getVenue().toLowerCase();
		String phone = Integer.toString(phone);
		if(id.contains(str) || title.contains(str) || details.contains(str) || date_time.contains(LocalDate) || venue.contains(str) || phone.contains(str)) {
			return(true);
		}
		return(false);
	}
}
