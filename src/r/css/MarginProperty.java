/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.Vector;

public class MarginProperty extends Property {
	
	public int top = 0;
	
	public int right = 0;
	
	public int bottom = 0;
	
	public int left = 0;
	
	public boolean auto = false;

	public MarginProperty() {
		super("margin");
	}
	
	public MarginProperty(int top) {
		super("margin");
		this.top = top;
	}
	
	public MarginProperty(int left, int bottom, int right) {
		super("margin");
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}
	
	public MarginProperty(boolean auto) {
		super("margin");
		this.auto = auto;
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		
		if(auto) {
			values.add("auto");
		} else {
			values.add(top + "px");
			values.add(right + "px");
			values.add(bottom + "px");
			values.add(left + "px");
		}
		return values;
	}
}
