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
        Menu menu = new Menu();
        spotify_groundwork sg = new spotify_groundwork();

        //Display and retrieve user search option
        String[] searchoptions = {"a track","an artist","an album","the top 200"};
        int user_option = menu.create("Search spotify for", searchoptions);

        if (user_option == 4)
        {
            spotify_chart_fetcher scf = new spotify_chart_fetcher();
            String[] top200 = scf.getTop200();
            //putting the name and result into table
            //format so that they can be indexed by number(String)
            List<String[]> top200table = new LinkedList<String[]>();
            for(int i = 0; i < 200; ++i)
            {
                top200table.add(new String[] {String.valueOf(i+1),top200[i]});
            }

            System.out.println("Spotify Top 200");
            for (int i = 0; i < 200; ++i)
            {
                System.out.println((i+1) + ": " + top200[i]);
            }

            //Jeff remake this using menu.create
            //int songnum = menu.create("Enter a song number to pull up most recent related tweets!", top200);

            //FETCH TWEETS
            System.out.println("\nEnter song number to pull up most recent " +
                                                            "related tweets!");

            String input1 = new java.util.Scanner(System.in).nextLine();
            for (String[] a : top200table)
            {

                if(a[0].equals(input1))
                {
                  System.out.println("----TWEETS----\n");
                  twitter_groundwork instance = new twitter_groundwork();

                  for(String b : instance.search(a[1]))
                  {
                      System.out.println(b+"\n");
                  }
                  //String input2 = new java.util.Scanner(System.in).nextLine();
                }
            }
            //String input3 = new java.util.Scanner(System.in).nextLine();
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
