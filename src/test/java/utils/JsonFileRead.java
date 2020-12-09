package utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class JsonFileRead {  
	

	static String filePath = "D:\\L&T Technology Services\\EclipseWorkspace\\Login_Page_Fadr\\src\\test\\resources\\JsonFiles\\";
    public String readData(String fileName) {
    String data = "";
    try {
     
      File JsonRead = new File(filePath+fileName);
      Scanner myReader = new Scanner(JsonRead);  
      while (myReader.hasNextLine()) {
        data += myReader.nextLine() + "\n";
       
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println(data);
	return data; 
 }  
}























/*
public class JsonFileRead {  
	
	static String filePath = "D:\\L&T Technology Services\\EclipseWorkspace\\Login_Page_Fadr\\src\\test\\resources\\JsonFiles\\";
	StringBuilder sb = new StringBuilder();
	//static String filePath = "D:\\L&T Technology Services\\EclipseWorkspace\\Login_Page_Fadr\\src\\test\\resources\\JsonFiles\\";
	
	public String readData(String fileName) {
    //String data = "";
		Path path = Paths.get(filePath+fileName);
		try (Stream stream = Files.lines(path)) {
    	stream.forEach(s -> sb.append(s).append("\n"));
    	
		}
		catch (IOException ex) {
    	// Handle exception
		}
    String contents = sb.toString();
 }  
}

*/


 




/*
public class JsonFileRead {  
	

	static String filePath = "D:\\L&T Technology Services\\EclipseWorkspace\\Login_Page_Fadr\\src\\test\\resources\\JsonFiles\\";
    public String readData(String fileName) {
    String data = "";
    try {
     
      File JsonRead = new File(filePath+fileName);
      Scanner myReader = new Scanner(JsonRead);  
      while (myReader.hasNextLine()) {
        data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	return data; 
 }  
}
*/