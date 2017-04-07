import java.util.*;
import java.io.*;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONArray;

public class spotify_groundwork {

    public spotify_groundwork()
    {
    }

    public static void getJSON(int searchoption){

        Scanner sinput = new Scanner(System.in);

        String searchtype = "track";
        switch (searchoption)
        {
          case (1):
            System.out.println("Enter a track name:");
            break;
          case (2):
            searchtype = "artist";
            System.out.println("Enter an artist name:");
            break;
          case (3):
            searchtype = "album";
            System.out.println("Enter an album name:");
          default:
            break;
        }

        String i2 = sinput.nextLine();
        String searchquery = i2.replaceAll(" ", "+");

        String urltext = "https://api.spotify.com/v1/search?q=" + searchquery + "&type=" + searchtype;
        java.net.URL url = null;

        System.out.println("Retrieving JSON...");

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
                    //System.out.println(s);
                }
            }
        }
        catch (Exception e) {
            System.out.println("reader parsing error");
        }

        System.out.println("Parsing JSON...");


        if (searchtype == "track")
        {
            //Create object containting all results
            JSONObject APIresponse = new JSONObject(entireJSON);

            //actual results one layer in for some reason
            JSONObject tracks = APIresponse.getJSONObject("tracks");

            //split search results into a JSON array
            JSONArray items = tracks.getJSONArray("items");

            if (items.length() == 0)
            {
                System.out.println("No results found");
            }

            else{

                System.out.println(items.length() + " results found");

                for (int i = 0; i < items.length(); ++i)
                {
                  System.out.println("------------------------");
                  //TRACK NAME
                  String songname = items.getJSONObject(i).getString("name");
                  System.out.println("Track title: " + songname);

                  //ARTIST(S)
                  JSONObject album = items.getJSONObject(i).getJSONObject("album");
                  JSONArray artists = album.getJSONArray("artists");
                  for (int j = 0; j < artists.length(); ++j)
                  {
                        String artistname = artists.getJSONObject(j).getString("name");
                        System.out.println("Artist: " + artistname);
                  }

                    int songlength = items.getJSONObject(i).getInt("duration_ms");
                    System.out.println("Length: " + songlength/1000 + " seconds");
                }
            }
        }

        else if (searchtype == "artist")
        {
          //Create object containting all results
          JSONObject APIresponse = new JSONObject(entireJSON);

          //actual results one layer in for some reason
          JSONObject artists = APIresponse.getJSONObject("artists");

          //split search results into a JSON array
          JSONArray items = artists.getJSONArray("items");

          if (items.length() == 0)
          {
              System.out.println("No results found");
          }

          else{

              System.out.println(items.length() + " results found");

              for (int i = 0; i < items.length(); ++i)
              {
                System.out.println("------------------------");
                //ARTIST NAME
                String artistname = items.getJSONObject(i).getString("name");
                System.out.println("Artist name: " + artistname);

                //FOLLOWERS
                int followers = items.getJSONObject(i).getJSONObject("followers").getInt("total");
                System.out.println("Followers: " + followers);

                //GENRES
                JSONArray genres = items.getJSONObject(i).getJSONArray("genres");
                for (int j = 0; j < genres.length(); ++j)
                {
                      String genre = genres.getString(j);
                      System.out.println("Genre: " + genre);
                }
              }
          }
        }

        else if (searchtype == "album")
        {
          //Create object containting all results
          JSONObject APIresponse = new JSONObject(entireJSON);

          //actual results one layer in for some reason
          JSONObject albums = APIresponse.getJSONObject("albums");

          //split search results into a JSON array
          JSONArray items = albums.getJSONArray("items");

          if (items.length() == 0)
          {
              System.out.println("No results found");
          }

          else
          {

              System.out.println(items.length() + " results found");

              for (int i = 0; i < items.length(); ++i)
              {
                  System.out.println("------------------------");
                  //ALBUM NAME
                  String albumname = items.getJSONObject(i).getString("name");
                  System.out.println("Album name: " + albumname);

                  //ARTISTS
                  JSONArray artists = items.getJSONObject(i).getJSONArray("artists");
                  for (int j = 0; j < artists.length(); ++j)
                  {
                        String artistname = artists.getJSONObject(j).getString("name");
                        System.out.println("Artist: " + artistname);
                  }
              }
          }
        }

        else
        {
          System.out.println("Invalid search type");
        }

  }
}
