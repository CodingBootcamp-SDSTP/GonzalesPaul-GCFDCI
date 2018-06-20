import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.io.PrintWriter;

public class ContentAllServlet extends HttpServlet
{
	ContentCollection content;
	HomeManagerDatabase hmd;

	public void init() throws ServletException {
		hmd = new  HomeManagerDatabase();
		content = hmd.getContentCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("sermon");
		String g = request.getParameter("gallery");
		String e = request.getParameter("event");
		String a = request.getParameter("announcement");
		if(s == null && g == null && e == null && a == null) {
			out.print(exportToXML());
		}
		else if(c != null) {
			findContent(request, response);
		}
		else if(s != null) {
			findSermon(request, response);
		}
		else if(g != null) {
			findGallery(request, response);
		}
		else if(a != null) {
			findAnnouncement(request, response);
		}
		else if(e != null) {
			findEvent(request, response);
		}
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<content>");
		ArrayList<Content> content = contents.getAllContents();
		for(Content c : content) {
			if(c instanceof Gallery) {
				Gallery ga = (Gallery)c;
				sb.append("<gallery><id>");
				sb.append(ga.getId() + "</id><caption>");
				sb.append(ga.getCaption() + "</caption><filetype>");
				sb.append(ga.getFileType() + "</filetype>");
				sb.append("</gallery>");
			}
			else if(c instanceof Sermons) {
				Sermons s = (Sermons)c;
				sb.append("<sermons><title>");
				sb.append(s.getTitle() + "</title><filetype>");
				sb.append(s.getFileType() + "</filetype><date>");
				sb.append(s.getDate() + "</date>");
				sb.append("</sermons>");
			}
			else if(c instanceof Announcements) {
				Announcements a = (Announcements)c;
				sb.append("<announcements><title>");
				sb.append(a.getTitle() + "</title><detailss>");
				sb.append(a.getDetailss() + "</detailss></filetype>");
				sb.append(a.getFileType() + "</filetype><date>");
				sb.append(a.getDate() + "</date>");
				sb.append("</announcements>");
			}
			else if(c instanceof Events) {
				Events e = (Events)c;
				sb.append("<events><title>");
				sb.append(a.getTitle() + "</title><detailss>");
				sb.append(a.getDetailss() + "</detailss><dateTime>");
				sb.append(a.getDateTime() + "</dateTime><venue>");
				sb.append(a.getVenue() + "</venue><phone>");
				sb.append(a.getPhone() + "</phone>");
				sb.append("</events>");
			}
		}
		sb.append("</content>");
		return(sb.toString());
	}

	// public void findContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	response.setContentType("text/xml");
	// 	PrintWriter out = response.getWriter();
	// 	StringBuilder sb = new StringBuilder("<content>");
	// 	ArrayList<Asset> asset = assets.getAllAssets();
	// 	for(Asset a : asset) {
	// 		if(a instanceof AssignableAsset) {
	// 			AssignableAsset aa = (AssignableAsset)a;
	// 			if(aa.getAssignedTo() != null) {
	// 				if(aa.getAssignedTo().contains(request.getParameter("assigned"))) {
	// 					if(a instanceof Table) {
	// 						Table tb = (Table)a;
	// 						sb.append("<table><name>");
	// 						sb.append(tb.getName() + "</name><price>");
	// 						sb.append(tb.getMonetaryValue() + "</price><location>");
	// 						sb.append(tb.getLocation() + "</location><assignedto>");
	// 						sb.append(tb.getAssignedTo() + "</assignedto>");
	// 						sb.append("</table>");
	// 					}
	// 					else if(a instanceof SoftwareLicense) {
	// 						SoftwareLicense sl = (SoftwareLicense)a;
	// 						sb.append("<softwarelicense><name>");
	// 						sb.append(sl.getName() + "</name><price>");
	// 						sb.append(sl.getMonetaryValue() + "</price><assignedto>");
	// 						sb.append(sl.getAssignedTo() + "</assignedto>");
	// 						sb.append("</softwarelicense>");
	// 					}
	// 				}
	// 			}
	// 		}
	// 	}
	// 	sb.append("</assets>");
	// 	out.print(sb.toString());
	// }

	// public void findLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	response.setContentType("text/xml");
	// 	PrintWriter out = response.getWriter();
	// 	StringBuilder sb = new StringBuilder("<assets>");
	// 	ArrayList<Asset> asset = assets.getAllAssets();
	// 	for(Asset a : asset) {
	// 		if(a instanceof AssetWithLocation) {
	// 			AssetWithLocation aa = (AssetWithLocation)a;
	// 			if(aa.getLocation() != null) {
	// 				if(aa.getLocation().contains(request.getParameter("location"))) {
	// 					if(a instanceof Table) {
	// 						Table tb = (Table)a;
	// 						sb.append("<table><name>");
	// 						sb.append(tb.getName() + "</name><price>");
	// 						sb.append(tb.getMonetaryValue() + "</price><location>");
	// 						sb.append(tb.getLocation() + "</location><assignedto>");
	// 						sb.append(tb.getAssignedTo() + "</assignedto>");
	// 						sb.append("</table>");
	// 					}
	// 					else if(a instanceof Building) {
	// 						Building b = (Building)a;
	// 						sb.append("<building><name>");
	// 						sb.append(b.getName() + "</name><price>");
	// 						sb.append(b.getMonetaryValue() + "</price><location>");
	// 						sb.append(b.getLocation() + "</location>");
	// 						sb.append("</building>");
	// 					}
	// 				}
	// 			}
	// 		}
	// 	}
	// 	sb.append("</assets>");
	// 	out.print(sb.toString());
	// }

	public void destroy() {
		content = null;
	}
}
