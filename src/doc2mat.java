import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class doc2mat {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		String temp = null;
		int cnt =0;
		List<Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
		 Map<String, Integer> ha = new HashMap<String, Integer>(); //new hashmap
		 String pattern = "(.*)(\\t)(.*)";
		 Pattern r = Pattern.compile(pattern);
		try {
			scanner = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.useDelimiter(" ");
		
		
			
		while(scanner.hasNext()){
			
			temp = scanner.next();
			
		 Matcher m = r.matcher(temp);
		
		
		 if (m.find( )) {
			 if(ha.size()!=0){
			 listOfMaps.add(cnt, ha);
			 cnt++;} // add
			ha = new HashMap<String, Integer>();
			 ha.put(m.group(3), 1);
			 ha.put(m.group(1), -1);
			 
	         
	   
	      } else {
	    	  if(ha.containsKey(temp))
	    	  {
	    		  ha.put(temp, ha.get(temp)+1);
	    	  }
	    	  else
	    	  {
	    		  ha.put(temp, 1);
	    	  }
	         
	      }
		}
		listOfMaps.add(cnt, ha);
		
		
		PrintStream out1 = null;
		try {
			out1 = new PrintStream(new FileOutputStream("out.txt"));
			System.setOut(out1);
			for(int i=0;i<listOfMaps.size();i++){
				out1.println(listOfMaps.get(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
}


