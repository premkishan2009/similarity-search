
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class euclidean {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		Scanner in = new Scanner(System.in);
		int qno;
		
		int match = 0;
		double matchval =0;
		double distance=0;
		String temp = null;
		int cnt =0;
		List<Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
		 Map<String, Integer> ha = new HashMap<String, Integer>();
		 Map<String, Integer> ha1 = new HashMap<String, Integer>();
		 Map<String, Integer> ha2 = new HashMap<String, Integer>();
		 String pattern = "(.*)(\\t)(.*)";
		 
			System.out.println("Min query:0");
			System.out.println("Enter the query document number: ");
			qno = in.nextInt();
			in.close();
		 Pattern r = Pattern.compile(pattern);
		try {
			scanner = new Scanner(new File("/Users/prem/Downloads/cs584_hw2/data.txt"));
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
		
		
		
		
		

		
		
		
		
		
		
		for(int i =0;i<listOfMaps.size()-1;i++)
		{	distance =0;
			
			if(qno==i){
				
			}
			else
			{
				
				ha1 = new HashMap<String, Integer>();
				ha2 = new HashMap<String, Integer>();
					ha1.putAll(listOfMaps.get(qno));
					ha2.putAll(listOfMaps.get(i));
				
					for (Map.Entry<String, Integer> entry1 : listOfMaps.get(qno).entrySet()) {
						for (Map.Entry<String, Integer> entry2 : listOfMaps.get(i).entrySet()){
							if(entry1.getKey().equals(entry2.getKey())){
								distance = distance + ((entry1.getValue() - entry2.getValue())*(entry1.getValue()-entry2.getValue()));
								ha2.remove(entry2.getKey());
								ha1.remove(entry1.getKey());
								
							}
						}
						
					}
					for (Map.Entry<String, Integer> entry1 : ha1.entrySet()){
						distance = distance + entry1.getValue()*entry1.getValue();
					}
					for (Map.Entry<String, Integer> entry2 : ha2.entrySet()){
						distance = distance +entry2.getValue()*entry2.getValue();
					}
					
					distance = Math.sqrt(distance);
					distance = 1/(1+distance);
					
				if(distance>matchval){
					match = i;
					matchval = distance;
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


