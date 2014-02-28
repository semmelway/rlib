/**
 * @author Robert Helmbro, 2012
 */
package r.css;

import java.util.Vector;

/**
 * @author Robert Helmbro, 2012
 */
import r.html.PrintWriter;

public abstract class Property {
	
	protected final String name;
	
	public Property(String name) {
		this.name = name;
	}
	
	public void toString(PrintWriter out) {
		out.print(name + ":");
		
		Vector<String> values = new Vector<String>();
		values = getValues(values);
		
		for (String value : values) {
			out.print(" " + value);
		}
		out.print(";\n");
	}
	
	/*public void toString(PrintWriter out) {
		out.print(name + ":");
		Map<String,String> values = new HashMap<String,String>();
		values = getValues(values);
		Collection<Entry<String,String>> col = values.entrySet();
		
		for (Entry<String, String> entry : col) {
			out.print(" " + entry.getValue());
		}
		out.print(";\n");
	}*/
	
	/*public void openInline(PrintWriter out) {
		out.print("<" + name);
		
		Map<String,String> values = new HashMap<String,String>();
		values = getValues(values);
		Collection<Entry<String,String>> col = values.entrySet();
		
		for (Entry<String, String> entry : col) {
			out.print(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
		}
		
		out.print(">");
	}*/
	
	/*public void closeInline(PrintWriter out) {
		out.print("</" + name + ">");
	}*/
	
	// default impl
	/*public Map<String,String> getValues(Map<String,String> values) {
		
		Vector<String> vec = new Vector<String>();
		vec = getValues(vec);
		
		for (String string : vec) {
			values.put("not impl", string);
		}
		return values;
	}*/
	
	public abstract Vector<String> getValues(Vector<String> values);

}
