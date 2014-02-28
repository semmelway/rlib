package r.css;

import java.util.Vector;

public class WidthProperty extends Property {
	
	public int width = 1024;

	public WidthProperty() {
		super("width");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		values.add(width + "px");
		return values;
	}

}
