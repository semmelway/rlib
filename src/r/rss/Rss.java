package r.rss;

import java.util.Vector;

import r.html.PrintWriter;

public class Rss {
	
	Vector<Channel> channels;
	
	String cssUrl = null;
	
	public Rss(){
		channels = new Vector<Channel>();
	}
	
	public void setCssUrl(String cssUrl) {
		this.cssUrl = cssUrl;
	}

	public void write(PrintWriter out) {
		out.println("<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\">");

		if (cssUrl != null) {
			out.println("<?xml-stylesheet type=\"text/css\" media=\"screen\" href=\"" + cssUrl + "\"?>");
		}
		
		for (int i = 0; i < channels.size(); i++) {
			channels.get(i).write(out);
		}
		out.print("</rss>");
	}
	
	public void addChannel(Channel channel) {
		channels.add(channel);
	}
}
