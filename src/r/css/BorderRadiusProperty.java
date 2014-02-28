package r.css;

import java.util.Vector;

public class BorderRadiusProperty extends Property {

	public BorderRadiusProperty() {
		super("border-radius");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		// This is just a work around for the moment
		values.add("7px;-moz-border-radius: 7px;-webkit-border-radius: 7px;-goog-ms-border-radius: 7px");
		return values;
	}

}
