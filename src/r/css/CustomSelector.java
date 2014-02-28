package r.css;

import r.html.PrintWriter;

public class CustomSelector extends Selector {
	
	public CustomSelector(String name) {
		super(name);
	}
	

	@Override
	public void toString(PrintWriter out) {
		out.println(name + " {");
		for (Property property : properties) {
			property.toString(out);
		}
		out.println(" }");
	}

}
