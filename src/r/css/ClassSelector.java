/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import r.html.PrintWriter;

public class ClassSelector extends Selector {
	
	private boolean overridesA = false;

	public ClassSelector(String name) {
		super(name);
	}
	
	public ClassSelector(String name, boolean linkOverride) {
		super(name);
		overridesA = linkOverride;
	}

	public void toString(PrintWriter out) {
		if(overridesA) {
			out.println("." + name + " a {");
		} else {
			out.println("." + name + " {");
		}
		for (Property property : properties) {
			property.toString(out);
		}
		out.println(" }");
	}
}
