package r.html;

import java.io.UnsupportedEncodingException;

public class PrintWriter {

	java.io.PrintWriter printWriter;
	boolean doUtf8Encoding = false;
	
	public PrintWriter(boolean doUtf8Encoding) {
		this.doUtf8Encoding = doUtf8Encoding;
		
	}
	
	public void setPrintWriter(java.io.PrintWriter printWriter){
		this.printWriter = printWriter;
	}

	public void println(String text) {
		if(doUtf8Encoding) {
			try{
				printWriter.println(new String(text.getBytes("UTF-8")));
			}catch(UnsupportedEncodingException uee){uee.printStackTrace();}
		} else {
			printWriter.println(text);
		}
	}

	
	public void print(String text){
		if(doUtf8Encoding) {
		try{
		printWriter.print(new String(text.getBytes("UTF-8")));
		}catch(UnsupportedEncodingException uee){uee.printStackTrace();}
		} else {
			printWriter.print(text);
		}
	}
}
