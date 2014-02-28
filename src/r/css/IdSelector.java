/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import r.html.PrintWriter;

public class IdSelector extends Selector {
	public IdSelector(String name) {
		super(name);
	}

	public void toString(PrintWriter out) {
		out.println("." + name + " {");
		for (Property property : properties) {
			property.toString(out);
		}
		out.println(" }");
	}
}
