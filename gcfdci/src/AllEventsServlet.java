import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.io.PrintWriter;

public class AllEventsServlet extends HttpServlet
{
	EventsCollection events;

	public void init() throws ServletException {
		HomeManagerDatabase hmd = new  HomeManagerDatabase();
		events = hmd.getEventsCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		out.print(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<Events>");
		ArrayList<Events> events = events.getAllEvents();
		System.out.println(Events);
		for(Events e : Events) {
			sb.append("<events><id>");
			sb.append(e.getId());
			sb.append("</id><title>");
			sb.append(e.getTitle());
			sb.append("</title><detailss>");
			sb.append(e.getDetailss());
			sb.append("</detailss><dateTime>");
			sb.append(e.getDateTime());
			sb.append("</dateTime><venue>");
			sb.append(e.getVenue());
			sb.append("</venue><phone>");
			sb.append(e.getPhone());
			sb.append("</phone>");
		}
		sb.append("</Events>");
		return(sb.toString());
	}

	public void destroy() {
		events = null;
	}
}
