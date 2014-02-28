/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.Vector;

public class FontProperty extends Property {
	
	public int size = 12;
	public Face face = Face.HELVETICA_FAMILY; 
	
	public enum Face {
		HELVETICA_FAMILY ("face", "Arial, Tahoma, Helvetica, FreeSans, sans-serif"),
		MONOSPACE_FAMILY ("face", "\"lucida console\",\"courier\",\"courier new\"");

		final String name;
		final String value;
		Face(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public FontProperty() {
		super("font");
	}
	
	public FontProperty(int size) {
		super("font");
		this.size = size;
	}

	/*@Override
	public Map<String, String> getValues(Map<String, String> values) {
		values.put("size", size + "px");
		values.put(face.name, face.value);
		return null;
	}*/

	@Override
	public Vector<String> getValues(Vector<String> values) {
		values.add(size + "px");
		values.add(face.value);
		return values;
	}

}
