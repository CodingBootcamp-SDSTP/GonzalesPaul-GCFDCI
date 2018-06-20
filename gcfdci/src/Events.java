import java.lang.*;
import java.time.*;

public class Events
{
	private String title;
	private String detailss;
	private LocalDateTime dateTime;
	private String venue;
	private int phone;

	public Events(String title, String detailss, LocalDateTime datetime, String venue, int phone) {
		this.title = title;
		this.detailss = detailss;
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

	public void setDetailss(String detailss) {
		this.detailss = detailss;
	}

	public String getDetailss() {
		return(detailss);
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

	public String toString() {
		return("<Title>" + title + "</title>" + "<Detailss>" + detailss + "</Detailss>" + "<DateTime>" + dateTime + "</DateTime>" + "<Venue>" + venue + "</Venue>" + "<Phone>" + phone + "</Phone>");
	}

	public String getDetails() {
		return(title + "@" + detailss + "@" + dateTime + "@" + venue + "@" + phone + "@events");
	}
}
