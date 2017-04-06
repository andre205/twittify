import java.util.*;
import java.io.*;
import java.io.InputStream;
//import org.json.JSONObject;
//import org.json.JSONArray;

public class spotify_groundwork {

    public spotify_groundwork()
    {
    }

    public static void getJSON(int searchoption){

        Scanner sinput = new Scanner(System.in);
        //System.out.println("Select a search type\n1. track\n2. artist\n3. album");
        //String i1 = sinput.nextLine();

        String searchtype = "track";
        switch (searchoption)
        {
          case (1):
            break;
          case (2):
            searchtype = "artist";
            break;
          case (3):
            searchtype = "album";
          default:
            break;
        }

        System.out.println("search for:");
        String i2 = sinput.nextLine();
        String searchquery = i2.replaceAll(" ", "+");

        String urltext = "https://api.spotify.com/v1/search?q=" + searchquery + "&type=" + searchtype;
        java.net.URL url = null;

        System.out.println("RETRIVING JSON");

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
                if (s != null)
                {
                    entireJSON += s;
                    System.out.println(s);
                }
            }
        }
        catch (Exception e) {
            System.out.println("reader parsing error");
        }




        // if (searchtype == "track")
        // {
        //   //Create object containting all results
        //   JSONObject APIresponse = new JSONObject(entireJSON);
        //
        //   //actual results one layer in for some reason
        //   JSONObject tracks = APIresponse.getJSONObject("tracks");
        //
        //   //split search results into a JSON array
        //   JSONArray items = tracks.getJSONArray("items");
        //
        //   if (items.length() == 0)
        //   {
        //     System.out.println("No results found");
        //   }
        //
        //   else{
        //     for (int i = 0; i < items.length(); ++i)
        //     {
        //       System.out.println("------------------------");
        //       //TRACK NAME
        //       String songname = items.getJSONObject(i).getString("name");
        //       System.out.println("Track title: " + songname);
        //
        //       //ARTIST(S)
        //       JSONObject album = items.getJSONObject(i).getJSONObject("album");
        //       JSONArray artists = album.getJSONArray("artists");
        //       for (int j = 0; j < artists.length(); ++j)
        //       {
        //         String artistname = artists.getJSONObject(j).getString("name");
        //         System.out.println("Artist: " + artistname);
        //       }
        //
        //       // String songlength = items.getJSONObject(i).getString("duration_ms");
        //       // System.out.println("Length: " + songlength.toString());
        //
        //     }
        //   }
        // }
        //
        // else if (searchtype == "artist")
        // {
        //   System.out.println("Working on it");
        // }
        //
        // else if (searchtype == "album")
        // {
        //   System.out.println("Working on it");
        // }
        //
        // else
        // {
        //   System.out.println("Invalid search type");
        // }

  }
}
