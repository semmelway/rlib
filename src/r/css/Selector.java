/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.Vector;

import r.html.PrintWriter;

public abstract class Selector {
	
	public String name;
	
	protected Vector<Property> properties = new Vector<Property>();
	
	public Selector(String name) {
		this.name = name;
	}
	
	public void addProperty(Property property) {
		properties.add(property);
	}

	public abstract void toString(PrintWriter out);
	
	/*public void openInline(PrintWriter out) {
		for (Property property : properties) {
			property.openInline(out);
		}
	}

	public void closeInline(PrintWriter out) {
		for (Property property : properties) {
			property.closeInline(out);
		}
	}*/
}
