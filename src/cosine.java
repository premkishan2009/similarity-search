
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cosine {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		Scanner in = new Scanner(System.in);
		int qno;
		double d1=0,d2=0;
		int match = 0;
		double matchval =0;
		double cosval=0;
		String temp = null;
		int cnt =0;
		List<Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
		 Map<String, Integer> ha = new HashMap<String, Integer>(); //new hashmap
		 String pattern = "(.*)(\\t)(.*)";
		 
			System.out.println("Min query:0");
			System.out.println("Enter the query document number: ");
			qno = in.nextInt();
			in.close();
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
			 ha.put("class:"+m.group(1), -1);
			 
	         
	   
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
		
		
		
		
		

		
		
		for (Map.Entry<String, Integer> entry : listOfMaps.get(qno).entrySet()) {
			if(entry.getValue()!=-1)
			d1 = d1 + (double)Math.pow(entry.getValue(), 2); 
			
		}
		d1 = Math.sqrt(d1);
		
		
		
		for(int i =0;i<listOfMaps.size()-1;i++)
		{	cosval =0;
			d2 = 0;
			if(qno==i){
				
			}
			else
			{
				for (Map.Entry<String, Integer> entry : listOfMaps.get(i).entrySet()) {
					if(entry.getValue()!=-1)
					d2 = d2 + entry.getValue()*entry.getValue(); 
					
					
				}
				d2 = Math.sqrt(d2);
				
				
				
					for (Map.Entry<String, Integer> entry1 : listOfMaps.get(qno).entrySet()) {
						for (Map.Entry<String, Integer> entry2 : listOfMaps.get(i).entrySet()){
							if(entry1.getKey().equals(entry2.getKey())){
								cosval = cosval + entry1.getValue()*entry2.getValue(); // -1 condition not used modify to include -1 condition.
							}
						}
						
					}
					
					cosval = cosval/(d1*d2);
					
				if(cosval>matchval){
					match = i;
					matchval = cosval;
				}
				
			}
		}
		
		System.out.println(match);
		System.out.println(matchval);
		for (Map.Entry<String, Integer> entry : listOfMaps.get(qno).entrySet()) {
			if(entry.getValue()==-1)
			System.out.println(entry.getKey()); 
			
		}
		
		for (Map.Entry<String, Integer> entry : listOfMaps.get(match).entrySet()) {
			if(entry.getValue()==-1)
			System.out.println(entry.getKey()); 
			
		}
		
		
	}
	
	
}


