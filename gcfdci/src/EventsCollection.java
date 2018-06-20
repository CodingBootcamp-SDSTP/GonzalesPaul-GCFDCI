import java.util.ArrayList;
import java.time.LocalDate;

public class EventsCollection
{
	ArrayList<Events> events;
	
	public EventsCollection() {
		events = new ArrayList<Events>();
	}

	public void addEvents(Events event) {
		events.add(event);
	}

	public void removeEvents(Events event) {
		events.remove(event);
	}

	public ArrayList<Events> getAllEvents() {
		return(events);
	}

	public Events getEventsByIndex(int n) {
		return(events.get(n));
	}

	public int getEventsCount() {
		return(events.size());
	}

	public ArrayList<Events> search(String s) {
		Events e = null;
		ArrayList<Events> ae = new ArrayList<Events>();
		String str = s.toLowerCase();
		for(int i=0; i<getEventsCount(); i++) {
			e = getEventsByIndex(i);
			if(matches(e, str)) {
				ae.add(e);
			}
		}
		return(ae);
	}

	public boolean matches(Events es, String str) {
		String title = es.getTitle().toLowerCase();
		String details = es.getDetails().toLowerCase();
		String venue = es.getVenue().toLowerCase();
		int phone = es.getPhone();
		String p = Integer.toString(phone);
		if(title.contains(str) || details.contains(str) || venue.contains(str) || p.contains(str)) {
			return(true);
		}
		return(false);
	}
}
