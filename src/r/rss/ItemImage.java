package r.rss;

import r.html.PrintWriter;

public class ItemImage {
	
	String url;

	String type = "image/png";
	
	int size = 0;
	
	public void write(PrintWriter out) {
		out.print("<enclosure ");
		out.print("url=\"" + url + "\" ");
		out.print("length=\"" + size + "\" ");
		out.print("type=\"" + type + "\" ");
		out.print("/>");
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	
	
	

}
