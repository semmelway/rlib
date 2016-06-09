/**
 * @author Robert Helmbo, 2007
 */
package r.html;

import java.io.FileWriter;
import java.io.IOException;

import r.css.ClassSelector;
import r.css.Css;

public class HtmlUtil {
	String backgroundColor = "FFFFFF";
	
	//Font parameters
	private String color = "#000000";
	private String face = "lucida console";
	private int size = 2;

	public final static int newWindow = 0;
	public final static int sameWindow = 1;

	private FileWriter outFile;
	private PrintWriter out;

	public HtmlUtil(){

	}

	public void setPrintWriter(java.io.PrintWriter printWriter){
		if(out == null) {
			out = new PrintWriter(false);
		}
		out.setPrintWriter(printWriter);
	}

	public void setPrintWriter(String path){

		try {
			outFile = new FileWriter(path);
			out = new PrintWriter(true);
			out.setPrintWriter(new java.io.PrintWriter(outFile));
		} catch (IOException e) {e.printStackTrace();}
	}

	public void setFileName(String path){
		try {
			outFile = new FileWriter(path);
			out = new PrintWriter(true);
			out.setPrintWriter(new java.io.PrintWriter(outFile));
		} catch (IOException e) {e.printStackTrace();}

	}

	public void closeConnection(){
		try {
			outFile.close();
		}catch(IOException e){e.printStackTrace();}
	}
		
	public void mailTo(String adress, String label){
	    out.println("<a href=\"mailto:"+adress+"\" style=\"text-decoration:none;\">");
		out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
		out.println(label);
		out.println("</font></a>");
	}
	
	public void drawImage(String picName, String path, int width){
		out.println("<img src=\"" + path + picName + "\" width=\""+width+"\" alt=\"\"/>" );
	}
	public void drawImageLn(String picName, String path, int width){
		out.println("<img src=\"" + path + picName + "\" width=\""+width+"\" alt=\"\"/><br>" );
	}
	
	public String getImageLn(String picName, String path, int width) {
		return "<img src=\"" + path + picName + "\" width=\""+width+"\" alt=\"\"/><br>";
	}
	
	public void drawImageLinkLn(String link, String pictureName, String path, int width, int linkType)
	{
		drawImageLink(link, pictureName, path, width, linkType);
		lineBreak(1);
	}

	public void drawImageLink(String link, String pictureName, String path, int width, int linkType) {
		drawImageLink(link, pictureName, path, "", width, linkType);
	}
	
	public void drawImageLink(String link, String pictureName, String path, String title,  int width, int linkType) {
		out.print("<a href=\""+link+"\" ");
		 if(linkType == newWindow)
			 out.print("target=\"_blank"+ "\" ");
		 out.print(">");
		out.println("<img border=\"0\" src=\""+path+pictureName+"\" width=\""+width+"\" title=\"" + title + "\" alt=\"\"/>"
				+"</a>" );
	}
	
	public void setFont(String color, String face, int size){
		this.color = color;
		this.face = face;
		this.size = size;
	}
	
	public String getFontStartTag(String color, String face, int size) {
		return "<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">";
	}
	
	public String getFontEndTag() {
		return "</font>";
	}
	
	public void writeText(String text){
		text = text.replace("  ", "&nbsp;&nbsp;");
		out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
		out.println(text);
		out.println("</font>");
	}
	
	public void writeCode(String string) {
		string = string.replace("<", "&lt;");
		string = string.replace(">", "&gt;");
		out.println(string);
	}
	
	public void writeH1(String text) {
		// Replace possible double space
		text = text.replace("  ", "&nbsp;&nbsp;");
		
		out.println("<h1>" + text + "</h1>");
	}

	public void writeText(ClassSelector classSelector, String text) {
		out.println("<div class=\"" + classSelector.name + "\">" + text + "</div>");
	}
	
	public void writeTextLn(String text) {
		text = text.replace("  ", "&nbsp;&nbsp;");
		out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
		out.println(text);
		out.println("<br>");
		out.println("</font>");
	}
	
	public static String getLinkCodeNewWindow(String linkLabel, String linkTarget) {
		StringBuilder result = new StringBuilder("");
		
		result.append("<a href=\"");
		result.append(linkTarget);
		result.append("\" target=\"_blank"+ "\">");
		result.append(linkLabel);
		result.append("</a>");
		return result.toString();
	}
	
	 public void writeTextLinkNewWindow(String linkLabel, String linkTarget){
		    out.println("<a href=\""+linkTarget+"\" style=\"text-decoration:none;\"target=\"_blank"+ "\">");
			out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
			out.println(linkLabel);
			out.println("</font></a>");
	 }
	 
	 public void writeTextLinkLnNewWindow(String linkLabel, String linkTarget){
		 	out.println("<a href=\""+linkTarget+"\" style=\"text-decoration:none;\"target=\"_blank"+ "\">");
			out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
			out.println(linkLabel);
			out.println("</font></a><br>");
	 }
	 
	 public void writeTextLinkS(String linkLabel, String linkTarget, ClassSelector selector, int linkType){
		 
		 StringBuilder html = new StringBuilder("");
		 html.append("<a class=\"" + selector.name + "\" ");
		 html.append("href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 html.append("target=\"_blank"+ "\" ");
		 html.append("style=\"text-decoration:none;"+ "\">");
		 html.append(linkLabel);
		 html.append("</a>");
		 out.println(html.toString());
	 }
	 
	 public void writeTextLink(String linkLabel, String linkTarget, ClassSelector selector, int linkType){
		 
		 StringBuilder html = new StringBuilder("");
		 html.append("<a href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 html.append("target=\"_blank"+ "\" ");
		 html.append("style=\"text-decoration:none;"+ "\">");
		 html.append(linkLabel);
		 html.append("</a>");
		 writeText(selector, html.toString());
	 }
	
