package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class JSONParse {

	public static void main(String[] args) 
	{
		/**
		 * Helpful tool for formatting JSON: https://jsonformatter.curiousconcept.com/
		 * 
		 * */
		
		//Path of created JSON file
		String filePath = "C:\\Users\\mzeva\\eclipse-workspace\\SE Projects\\src\\parseJSON.json";
		//initialize bufferedReader to close stream in finally clause
		BufferedReader br = null;
		
		try {
			//read filePath String with FileReader
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			//create StringBuffer to append lines from JSON file
			StringBuffer sb = new StringBuffer();
			//line for reading through file
			String line = "";
			
			//continue reading lines in file as long as data returned is not null
			while((line = br.readLine()) != null)
			{
				//append JSON data to StringBuffer and separate to format JSON
				sb.append(line).append(System.lineSeparator());
			}
			System.out.println(sb);
			
			Gson gson = new Gson();
			
			System.out.println("************************************");
			
			//parsing json object using created class with attributes of the same name as JSON keys
			//**NOTE** the one line of code below will parse all of the JSON into objects and attributes, retrieving the information is separate as shown below
			MyJsonParse parseJson = gson.fromJson(sb.toString(), MyJsonParse.class);
			
			//object attribute from the MyJsonParse class, populating object from supplied JSON information
			Customer c = parseJson.getCustomer();
			Shopping_List sl = c.getShopping_list();
			
			System.out.println("Name: " + c.getName() + " " + c.getSurname());
			System.out.println("Contact: " + c.getContact());
			System.out.println("Shopping List: " + sl.getItems());
			System.out.println("Item 1 Info:");//could format JSON better, null pointers resulting from List in Shopping_List.class
			System.out.println("Type: "+sl.getInformation().get(0).getObject1().getType());
			System.out.println("Cover: "+sl.getInformation().get(0).getObject1().getCover());
			System.out.println("Price: "+sl.getInformation().get(0).getObject1().getPrice());
			System.out.println("Item 2 Info:");
			System.out.println("Type: "+sl.getInformation().get(1).getObject2().getType());
			System.out.println("Parts: "+sl.getInformation().get(1).getObject2().getParts().getAllInOne().getCpu()+", "+
					sl.getInformation().get(1).getObject2().getParts().getAllInOne().getGpu()+", "+
					sl.getInformation().get(1).getObject2().getParts().getAllInOne().getMotherboard()+", "+
					sl.getInformation().get(1).getObject2().getParts().getAllInOne().getRam());
			System.out.println("Price: "+sl.getInformation().get(1).getObject2().getPrice());
			
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//checking for Null Pointer
			if(br != null)
			{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
