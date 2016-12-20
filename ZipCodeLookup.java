import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class ZipCodeLookup {

	 static void RestCall(String zipCode){
		
		try {

			URL url = new URL("https://www.zipcodeapi.com/rest/SH8Be5Im18StbtqknXgm9a9aoJZsukum2CXhHGDJOvd0ZDknBAJKLSV9CVC6g6si/info.json/"+zipCode+"/degrees");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
			
				JSONObject jObject  = new JSONObject(output);
				System.out.println("City: "+jObject.getString("city"));
				System.out.println("State: "+jObject.getString("state"));
				
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		
	}
	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
        System.out.println("Enter the zipcode");
        
        String S = input.nextLine();
	    RestCall(S);

	}

}