	 public void writeTextLink(String linkLabel, String linkTarget, int linkType){
		 out.print("<a href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 out.print("target=\"_blank"+ "\" ");
		 out.println("style=\"text-decoration:none;"+ "\">");
		 out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
		 out.println(linkLabel);
		 out.println("</font></a>");
	 }
	 
		public String getLinkTag(String label, String target) {
			String tag =  "<a href=\""+target+"\" ";
			tag = tag + "target=\"_blank"+ "\" ";
			tag = tag + "style=\"text-decoration:none;"+ "\">";
			tag = tag + "<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">";
			tag = tag + label;
			tag = tag + "</font></a>";
			return tag;
		}
	 
	 public void writeCenteredTextLink(String linkLabel, String linkTarget, int linkType){
		 out.print("<a href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 out.print("target=\"_blank"+ "\" ");
		 out.println("style=\"text-decoration:none;"+ "\">");
		 out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
		 out.println("<center>");
		 out.println(linkLabel);
		 out.println("</center>");
		 out.println("</font></a>");
	 }
	 
	 /**
	  * 
	  * <P CLASS="centeralign">
Get Centered
</P>
	  */
	 
	 public void writeTextLinkLn(String linkLabel, String linkTarget, int linkType){
		 out.print("<a href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 out.print("target=\"_blank"+ "\" ");
		 out.println("style=\"text-decoration:none;"+ "\">");
		 out.println("<font color=\""+color+"\" face=\""+face+"\" size=\""+size+"\">");
		 out.println(linkLabel);
		 out.println("</font></a><br>");
	 }
	 
	 public void printLink(String linkLabel, String linkTarget, int linkType){
		 out.print("<a href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 out.print("target=\"_blank"+ "\">");
		 out.print("style=\"text-decoration:none;"+ "\">");
		 out.print(linkLabel);
		 out.println("</a>");
	 }
	 
	 public void printLinkLn(String linkLabel, String linkTarget, int linkType){
		 out.print("<a href=\""+linkTarget+"\" ");
		 if(linkType == newWindow)
			 out.print("target=\"_blank"+ "\" ");
		 out.print("style=\"text-decoration:none;"+ "\">");
		 out.print(linkLabel);
		 out.println("</a><br>");
	 }
	 
	 public String getLink(String linkLabel, String linkTarget) {
		 StringBuilder builder = new StringBuilder();
		 builder.append("<a href=\""+linkTarget+"\" >");
		 builder.append(linkLabel);
		 builder.append("</a>");
		 return builder.toString();
	 }
	
	 public void print(String text){
		 text.replace("  ", "&nbsp;&nbsp;");
		 out.println(text);
	 }
	
	public void lineBreak(int numberOf){
		for (int i = 0; i < numberOf; i++) {
			out.println("<br>");
		}
	}

	public void writeOpenTags() {
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	}

	public void writeCloseTags() {
	    out.println("</html>");
	}
	
	public void setBackgroundColor(String color) {
		color = color.replace("#", "");
		backgroundColor = color;
	}

	public void generateHead(String title, String description, String[] keywords, String add) {
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		out.println("<title>" + title + "</title>");
		out.println("<meta name=\"description\" content=\""+ description + "\"/>");
		
		out.print("<meta name=\"keywords\" content=\"");
		for (int i = 0; i < keywords.length; i++) {
			if(i == keywords.length - 1)
			out.print(keywords[i]);
				else
			out.print(keywords[i].concat(","));
		}
		out.println("\"/>");
		
		out.println(add);
		out.println("</head>");
	}
	
	public void generateHead(String title, String description, String[] keywords, String add, String css) {
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		out.println("<title>" + title + "</title>");
		out.println("<meta name=\"description\" content=\""+ description + "\"/>");
		
		out.print("<meta name=\"keywords\" content=\"");
		for (int i = 0; i < keywords.length; i++) {
			if(i == keywords.length - 1)
			out.print(keywords[i]);
				else
			out.print(keywords[i].concat(","));
		}
		out.println("\"/>");
		
		out.println(css);
		
		//css.writeHead(out);
		
		out.println(add);
		out.println("</head>");
	}
	
	public void generateHead(String title, String description, String[] keywords, String add, Css css) {
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		out.println("<title>" + title + "</title>");
		out.println("<meta name=\"description\" content=\""+ description + "\"/>");
		
		out.print("<meta name=\"keywords\" content=\"");
		for (int i = 0; i < keywords.length; i++) {
			if(i == keywords.length - 1)
			out.print(keywords[i]);
				else
			out.print(keywords[i].concat(","));
		}
		out.println("\"/>");
		
		//out.println(css);
		
		css.writeHead(out);
		
		out.println(add);
		out.println("</head>");
	}
	
	public void openBody() {
		out.println("<body>" );
	}
	
	public void openBodyWithBgColor() {
		out.println("<body bgcolor=" + "\"#" + backgroundColor + "\">" );
	}
	
	public void closeBody() {
		out.println("</body>");
	}
	
	@Override
	public void finalize() throws Throwable {
		System.out.println("Finalizing HtmlUtil");
		super.finalize();
	}
	
	public static String cleanFromBrTags(String stringToClean) {
		
		return stringToClean.replace("<br>", "");
	}
	
	public static String cleanFromTags(String stringToClean) {
		int firstOpen = stringToClean.indexOf('<');
		int firstClose = stringToClean.indexOf('>');
		String original = new String(stringToClean);
		
		if(firstOpen != -1 && firstClose != -1) {
			stringToClean = original.substring(0,firstOpen) + original.substring(firstClose+1);
		} else {
			return original;
		}
		return cleanFromTags(stringToClean);
	}


}
