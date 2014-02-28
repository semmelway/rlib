package r.rss;

import java.io.FileWriter;
import java.io.IOException;

import r.html.PrintWriter;

public class RssUtil {
	private FileWriter outFile;
	private PrintWriter out;

	public RssUtil(String destinationPath){
		setPrintWriter(destinationPath);
	}
	
	public void generateFile(Rss rss) {
		out.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		rss.write(out);
		closeConnection();
	}
	
	private void setPrintWriter(String path){
		try {
			outFile = new FileWriter(path);
			out = new PrintWriter(true);
			out.setPrintWriter(new java.io.PrintWriter(outFile));

		} catch (IOException e) {e.printStackTrace();}
	}

	private void closeConnection(){
		try {
			outFile.close();
		}catch(IOException e){e.printStackTrace();}
	}
}
