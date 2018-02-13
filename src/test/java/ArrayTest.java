import java.util.HashMap;
import java.util.Map;

public class ArrayTest {
	
	
	public static void main(String[] args) throws Exception {
		
		Map<String,Integer> testMap = new HashMap<>();
		
		testMap.put("2018-01-01", 0);
		testMap.put("2018-01-01", 1);
		testMap.put("2018-01-01", 2);
		testMap.put("2018-01-01", 3);
		testMap.put("2018-01-02", 1);
		testMap.put("2018-01-03", 1);
		testMap.put("2018-01-03", 2);
		testMap.put("2018-01-03", 3);
		testMap.put("2018-01-03", 4);
		
		for(Map.Entry<String, Integer> entry : testMap.entrySet()) {
			String year = entry.getKey();
			int time = entry.getValue();
			
			
			
			for(int i=0 ; i<24 ; i++) {
				
				if(time == i ) {
					System.out.print(year+ ":" +time + ",");
				} else {
					System.out.print(year+ ":" +i + ",");
				}
				
				if(i == 23) {
					System.out.println("줄바꿈");
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}
