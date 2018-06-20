import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.*;
import java.net.*;

public class HomeManagerDatabase
{
	private ContentCollection contents;
	Connection conn;

	public HomeManagerDatabase() {
		contents = new ContentCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/gcf_fb?user=paul&password=admin&serverTimezone=UTC&useSSL=false");
			readFromQSL();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addContent(Content content) {
		if(insertToSQL(content)) {
			contents.addContent(content);
		}
	}

	boolean insertToSQL(Content content) {
		PreparedStatement stmt = null;
		try {
			if(content instanceof Announcements) {
				Announcements announcement = (Announcements)content;
				stmt = conn.prepareStatement("INSERT INTO announcement ( title, details, file, date ) VALUES ( ?, ?, ?, ?, ? );");
				stmt.setString(1, announcement.getTitle());
				stmt.setString(2, announcement.getDetails());
				stmt.setString(3, announcement.getFileType());
				stmt.setLocalDate(4,announcement.getDate());
				stmt.setString(5, "announcement");
				stmt.executeUpdate();
			}
			else if(content instanceof Events) {
				Events events = (Events)content;
				stmt = conn.prepareStatement("INSERT INTO events ( title, details, datetime, venue, phone ) VALUES ( ?, ?, ?, ?, ?, ? );");
				stmt.setString(1, events.getTitle());
				stmt.setString(2, events.getDetails());
				stmt.setLocalDate(3,events.getDateTime());
				stmt.setString(4,events.getVenue());
				stmt.setInt(5,events.getPhone());
				stmt.setString(6, "events");
				stmt.executeUpdate();
			}
			else if(content instanceof Sermons) {
				Sermons sermons = (Sermons)content;
				stmt = conn.prepareStatement("INSERT INTO events ( title, file, date ) VALUES ( ?, ?, ?, ? );");
				stmt.setString(1, sermons.getTitle());
				stmt.setString(2,sermons.getFileType());
				stmt.setLocalDate(3,sermons.getDate());
				stmt.setString(4, "sermons");
				stmt.executeUpdate();
			}
			else if(content instanceof Gallery) {
				Gallery gallery = (Gallery)content;
				stmt = conn.prepareStatement("INSERT INTO events ( id, caption, file ) VALUES ( ?, ?, ?, ? );");
				stmt.setInt(1, gallery.getId());
				stmt.setString(2,gallery.getCaption());
				stmt.setString(3,gallery.getFile());
				stmt.setString(4, "gallery");
				stmt.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if (stmt != null) stmt.close(); } catch(Exception e) {};
		}
		return(true);
	}

	// public AnnouncementsCollection getAnnouncementsCollection() {
	// 	return(announcements);
	// }

	// public EventsCollection getEventsCollection() {
	// 	return(events);
	// }

	// public SermonCollection getSermonCollection() {
	// 	return(sermons);
	// }

	// public GalleryCollection getGalleryCollection() {
	// 	return(gallerys);
	// }

	public Content getContentById(String id) {
		return(content.getContentById(id));
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> ao = new ArrayList<Object>();
		ArrayList<Content> cs = contents.search(s);
		ao.addAll(cs);
		return(ao);
	}

	public boolean readFromQSL() {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM events;");
			while(rs.next()) {
				String[] str = {
					rs.getString("title"),
					rs.getString("details"),
					rs.getString("date_time"),
					rs.getString("venue"),
					rs.getString("phone"),
					"events"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM sermons;");
			while(rs.next()) {
				String[] str = {
					rs.getString("title"),
					rs.getString("file"),
					rs.getString("date"),
					"sermons"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM gallery;");
			while(rs.next()) {
				String[] str = {
					rs.getString("id"),
					rs.getString("caption"),
					rs.getString("file"),
					"gallery"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM announcements;");
			while(rs.next()) {
				String[] str = {
					rs.getString("title"),
					rs.getString("details"),
					rs.getString("file"),
					rs.getString("date"),
					"announce"
				};
				createObject(str);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) {stmt=null;}} catch(Exception e) {};
			try { if(rs != null) {rs=null;}} catch(Exception e) {};
		}
		return(true);
	}

	public void createObject(String... details) {
		int len = details.length - 1;
		String d = details[len];
		if("gallery".equals(d)) {
			Gallery g = new Gallery(details[0], details[1], details[2]);
			gallerys.addGallery(g);
		}
		else if("sermon".equals(d)) {
			Sermons s = new Sermons(details[0], details[1], LocalDate.of(details[2]));
			sermons.addSermons(s);
		}
		else if("event".equals(d)) {
			Events e = new Events(details[0], details[1], LocalDate.of(details[2]), details[3], Integer.parseInt(details[4]));
			events.addEvents(e);
		}
		else if("announcement".equals(d)) {
			Announcements a = new Announcements(details[0], details[1], details[3], LocalDate.of(details[4]));
			announcements.addAnnouncements(a);
		}
	}

	public boolean readFromFile(String filename) {
		boolean f = false;
		try {
			FileReader file = new FileReader(filename);
			BufferedReader fbr = new BufferedReader(file);
			String fileLine;
			while((fileLine = fbr.readLine()) != null) {
				createObject(fileLine);
			}
			f = true;
			fbr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(f);
	}

	public boolean writeToFile(String filename) {
		boolean f = false;
		try {
			FileWriter fWriter = new FileWriter(filename);
			BufferedWriter fbw = new BufferedWriter(fWriter);
			fbw.write(getCollectionContent());
			fbw.close();
			f = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(f);
	}

	public String getCollectionContent() {
		ArrayList<Content> c = contents.getAllContents();
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<c.size(); i++) {
			Content content = c.get(i);
			sb.append(content.getDetails());
			if(i < c.size()-1) {
				sb.append("\n");
			}
		}
		return(sb.toString());
	}
}
