package r.css;

import java.util.Vector;


public class ItalicProperty extends Property {
	
	public static enum Type {ITALIC};
	
	
	public ItalicProperty() {
		super("font-style");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		
		values.add("italic");
		return values;
	}
}
