package r.html;

import java.util.Vector;

public class Form {
	
	private HtmlUtil html;
	
	private String action = null;
	
	private Vector<FormItem> items = new Vector<FormItem>();
	
	public Form(HtmlUtil html) {
		this.html = html;
	}
	
	public void setAction(String action){
		this.action = action;
	}
	
	public void addItem(FormItem item) {
		items.add(item);
	}
	
	public void println() {
		html.print("<form method=\"post\"");
		if(action != null ) {
			html.print("action=\"" + action + "\"");
		}
		html.print(">");
		
		
		for (int i = 0; i < items.size(); i++) {
			items.get(i).println();
		}
		
		html.print("</form>");
	}

}
