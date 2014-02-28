package r.css;

import r.html.PrintWriter;

public class HtmlLinkSelector extends Selector {
	
	Selector link;
	
	Selector visited;
	
	Selector active;
	
	Selector hover;
	
	public static enum Type {LINK,VISITED,ACTIVE,HOVER,ALL};

	public HtmlLinkSelector() {
		super("");
		link = new CustomSelector("a:link");
		visited  = new CustomSelector("a:visited");
		active  = new CustomSelector("a:active");
		hover  = new CustomSelector("a:hover");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addProperty(Property property) {
		throw new IllegalAccessError("This method is not supported use addProperty(Property, Type) instead");
	}
	
	public void addColor(String color, Type type) {
		addProperty(new ColorProperty(color), type);
	}
	
	public void addProperty(Property property, Type type) {
		switch (type) {
		case LINK:
			link.addProperty(property);
			break;
		case VISITED:
			visited.addProperty(property);
			break;
		case ACTIVE:
			active.addProperty(property);
			break;
		case HOVER:
			hover.addProperty(property);
			break;
		case ALL:
			link.addProperty(property);
			visited.addProperty(property);
			active.addProperty(property);
			hover.addProperty(property);
		}
	}

	@Override
	public void toString(PrintWriter out) {
		link.toString(out);
		visited.toString(out);
		active.toString(out);
		hover.toString(out);
	}

}
