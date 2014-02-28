package r.html;

import r.css.ClassSelector;

public class Div {
	private String n = String.valueOf('"');//use "+n+"
	private HtmlUtil html;
	
	private int openCloseCounter = 0;
	
	public Div(HtmlUtil html){
		this.html = html;
	}
	
	public void centeredDivArea(String id, int width){
		html.print(
		"<div id="+n+ id +n+" style="+n+"position: relative;margin:0 auto; width:" + width + "px;text-align: left;"+n+">"
		);
		openCloseCounter++;
	}
	
	public void centeredStartTag(){
		html.print("<div align=" + n + "center" + n + ">");
		openCloseCounter++;
	}
	
	public void drawTextTable(String name, String[] labels, String[] targets,  int x, int y, int width, int height, int zPrio){
		Column column = new Column(html);
		genericStartTag(x, y, width, height, zPrio);
		column.startTag();
		column.start(width);
		
		for (int i = 0; i < targets.length; i++) {
			column.link(labels[i], targets[i], width/labels.length);
		}
		column.end();
		column.endTag();
		html.print("</div id=" +name + ">");
	}
	
	public void drawText(String text, int x, int y, int width, int height, int zPrio){
		genericStartTag(x, y, width, height, zPrio);
		html.writeText(text);
		genericEndTag();
	}
	
	public void drawTextLink(String text, String target,int x, int y, int width, int height, int zPrio, int linkType){
		genericStartTag(x, y, width, height, zPrio);
		html.writeTextLink(text, target, linkType);
		genericEndTag();
	}
	
	
	
	
	public void drawImage(String path, int x, int y,int width ,int height ,int zPrio ){
		genericStartTag(x, y, width, height, zPrio);
		html.drawImage("", path, width);
		genericEndTag();
	}
	
	public void drawImageLink(String path,String target, int x, int y,int width ,int height ,int zPrio ){
		genericStartTag(x, y, width, height, zPrio);
		html.drawImageLink(target, "", path, width, HtmlUtil.sameWindow);
		genericEndTag();
	}
	
	public void drawImageLinkNewWindow(String path,String target, int x, int y,int width ,int height ,int zPrio ){
		genericStartTag(x, y, width, height, zPrio);
		html.drawImageLink(target, "", path, width, HtmlUtil.newWindow);
		genericEndTag();
	}
	

	
	public void genericStartTag(int x, int y, int width, int height, int zPrio){
		html.print("<div style="+n+"position:absolute; left:" + x + "px; top:" + 
				y + "px; width:" + width + "px; height:" + height + "px; z-index:" + zPrio + ";"+n+">");
		openCloseCounter++;
	}
	
	public void genericStartTag(int x, int y, int width, int height, int zPrio, String color) {
		// 	public void genericStartTag(int x, int y, int width, int height, int zPrio){
		html.print("<div style="+n+"position:absolute; left:" + x + "px; top:" + 
				y + "px; width:" + width + "px; height:" + height + "px; z-index:" + zPrio + "; background: " + color + ";"+n+">");
		openCloseCounter++;
	}
	
	public void open(ClassSelector selector) {
		html.print("<div class=\"" + selector.name + "\">");
		openCloseCounter++;
	}
	
	public void fullWidthStartTag(int x, int y, int height, int zPrio, String color) {
		// 	public void genericStartTag(int x, int y, int width, int height, int zPrio){
		html.print("<div style="+n+"position:absolute; left:" + x + "px; top:" + 
				y + "px; width:100%; height:" + height + "px; z-index:" + zPrio + "; background: " + color + ";"+n+">");
		openCloseCounter++;
	}
	
	public void genericEndTag(){
		html.print("</div>");
		openCloseCounter--;
	}
	
	public void checkOpenCLose(String label){
		if(openCloseCounter != 0){
			System.out.println("****************ERROR* div balance for " + label + " is not 0. Balance: " + openCloseCounter);
		}
	}

}
