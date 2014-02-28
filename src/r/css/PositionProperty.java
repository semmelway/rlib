package r.css;

import java.util.Vector;

public class PositionProperty extends Property {
	
	public enum Position {ABSOLUTE, FIXED, RELATIVE, STATIC}
	
	public Position position = Position.RELATIVE;

	public PositionProperty() {
		super("position");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		switch (position) {
		case ABSOLUTE:
			values.add("absolute");
			break;
		case FIXED:
			values.add("fixed");
			break;
		case RELATIVE:
			values.add("relative");
			break;
		case STATIC:
			values.add("static");
			break;
		}
		return values;
	}

}
