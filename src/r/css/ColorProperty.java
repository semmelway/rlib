/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.Vector;

public class ColorProperty extends Property {
	
	public static final String TRANSPARENT = "transparent";
	
	public String color = TRANSPARENT;
	
	public ColorProperty() {
		super("color");
	}
	
	public ColorProperty(String color) {
		super("color");
		this.color = color;
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		values.add(color);
	
		return values;
	}

}
