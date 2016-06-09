package r.html;

import r.css.ClassSelector;

public class Span {
	private HtmlUtil html;
	
	private int openCloseCounter = 0;
	
	public Span(HtmlUtil html){
		this.html = html;
	}
	
	
	public void drawTextLink(String text, String target, ClassSelector selector, int linkType){
		open(selector);
		html.printLink(text, target, linkType);
		genericEndTag();
	}
	

	
	public void open(ClassSelector selector) {
		html.print("<span class=\"" + selector.name + "\">");
		openCloseCounter++;
	}
	
	public void genericEndTag(){
		html.print("</span>");
		openCloseCounter--;
	}
	
	public void checkOpenCLose(String label){
		if(openCloseCounter != 0){
			System.out.println("****************ERROR* span balance for " + label + " is not 0. Balance: " + openCloseCounter);
		}
	}

}
