/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.Vector;

public class PaddingProperty extends Property {
	
	public int top = 0;
	
	public int right = 0;
	
	public int bottom = 0;
	
	public int left = 0;

	public PaddingProperty() {
		super("padding");
	}

	public PaddingProperty(int left, int bottom, int right) {
		super("padding");
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		values.add(top + "px");
		values.add(right + "px");
		values.add(bottom + "px");
		values.add(left + "px");
		return values;
	}
}
