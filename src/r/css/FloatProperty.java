package r.css;

import java.util.Vector;

public class FloatProperty extends Property {
	
	public enum Position {RIGHT,LEFT}
	
	public Position position = Position.LEFT;

	public FloatProperty() {
		super("float");
	}
	
	public FloatProperty(Position pos) {
		super("float");
		position = pos;
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		switch (position) {
		case RIGHT:
			values.add("right");
			break;
		case LEFT:
			values.add("left");
			break;
		}
		return values;
	}

}
