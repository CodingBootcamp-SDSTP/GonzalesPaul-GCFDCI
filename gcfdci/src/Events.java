import java.lang.*;
import java.time.*;

public class Events
{
	private String title;
	private String details;
	private LocalDateTime dateTime;
	private String venue;
	private int phone;

	public Events(String title, String details, LocalDateTime datetime, String venue, int phone) {
		this.title = title;
		this.details = details;
		this.dateTime = datetime;
		this.venue = venue;
		this.phone = phone;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return(title);
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return(details);
	}

	public void setDateTime(LocalDateTime datetime) {
		this.dateTime = datetime;
	}

	public LocalDateTime getDateTime() {
		return(dateTime);
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getVenue() {
		return(venue);
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getPhone() {
		return(phone);
	}
}
