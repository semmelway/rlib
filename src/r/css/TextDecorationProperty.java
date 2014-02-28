package r.css;

import java.util.Vector;

public class TextDecorationProperty extends Property {
	
	public TextDecorationProperty() {
		super("text-decoration");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		
		values.add("none");
		return values;
	}
}
