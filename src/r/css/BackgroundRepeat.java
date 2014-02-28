package r.css;

import java.util.Vector;

public class BackgroundRepeat extends Property {
	
	public boolean repeatX = true;
	
	public boolean repeatY = true;

	public BackgroundRepeat() {
		super("background-repeat");
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		String value = "repeat-";
		
		if(repeatY)
			value += "x";
		
		if(repeatX)
			value += "y";
		
		values.add(value);
		
		return values;
	}

}
