package r.html;

public class Column {
	String n = String.valueOf('"');//use "+n+"
	
	HtmlUtil html;
	public Column(HtmlUtil html){
		this.html = html;
	}
	
	public void startTag(){
		html.print("<table border="+n+"0"+n+" width="+n+"100%"+n+" cellpadding="+n+"null"+n+" ><tr>");
	}
	
	public void start(int width){
		if(width == -1){
		    html.print("<td valign="+n+"top"+n+">");
		}else{
			html.print("<td width="+n+ width +n+" valign="+n+"top"+n+">");
		}
	}
	
	public void link(String linkLabel,String linkTarget , int width){
		
		html.print("<td width=" + n + width + n+ ">");
		html.writeTextLink(linkLabel, linkTarget, HtmlUtil.sameWindow);
		html.print("</td>");
		//<td width="115"><a href="main.php?show=mydiskltd">Om myDisk</a></td>
	}
	
	public void end(){
		html.print("</td>");
	}
	
	public void endTag(){
		html.print("</tr></table>");
	}
}
