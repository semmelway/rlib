/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import r.html.PrintWriter;

public class HtmlSelector extends Selector {
	
	public static enum Type {BODY,H1,CODE,PRE};
	
	public HtmlSelector(Type type) {
		super("");
		switch (type) {
		case BODY:
			name = "body";
			break;
		case H1:
			name = "h1";
			break;
		case CODE:
			name = "code";
			break;
		case PRE:
			name = "pre";
			break;
		}
	}

	public void toString(PrintWriter out) {
		out.println(name + " {");
		for (Property property : properties) {
			property.toString(out);
		}
		out.println(" }");
	}

}
