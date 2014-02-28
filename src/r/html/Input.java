package r.html;

import r.css.ClassSelector;

public class Input implements FormItem {
	
	public enum Type {TEXT, SUBMIT}
	
	private final static String TEXT = "text";
	
	private final static String SUBMIT = "submit";
	
	private HtmlUtil html;
	
	private Type type;
	
	private String name;
	
	private String value = "";
	
	private String label = "";
	
	private boolean breakLine = true;
	
	private ClassSelector selector = null;
	
	public Input(HtmlUtil html, Type type, String name, String value) {
		this.html = html;	
		this.type = type;
		this.name = name;
		if (value != null) {
			this.value = value;
		}
	}
	
	public Input(HtmlUtil html, Type type, String name, String value, boolean breakLine) {
		this.html = html;	
		this.type = type;
		this.name = name;
		if (value != null) {
			this.value = value;
		}
		this.breakLine = breakLine;
	}
	
	public Input(HtmlUtil html, Type type, String label, String name, String value) {
		this.html = html;	
		this.type = type;
		this.name = name;
		if (value != null) {
			this.value = value;
		}
		this.label = label;
	}
	
	public Input(HtmlUtil html, Type type, String label, String name, String value, ClassSelector selector) {
		this.html = html;	
		this.type = type;
		this.name = name;
		if (value != null) {
			this.value = value;
		}
		this.label = label;
		this.selector = selector;
	}
	
	public Input(HtmlUtil html, Type type, String label, String name, String value, boolean breakLine) {
		this.html = html;	
		this.type = type;
		this.name = name;
		if (value != null) {
			this.value = value;
		}
		this.label = label;
		this.breakLine = breakLine;
	}
	
	public void println() {
		String typeLabel = null;
		switch (type) {
		case TEXT:
			typeLabel = TEXT;
			break;
		case SUBMIT:
			typeLabel = SUBMIT;
			break;
		}
		if (!label.equals(""))
			if (selector != null) {
				html.writeText(selector, label + "<br />");
			} else {
				html.print(label + "<br />");
			}
		html.print("<input type=\"" + typeLabel + "\" name=\"" + name + "\" value=\"" + value + "\" />");
		if (breakLine) {
			html.print("<br />");
		}
	}
}
