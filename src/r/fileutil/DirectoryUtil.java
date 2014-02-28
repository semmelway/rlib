package r.fileutil;

import java.io.File;

public class DirectoryUtil {
	

	/** Creates a folder out of the information in the specified path.
	 *  
	 * @param path
	 */
	public synchronized static void createFolder(String path) {

		//System.out.println("Enter createFolder(), path = " + path);
		File newFolder = new File(path);

		if (newFolder.exists()){
//			System.out.println("The folder do already exists\n\n");
			return;
		}
		
		File parent = new File(newFolder.getParent());

		if (parent.exists()) {
			newFolder.mkdir();
//			System.out.print("creates " + newFolder.getName() + ", sucess? ");
//			System.out.println(newFolder.mkdir() + "\n\n");
		} else {
			createFolder(parent.getPath());
			newFolder.mkdir();
//			System.out.print("creates " + newFolder.getName() + ", sucess? ");
//			System.out.println(newFolder.mkdir() + "\n\n");
		}
	}

	public static long getDirectorySize(File directory){
		if(!directory.isDirectory()){
			System.out.println("Error: " + directory.getName() + " is not a directory. ");
			return -1;
		}
		
		long size = 0; 
		
		File[] filesNFolders = directory.listFiles();
		
		for (int i = 0; i < filesNFolders.length; i++) {
			if(filesNFolders[i].isDirectory()){
				size += DirectoryUtil.getDirectorySize(filesNFolders[i]);
			}else{
				size += filesNFolders[i].length();
			}
		}
		return size;
	}
	
	public static void main(String args[]){
		DirectoryUtil.createFolder("C:/test/size/kalle/balle");
		new File("C:/test/size/kalle/balle").exists();
}
}
