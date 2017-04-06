import java.util.*;
import java.io.*;
import java.io.InputStream;
import org.json.*;


//RETRIEVES A JSON FROM WEB API BASED ON SEARCH TERM
public class spotify_groundwork {

  public static void main(String[] args){

    //We can modify this string based on the search terms
    //options -- album, track, artist
    //https://developer.spotify.com/web-api/search-item/

    String urltext = "https://api.spotify.com/v1/search?q=Sound+of+Silence&type=track";
    java.net.URL url = null;
    try {
      url = new java.net.URL(urltext);
    }
    catch (Exception e) {
      System.out.println("make url error");
    }

    InputStream input = null;
    try {
        input = url.openStream();
    }
    catch (Exception e) {
      System.out.println("open stream error");
    }

    java.io.BufferedReader reader = null;
    try {
        reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
    }
    catch (Exception e) {
      System.out.println("create reader error");
    }

    String entireJSON = "";
    String s = "test";
    try {
        while(s != null)
        {
            s = reader.readLine();
            //PRINT ENTIRE JSON
            //System.out.println(s);
            if (s != null)
              entireJSON += s;
        }
    }
    catch (Exception e) {
        System.out.println("reader parsing error");
    }

    //Create object containting all results
    JSONObject APIresponse = new JSONObject(entireJSON);

    //actual results one layer in for some reason
    JSONObject tracks = APIresponse.getJSONObject("tracks");

    //split search results into a JSON array
    JSONArray items = tracks.getJSONArray("items");
    //iterate through the array and display data on each result
    for (int i = 0; i < items.length(); ++i)
    {
       String songname = items.getJSONObject(i).getString("name");
       System.out.println(songname);
    }


    //JSONObject items = tracks.getJSONObject("items");

    // JSONArray arr = APIresponse.getJSONArray("tracks");
    // for (int i = 0; i < arr.length(); i++)
    // {
    //     JSONObject tracks = arr.getJSONObject(i);
    //     JSONArray items = tracks.getJSONArray("items");
    //     for (int j = 0; j < items.length(); j++)
    //     {
    //         String test = items.getJSONObject(j).getString("type");
    //         System.out.println(test);
    //     }
    // }
  }
}
