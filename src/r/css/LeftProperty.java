package r.css;

import java.util.Vector;

public class LeftProperty extends Property {
	
	

	public LeftProperty() {
		super("text-decoration");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		values.add("none");
		return values;
	}
}
