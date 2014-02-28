package r.css;

import java.util.Vector;

public class BorderLineProperty extends Property {

	public BorderLineProperty() {
		super("border");
	}

	// border: 1px solid #63b122;
	@Override
	public Vector<String> getValues(Vector<String> values) {
		// This is just a work around for the moment
		values.add("1px solid #63b122");
		return values;
	}
}
