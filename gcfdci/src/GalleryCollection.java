import java.util.ArrayList;

public class GalleryCollection
{
	private ArrayList<Gallery> gallerys;

	public GalleryCollection() {
		gallerys = new ArrayList<Gallery>();
	}

	public void addGallery(Gallery gallery) {
		gallerys.add(gallery);
	}

	public void removeGallery(Gallery gallery) {
		gallerys.remove(gallery);
	}

	public ArrayList<Gallery> getAllGallerys() {
		return(gallerys);
	}

	public Gallery getGalleryByIndex(int n) {
		return(gallerys.get(n));
	}

	public int getGalleryCount() {
		return(gallerys.size());
	}

	public ArrayList<Gallery> search(String s) {
		Gallery g = null;
		ArrayList<Gallery> al = new ArrayList<Gallery>();
		String str = s.toLowerCase();
		for(int i=0; i<getGalleryCount(); i++) {
			g = getGalleryByIndex(i);
			if(matches(g, str)) {
				al.add(g);
			}
		}
		return(al);
	}

	// public boolean matches(Gallery g, String str) {
	// 	String name = g.getName().toLowerCase();
	// 	int monetaryValue = g.getMonetaryValue();
	// 	String ab = Integer.toString(monetaryValue);
	// 	if(ab.contains(str) || name.contains(str)) {
	// 		return(true);
	// 	}
	// 	return(false);
	// }
}
