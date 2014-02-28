package r.rss;

import r.html.PrintWriter;

public class Item {
	
	String title;
	
	String description;
	
	String link;
	
	String pubDate;
	
	String guid;
	
	String guidIsLink;
	
	String author = null;
	
	ItemImage image = null;

	public void write(PrintWriter out) {
		out.print("<item>");
		out.print("<title>" + title + "</title>");
		out.print("<description><![CDATA[" + description + "]]></description>");
		out.print("<link>" + link + "</link>");
		out.print("<pubDate>" + pubDate + "</pubDate>");
		if(author != null) {
			out.print("<author>" + author + "</author>");
		}
		out.print("<guid isPermaLink=\"" + guidIsLink + "\">" + guid + "</guid>");
		
		// Images just added in html description for now
		/*if(image != null) {
			image.write(out);
		}*/
		out.print("</item>");
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

	public void setPubDate(String longDate) {
		pubDate = longDate;
		
	}

	public void setGuid(String guid, boolean isLink) {
		this.guid = guid;
		
		if (isLink) {
			this.guidIsLink = "true";
		} else {
			this.guidIsLink = "false";
		}
		
	}
	
	public void setImage(ItemImage image) {
		this.image = image;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
