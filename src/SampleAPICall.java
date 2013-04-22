import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SampleAPICall
{

   /**
    * Test harness.
    */
   public static void main(String[] args)
   {
     
      String url = "http://192.168.10.174:3000/api/suggested_profiles.json?profile_id=4fed5c97a90362345700002f";
      try
      {  URLConnection connection = new URL(url).openConnection();
         connection.setRequestProperty("Accept-Charset","charset");
         InputStream response = connection.getInputStream();
//         String response = getResponse(url);
//         System.out.println(response);
         String myString = convertStreamToString(response);
//        System.out.println(myString);
       /*  JsonReader reader = new JsonReader(new InputStreamReader(response));
         JsonParser jsonParser = new JsonParser();
      JsonArray userarray= jsonParser.parse(reader).getAsJsonArray();*/
     /*  String hello = "";*/
        parse(myString);

//         System.out.println(userarray);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   /*
    * Retrieve response using commons HttpClient API.
    */
   /*private static String getResponse(String url) throws IOException {
      GetMethod get = new GetMethod(url);
      new HttpClient().executeMethod(get);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream() ;
      byte[] byteArray = new byte[1024];
      int count = 0 ;
      while((count = get.getResponseBodyAsStream().read(byteArray, 0, byteArray.length)) > 0)
      {
         outputStream.write(byteArray, 0, count) ;
      }
      return new String(outputStream.toByteArray(), "UTF-8");
  }*/
   
   public static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
   
   public static void parse(String res) {
	   System.out.println(res.getClass().getName()); 
	   try {
		JSONObject jsonObject = new JSONObject(res);
		JSONArray profiles = jsonObject.getJSONArray("suggested_profiles");
		System.out.println(profiles.toString());
		System.out.println(profiles.length());
		for(int i=0; 1<profiles.length();i++)
		{  
			JSONObject resultObj = profiles.getJSONObject(i);
			String gender = resultObj.getString("gender");
			System.out.println(gender);
			String id = resultObj.getString("_id");
			System.out.println(id);
			String pick = resultObj.getString("pickup_line");
			System.out.println(pick);
		}
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}

}      