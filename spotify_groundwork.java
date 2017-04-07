/*
  Spotify groundwork
  This class query's the spotify web API for relevant information
  pertaining to tracks, artists, and albums, and displays them to the user.

  @author Tyler Andrews
*/

import java.util.*;
import java.io.*;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONArray;

public class spotify_groundwork {

    public spotify_groundwork()
    {
    }

    public static void getJSON(int searchoption, String searchterm){

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

        //API URL uses + instead of spaces
        String searchquery = searchterm.replaceAll(" ", "+");

        String urltext = "https://api.spotify.com/v1/search?q=" + searchquery + "&type=" + searchtype;
        java.net.URL url = null;

        System.out.println("Retrieving JSON...");

        //Create URL and inputstream to read from URL
        try
        {
            url = new java.net.URL(urltext);
        }
        catch (Exception e)
        {
          System.out.println("make url error");
        }

        InputStream input = null;
        try
        {
            input = url.openStream();
        }
        catch (Exception e)
        {
          System.out.println("open stream error");
        }

        java.io.BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        }
        catch (Exception e)
        {
          System.out.println("create reader error");
        }

        System.out.println("Parsing JSON...\n");

        //For each line returned by the URL, add it to a string
        String entireJSON = "";
        String s = "test";
        try
        {
            while(s != null)
            {
                s = reader.readLine();

                if (s != null)
                {
                    entireJSON += s;
                    //PRINT ENTIRE JSON
                    //System.out.println(s);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("reader parsing error");
        }

        //For each search type, read the corresponding JSONs needed to display relevant information
        if (searchtype == "track")
        {
            //Create object containting all results
            JSONObject APIresponse = new JSONObject(entireJSON);
            //Create object containting all tracks
            JSONObject tracks = APIresponse.getJSONObject("tracks");
            //split search results into a JSON array of items
            JSONArray items = tracks.getJSONArray("items");
            //no items = no results
            if (items.length() == 0)
            {
                System.out.println("No results found");
            }
            //display results
            else{

                System.out.println(items.length() + " results found");
                //for each result, display track title, artist, and song length
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

                    //SONG LENGTH
                    int songlength = items.getJSONObject(i).getInt("duration_ms");
                    System.out.println("Length: " + songlength/1000 + " seconds");
                }
            }
        }

        else if (searchtype == "artist")
        {

            JSONObject APIresponse = new JSONObject(entireJSON);
            JSONObject artists = APIresponse.getJSONObject("artists");
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
          JSONObject APIresponse = new JSONObject(entireJSON);
          JSONObject albums = APIresponse.getJSONObject("albums");
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

                        //ADD ANOTHER SEARCH FOR GENRES HERE LATER
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
