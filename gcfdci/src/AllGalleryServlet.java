import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.io.PrintWriter;

public class AllGalleryServlet extends HttpServlet
{
	GalleryCollection gallery;

	public void init() throws ServletException {
		HomeManagerDatabase hmd = new  HomeManagerDatabase();
		gallery = hmd.getGalleryCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		out.print(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<Gallery>");
		ArrayList<Gallery> gallery = gallery.getAllGallery();
		System.out.println(gallery);
		for(Gallery g : Gallery) {
			sb.append("<gallery><id>");
			sb.append(g.getId());
			sb.append("</id><caption>");
			sb.append(g.getCaption());
			sb.append("</caption><filetype>");
			sb.append(g.getFileType());
			sb.append("</filetype>");
		}
		sb.append("</Gallery>");
		return(sb.toString());
	}

	public void destroy() {
		gallery = null;
	}
}
