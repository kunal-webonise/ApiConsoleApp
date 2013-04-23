import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class SampleAPICall
{

   /**
    * Test harness.
    */
   public static void main(String[] args)
   {
     
      String url = "https://api.twitter.com/1/users/show.json?screen_name=twitterapi";
      String url1 = "http://192.168.10.174:3000/api/suggested_profiles.json?profile_id=4fed5c99a903623457000067";
      try
      {  URLConnection connection = new URL(url1).openConnection();
         connection.setRequestProperty("Accept-Charset","charset");
         InputStream response = connection.getInputStream();
//         String response = getResponse(url);
//         System.out.println(response);
         String myString = convertStreamToString(response);
      System.out.println(myString);
       /*  JsonReader reader = new JsonReader(new InputStreamReader(response));
         JsonParser jsonParser = new JsonParser();
      JsonArray userarray= jsonParser.parse(reader).getAsJsonArray();*/
     /*  String hello = "";*/
       MyParse(myString,response);

//         System.out.println(userarray);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   
   public static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
   
   public static void twitterParse(String res, InputStream is) {
	   System.out.println(res.getClass().getName()); 
	  /* try {
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
	}*/
	   
	   Gson gson = new Gson();
	   System.out.println(gson.toJson(1).getClass());
	   TwitterUser u = new TwitterUser();
	   System.out.println(u);
	   String json = gson.toJson(u);
	   System.out.println("MYJSON OBJECT::::::::::::::"+json);
	   
	   TwitterUser desobject = gson.fromJson(json, TwitterUser.class);
	   
	   System.out.println("DEs OBJECT:=================:::::::::::::"+desobject);
	   
	   JsonElement jelement = new JsonParser().parse(res); 
	   System.out.println(jelement);
	   TwitterUser desobject2 = gson.fromJson(jelement, TwitterUser.class);
	   System.out.println("DEs OBJECT22222222222:=================:::::::::::::"+desobject2);
	   
	   
	   
	}
   
   public static void MyParse(String res, InputStream is) {
	   System.out.println(res.getClass().getName()); 
	  /* try {
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
	}*/
	   
	   Gson gson = new Gson();
	   
	   
	 
	   
	  
	   
	   JsonElement jelement = new JsonParser().parse(res); 
	   System.out.println(jelement);
	   JsonObject jobject = jelement.getAsJsonObject();
	   System.out.println("Jobject::"+jobject);
	   jobject.get("success");
	   System.out.println("Success::"+ jobject.get("success"));
	   JsonArray  profiles = jobject.getAsJsonArray("suggested_profiles");
	   System.out.println("Array::"+ profiles.getClass());
	   
	   /*TwitterUser desobject2 = gson.fromJson(jelement, TwitterUser.class);
	   System.out.println("DEs OBJECT22222222222:=================:::::::::::::"+desobject2);*/
     UserProfile desobject = gson.fromJson(profiles.get(1), UserProfile.class);
     System.out.println("user Profile::"+ desobject.getPickup_line()); 
     ArrayList users = new ArrayList();
     for (JsonElement u : profiles)
     {
    	 System.out.println("user Profile::"+ gson.fromJson(u, UserProfile.class).getPickup_line());
    	 users.add(gson.fromJson(u, UserProfile.class));
     }
    
     for(int i=0; i<users.size(); i++)
     {
    	System.out.println(users.get(i)); 
     }
    
	   
	   
	}


}      