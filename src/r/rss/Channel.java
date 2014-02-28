package r.rss;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;

import r.html.PrintWriter;

public class Channel {
	
	String title;

	String description;
	
	String link;
	
	String lastBuildDate;
	
	String pubDate;
	
	String language = "sv-se";
	
	String generator = "Tiller";
	
	String selfLink;
	
	Vector<Item> items;
	
	public Channel() {
		items = new Vector<Item>();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
		pubDate = dateFormatter.format(new GregorianCalendar().getTime());
		
		lastBuildDate = dateFormatter.format(new GregorianCalendar().getTime());
	    pubDate =lastBuildDate;
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	/*public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}*/

	/*public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}*/
	
	public void addItem(Item item) {
		items.add(item);
	}

	public void write(PrintWriter out) {
		out.print("<channel>");
		out.print("<title>" + title + "</title>");
		out.print("<description>" + description + "</description>");
		out.print("<link>" + link + "</link>");
		out.print("<lastBuildDate>" + lastBuildDate + "</lastBuildDate>");
		out.print("<pubDate>" + pubDate + "</pubDate>");
		out.print("<language>" + language + "</language>");
		out.print("<generator>" + generator + "</generator>");
		out.print("<atom:link href=\"" + selfLink + "\" rel=\"self\" type=\"application/rss+xml\" />");
		for (int i = 0; i < items.size(); i++) {
			items.get(i).write(out);
		}
		
		out.print("</channel>");
	}
}
