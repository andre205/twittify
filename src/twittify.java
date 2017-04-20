/*
Console application implementing both spotify and twitter APIs
*/
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;


public class twittify {

    public static void main (String[] args) throws Exception
    {
        //CREATE NEW INSTANCES OF REQUIRED CLASSES
        Menu menu = new Menu();
        spotify_groundwork sg = new spotify_groundwork();
        twitter_groundwork tg = new twitter_groundwork();
        spotify_chart_fetcher scf = new spotify_chart_fetcher();
        //

        //DISPLAY AND READ USER SEARCH OPTIONS
        String[] searchoptions = {"a track","an artist","an album","the top 200"};
        int user_option = menu.create("Search spotify for", searchoptions);
        //

        //CHOOSE NUMBER 4 OR DIE
        if (user_option == 4)
        {
            //CREATE NEW INSTANCES OF DISPLAY ARRAY AND INDEX TABLE
            String[] top200 = scf.getTop200();//POPULATE ARRAY
            List<String[]> top200table = new LinkedList<String[]>();

            //DISPLAY TOP 200
            System.out.println("Spotify Top 200");
            for (int i = 0; i < 200; ++i)
            {
                //POPULATE INDEXE TABLE
                top200table.add(new String[] {String.valueOf(i+1),top200[i]});
                //PRINT SONGS
                System.out.println((i+1) + ": " + top200[i]);
            }

            //USER INPUT CHOICE
            String songnum = menu.create("Enter a song number to pull up most recent related tweets!");
            for (String[] a : top200table)
            {
                //FINDS SONG CORRESPONDING TO USER INPUT
                if(a[0].equals(songnum))
                {
                  System.out.println("----TWEETS----\n");
                  //DISPLAY ALL TWEETS
                  for(String b : tg.search(a[1]))
                  {
                      System.out.println(b+"\n");
                  }
                  //SYSTEM PAUSE
                  System.out.println("Enter any button to quit");
                  String input2 = new java.util.Scanner(System.in).nextLine();
                }
            }
        }

        else
        {
          //Retrieve user search term
          String user_searchterm = menu.create("Enter a search term: ");

          //Query Spotify API for results and print
          sg.print_spotify_search(user_option, user_searchterm);


          //Or return JSON object and print that separately (for use later with twitter implemented)
          //JSONObject test = sg.return_spotify_search(user_option, user_searchterm);
          //sg.print_spotify_JSON(test);
        }

    }
}
