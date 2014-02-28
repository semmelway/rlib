package r.css;

import java.util.Vector;

public class ShadowProperty extends Property {

	public ShadowProperty() {
		super("box-shadow");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		// This is just a work around for the moment
		values.add("0 0 20px rgba(0, 0, 0, .2);-moz-box-shadow: 0 0 20px rgba(0, 0, 0, .2);-webkit-box-shadow: 0 0 20px rgba(0, 0, 0, .2);-goog-ms-box-shadow: 0 0 20px rgba(0, 0, 0, .2)");
		return values;
	}
}
