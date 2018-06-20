import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.io.PrintWriter;

public class AllSermonsServlet extends HttpServlet
{
	SermonsCollection sermons;

	public void init() throws ServletException {
		HomeManagerDatabase hmd = new  HomeManagerDatabase();
		sermons = hmd.getSermonsCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		out.print(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<Sermons>");
		ArrayList<Sermons> sermons = sermons.getAllSermons();
		System.out.println(sermons);
		for(Sermons s : Sermons) {
			sb.append("<sermons><id>");
			sb.append(s.getId());
			sb.append("</id><title>");
			sb.append(s.getTitle());
			sb.append("</title><filetype>");
			sb.append(s.getFileType());
			sb.append("</filetype><date>");
			sb.append(s.getDate());
			sb.append("</date>");
		}
		sb.append("</Sermons>");
		return(sb.toString());
	}

	public void destroy() {
		sermons = null;
	}
}
