import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.*;
import java.net.*;

public class HomeManagerDatabase
{
	private History h;
	private About a;
	private Contacts c;
	private SundayServices ss;
	private Sermons s;
	private Announcement ann;
	private Gallery g;
	private Life_Verse lv;
	private Events e;
	Connection conn;

	public HomeManagerDatabase() {
		// persons = new PersonCollection();
		// assets = new AssetCollection();
		// locations = new LocationCollection();
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
			if(content instanceof Announcement) {
				Announcement announcement = (Announcement)content;
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

	public AssetCollection getAssetCollection() {
		return(assets);
	}

	public PersonCollection getPersonCollection() {
		return(persons);
	}

	public LocationCollection getLocationCollection() {
		return(locations);
	}

	public Person getPersonById(String id) {
		return(persons.getPersonById(id));
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> ao = new ArrayList<Object>();
		ArrayList<Person> ps = persons.search(s);
		ArrayList<Asset> as = assets.search(s);
		ArrayList<Location> ls = locations.search(s);
		ao.addAll(ps);
		ao.addAll(as);
		ao.addAll(ls);
		return(ao);
	}

	public boolean readFromQSL() {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM persons;");
			while(rs.next()) {
				String[] str = {
					rs.getString("id"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("age"),
					rs.getString("department"),
					"person"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM locations;");
			while(rs.next()) {
				String[] str = {
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("city"),
					rs.getString("country"),
					rs.getString("address"),
					"location"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM assets;");
			while(rs.next()) {
				String[] str = {
					rs.getString("name"),
					rs.getString("price"),
					rs.getString("location"),
					rs.getString("assignedTo"),
					rs.getString("type"),
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
		if("person".equals(d)) {
			Person p = new Person(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4]);
			persons.addPerson(p);
		}
		else if("location".equals(d)) {
			Location l = new Location(details[0], details[1], details[2], details[3], details[4]);
			locations.addLocation(l);
		}
		else if("building".equals(d)) {
			Building b = new Building(details[0], Integer.parseInt(details[1]), details[2]);
			assets.addAsset(b);
		}
		else if("softwarelicense".equals(d)) {
			SoftwareLicense s = new SoftwareLicense(details[0], Integer.parseInt(details[1]), details[3]);
			assets.addAsset(s);
		}
		else if("table".equals(d)) {
			Table t = new Table(details[0], Integer.parseInt(details[1]), details[2], details[3]);
			assets.addAsset(t);
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
		ArrayList<Person> p = persons.getAllPersons();
		ArrayList<Location> l = locations.getAllLocations();
		ArrayList<Asset> a = assets.getAllAssets();
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<p.size(); i++) {
			Person person = p.get(i);
			sb.append(person.getDetails() + "\n");
		}
		for(int i=0; i<l.size(); i++) {
			Location location = l.get(i);
			sb.append(location.getDetails() + "\n");
		}
		for(int i=0; i<a.size(); i++) {
			Asset asset = a.get(i);
			sb.append(asset.getDetails());
			if(i < a.size()-1) {
				sb.append("\n");
			}
		}
		return(sb.toString());
	}
}
