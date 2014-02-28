package r.css;

import java.util.Vector;

public class BackgroundColorProperty extends Property {

	public String color = null;
	
	public BackgroundColorProperty() {
		super("background");
	}
	
	public BackgroundColorProperty(String color) {
		super("background");
		this.color = color;
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		if(color != null)
			values.add(color);
		else {
			System.out.println("BackgroundProperty, color must be set!");
			throw  new NullPointerException();
		}
		// TODO Auto-generated method stub
		return values;
	}
}
