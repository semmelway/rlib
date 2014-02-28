package r.html;

public class TextArea implements FormItem {

public enum Type {TEXT}
	
	private HtmlUtil html;
	
	private String name;
	
	private String value;
	
	private String label = "";
	
	private int cols = 80;
	private int rows = 10;
	
	public TextArea(HtmlUtil html, String name, String value) {
		this.html = html;	
		this.name = name;
		this.value = value;
	}
	
	public TextArea(HtmlUtil html, String label, String name, String value) {
		this.html = html;	
		this.name = name;
		this.value = value;
		this.label = label;
	}
	
	public void setSize(int cols, int rows) {
		this.cols = cols;
		this.rows = rows;
	}
	
	public void println() {
		html.print(label + "<br />");
		html.print("<textarea name=\"" + name + "\" cols=\"" + cols + "\" rows=\"" + rows + "\" >" + value + "</textarea>");
	}
	
}
