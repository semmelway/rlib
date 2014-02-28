package r.css;

import java.util.Vector;

public class BackgroundImageProperty extends Property {
	
	public String url = null;
	
	public BackgroundImageProperty() {
		super("background-image");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector<String> getValues(Vector<String> values) {
		if(url != null) 
			values.add("url('" + url + "')");
		else {
			System.out.println("BackgroundImageProperty, url must be set!");
			throw  new NullPointerException();
		}
		return values;
	}
}
