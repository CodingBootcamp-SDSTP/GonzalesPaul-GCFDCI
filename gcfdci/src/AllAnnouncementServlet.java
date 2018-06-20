import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.io.PrintWriter;

public class AllAnnouncementServlet extends HttpServlet
{
	AnnouncementsCollection announcement;

	public void init() throws ServletException {
		HomeManagerDatabase hmd = new  HomeManagerDatabase();
		announcement = hmd.getAnnouncementsCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		out.print(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<Announcements>");
		ArrayList<Announcements> announcements = announcements.getAllAnnouncements();
		System.out.println(gallery);
		for(Announcements a : Gallery) {
			sb.append("<announcement><id>");
			sb.append(a.getId());
			sb.append("</id><title>");
			sb.append(a.getTitle());
			sb.append("</title><detailss>");
			sb.append(a.getDetailss());
			sb.append("</detailss><filetype>");
			sb.append(a.getFileType());
			sb.append("</filetype></date>");
			sb.append(a.getDate());
			sb.append("</date>");
		}
		sb.append("</Gallery>");
		return(sb.toString());
	}

	public void destroy() {
		announcement = null;
	}
}
