/*
  Spotify groundwork - Utilized by main application - twittify.java
  This class queries the spotify web API for relevant information
  pertaining to tracks, artists, and albums, and displays them to the user.\

  @author Tyler Andrews
*/

import java.util.*;
import java.io.*;
import org.json.JSONObject;
import org.json.JSONArray;

public class spotify_groundwork {

    public spotify_groundwork()
    {
    }

    public static JSONObject return_spotify_search(int searchoption, String searchterm){

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

        ////System.out.println("Retrieving JSON...");

        //Create URL and inputstream to read from URL
        try
        {
            url = new java.net.URL(urltext);
        }
        catch (Exception e)
        {
          //System.out.println("make url error");
        }

        InputStream input = null;
        try
        {
            input = url.openStream();
        }
        catch (Exception e)
        {
          //System.out.println("open stream error");
        }

        java.io.BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        }
        catch (Exception e)
        {
          //System.out.println("create reader error");
        }

        ////System.out.println("Parsing JSON...\n");

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
                    ////System.out.println(s);
                }
            }
        }
        catch (Exception e)
        {
            //System.out.println("reader parsing error");
        }


        //Create object containting all results
        JSONObject APIresponse = new JSONObject(entireJSON);
        return APIresponse;
    }

    public static String getGenre(String artist){

        String searchquery = artist.replaceAll(" ", "+");
        String returnString = "";

        String urltext = "https://api.spotify.com/v1/search?q=" + searchquery + "&type=artist";
        java.net.URL url = null;
        try
        {
            url = new java.net.URL(urltext);
        }
        catch (Exception e)
        {
          //System.out.println("make url error");
        }

        InputStream input = null;
        try
        {
            input = url.openStream();
        }
        catch (Exception e)
        {
          //System.out.println("open stream error");
        }

        java.io.BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        }
        catch (Exception e)
        {
          //System.out.println("create reader error");
        }

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
                }
            }
        }
        catch (Exception e)
        {
            //System.out.println("reader parsing error");
        }

        JSONObject APIresponse = new JSONObject(entireJSON);
        JSONObject artists = APIresponse.getJSONObject("artists");
        JSONArray items = artists.getJSONArray("items");

        if (items.length() == 0)
        {
            ////System.out.println("No results found");
        }

        else{

            //ONLY RETURN GENRES FOR FIRST ARTIST
            JSONArray genres = items.getJSONObject(0).getJSONArray("genres");
            if (genres.length() > 0)
            {

                returnString = genres.getString(0);

            }

        }

        return returnString;

    }

    public static String[] return_spotify_track_string_array(JSONObject obj){

      String[] returnArray = new String[20];
      String songname = "";
      String artistname = "";
      String searchtype = "track";
      //Check if JSON contains track results
      try
      {
          JSONObject tracks = obj.getJSONObject("tracks");
          if (searchtype == "track")
          {
              JSONArray items = tracks.getJSONArray("items");
              //no items = no results
              if (items.length() == 0)
              {
                  //System.out.println("No results found");
                  returnArray[0] = "No Results found";
              }
              //display results
              else{
                  int k = 1;
                  //System.out.println(items.length() + " results found");
                  returnArray[0] = items.length() + " results found";
                  if (items.length() > 9)
                      returnArray[0] = "9 results found";
                  //for each result, display track title, artist, and song length
                  for (int i = 0; i < items.length(); ++i)
                  {
                      //System.out.println("------------------------");
                      //TRACK NAME
                      songname = items.getJSONObject(i).getString("name");
                      //System.out.println("Track title: " + songname);

                      //ARTIST(S)
                      JSONObject album = items.getJSONObject(i).getJSONObject("album");
                      JSONArray artists = album.getJSONArray("artists");
                      //System.out.print("Artists: ");
                      for (int j = 0; j < artists.length(); ++j)
                      {
                          artistname = artists.getJSONObject(j).getString("name");

                      }
                      //System.out.print("\n");

                      //SONG LENGTH (Returned in milliseconds) convert to Min:Sec
                      int songlength = items.getJSONObject(i).getInt("duration_ms");
                      if ((songlength/1000)%60 < 10)
                      {
                        //System.out.println("Length: " + (songlength/1000)/60 + ":0" + (songlength/1000)%60);
                        returnArray[k] = " Track title: " + songname +"\n Artists: " + artistname + "\n Length: " +  (songlength/1000)/60 + ":0" + (songlength/1000)%60 ;
                      }
                      else
                      {
                        //System.out.println("Length: " + (songlength/1000)/60 + ":" + (songlength/1000)%60);
                        returnArray[k] = " Track title: " + songname +"\n Artists: " + artistname + "\n Length: " +  (songlength/1000)/60 + ":" + (songlength/1000)%60 ;

                      }

                      k++;
                  }
              }

          }
      }

      catch(Exception e)
      {
          searchtype = "artist";
      }

      return returnArray;
    }

    public static String[] return_spotify_artist_string_array(JSONObject obj){

      String[] returnArray = new String[20];
      String searchtype = "artist";
      String artistname = "";
      int followers = 0;
      String genresString = "";
      try
      {
          JSONObject artists = obj.getJSONObject("artists");
          if (searchtype == "artist")
          {
              JSONArray items = artists.getJSONArray("items");

              if (items.length() == 0)
              {
                  //System.out.println("No results found");
                  returnArray[0] = "No results found";
              }

              else{

                  //System.out.println(items.length() + " results found");

                  returnArray[0] = items.length() + " results found";

                  if (items.length() > 9)
                      returnArray[0] = "9 results found";

                  int k = 1;
                  for (int i = 0; i < items.length(); ++i)
                  {
                      //System.out.println("------------------------");
                      //ARTIST NAME
                      artistname = items.getJSONObject(i).getString("name");
                      //System.out.println("Artist name: " + artistname);

                      //FOLLOWERS
                      followers = items.getJSONObject(i).getJSONObject("followers").getInt("total");
                      //System.out.println("Followers: " + followers);

                      //GENRES
                      JSONArray genres = items.getJSONObject(i).getJSONArray("genres");

                      if (genres.length() > 0)
                      {
                          genresString = genres.getString(0);
                          //System.out.print("\n");
                      }
                      returnArray[k] = "Artist name: " + artistname + "\nFollowers: " + followers + "\nGenre: " + genresString;
                      k++;
                  }
              }
          }
      }

      catch(Exception e)
      {
          searchtype = "album";
      }

      return returnArray;
    }

    public static String[] return_spotify_album_string_array(JSONObject obj){

      String[] returnArray = new String[20];
      String searchtype = "album";
      String artistname = "";
      String albumname = "";
      String genre = "";
      try
      {
          JSONObject albums = obj.getJSONObject("albums");
          if (searchtype == "album")
          {
              JSONArray items = albums.getJSONArray("items");

              if (items.length() == 0)
              {
                  //System.out.println("No results found");
                  returnArray[0] = "No results found";
              }

              else
              {
                  //System.out.println(items.length() + " results found");

                  returnArray[0] = items.length() + " results found";
                  if (items.length() > 9)
                      returnArray[0] = "9 results found";

                  int k = 1;
                  for (int i = 0; i < items.length(); ++i)
                  {
                      //System.out.println("------------------------");
                      //ALBUM NAME
                      albumname = items.getJSONObject(i).getString("name");
                      //System.out.println("Album name: " + albumname);

                      //ARTISTS
                      JSONArray artists = items.getJSONObject(i).getJSONArray("artists");
                      //System.out.print("Artists: ");

                      artistname = artists.getJSONObject(0).getString("name");

                      genre = getGenre(artistname);

                      returnArray[k] = "Album name: " + albumname + "\nArtist: " + artistname + "\nGenre: " + genre;
                      k++;
                      //System.out.print("\n");
                      //printGenres(artists.getJSONObject(0).getString("name"));
                  }
              }
          }
      }

      catch(Exception e)
      {

      }

      return returnArray;
    }

}
