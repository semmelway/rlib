/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.List;
import java.util.Vector;

import r.html.PrintWriter;

/**
 * Java representation of a css file.
 *
 */
public class Css {
	
	private List<Selector> selectors = new Vector<Selector>();
	
	public void addSelector(Selector selector) {
		selectors.add(selector);
	}
	
	public void writeHead(PrintWriter out) {
		out.println("<style type=\"text/css\">");
		for (Selector selector: selectors) {
			selector.toString(out);
		}
		out.println("</style>");
		
	}
	
	public void write(PrintWriter out) {
		for (Selector selector: selectors) {
			selector.toString(out);
		}
	}
}
