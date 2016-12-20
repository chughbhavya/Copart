import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.*;

public class ZipCodeLookup {
	
	public static void main(String args[]) throws Exception{
		String zipCode="";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter zipcode: ");
		zipCode = s.nextLine();
		
		String urlString="http://maps.googleapis.com/maps/api/geocode/json?sensor=true&address="+zipCode;
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		StringBuilder output = new StringBuilder();
		connection.setRequestMethod("GET");
		
		BufferedReader inPut = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String resultLine;
		
		while((resultLine = inPut.readLine()) != null){
			output.append("\n"+ resultLine);
		}
		
		inPut.close();

		JSONObject jo= new JSONObject(output.toString());
		
		JSONArray ja=jo.getJSONArray("results");
		JSONArray ja1= new JSONArray();
		ja1 = (JSONArray)ja.getJSONObject(0).get("address_components");
		
		for (int i=0;i<ja1.length();i++){
				System.out.println(ja1.getJSONObject(i).getString("long_name"));
		}
	}

}
