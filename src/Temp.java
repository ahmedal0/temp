import java.io.*;
import java.util.*;

public class Temp {
	static Random ra = new Random();
	final static String Name = "abcdefghijklmnopqrstuvxyz";
	final static Set<String> Names = new HashSet<String>();
	final static String[] data = new String[100];

	public static void main(String[] args) throws IOException {

		String FirstName,LastName,Gender,DateOfBirth,TimeOfDeath,Address;
		String[] gender = {"Male","Female","Unknown","Other"};
		for (int i =0;i<100 ; i++) {
			FirstName = RandomName();
			LastName = RandomName();
			Gender = gender[ra.nextInt(4)];
			DateOfBirth = Integer.toString(ra.nextInt(30)+1)+"/" + Integer.toString(ra.nextInt(11)+1)+"/" + Integer.toString(ra.nextInt(80)+1940);
			TimeOfDeath = null;
			Address = Integer.toString(ra.nextInt(88)+4665);
			data[i] = DemoGenerator( FirstName, LastName, Gender, DateOfBirth, TimeOfDeath, Address);
			
		}
		Write(data);
		
	}
	
	public static String RandomName() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = ra.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(Name.charAt(ra.nextInt(Name.length())));
	        }
	        if(Names.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	public static String DemoGenerator(String FirstName,String LastName,String Gender,String DateOfBirth,String TimeOfDeath,String Address) {
		String Form = "{\r\n" + 
				"\"firstNames: \" "+"\""+FirstName+"\""+",\r\n" + 
				"\"lastNames: \" " + "\""+LastName+"\""+",\r\n" + 
				"\"gender: \""+"\" "+Gender+"\""+",\r\n" + 
				"\"dateOfBirth: \" "+"\""+DateOfBirth+"\""+",\r\n" + 
				"\"timeOfDeath: \" "+"\""+TimeOfDeath+"\""+",\r\n" + 
				"\"address\": {      \r\n" + 
				"\"address :\" "+"\""+Address+"\""+"\r\n" + 
				"}";
		return Form;
	}

	public static void Write(String[] Data) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("Names.txt"));

		try {
			out.write("[");
			for(int i=0;i<Data.length;i++) {
				out.write(Data[i]);
				
			if (i!=Data.length-1) 
		    out.write(",");
			out.newLine();
			}
		    out.write("]");
		}
		catch (IOException e)
		{
		    System.out.println("Exception ");

		}
		finally
		{
		    out.close();
		}
		
	}
}



/*
{
"firstNames": "string",
"lastNames": "string",
"gender": "MALE|FEMALE|UNKNOWN|OTHER",
"dateOfBirth": "ISO-8601 timestamp (including time portion)",
"timeOfDeath": "ISO-8601 timestamp (including time portion)",
"address": {      
  "address": "string"
},
"partyAdditionalInfo (arbitrary collection of key-value pairs)": [
        {
    "key": "key1",
    "value": "value1"
  },
  {
    "key": "key1",
    "value": "value1"
  }      
]
}

*/