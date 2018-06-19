import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

public class History
{
	private final String ID;
	private final LocalDate date;
	private final String body;

	public History(String id, LocalDate date, String body) {
		ID = id;
		this.date = date;
		this.body = body;
	}

	public static void LocalDate(int year, int month, int dayOfMonth) {
		LocalDate date = LocalDate.of(1987,8,24);
	}

	public final LocalDate getLocalDate(int year, int month, int dayOfMonth) {
		return(date);
	}

	public final String getId() {
		return(ID);
	}

	public final void setId(String id) {
		id = id;
	}

	public final void setBody(String body) {
		body = body;
	}

	public final String getBody() {
		return(body);
	}
}
