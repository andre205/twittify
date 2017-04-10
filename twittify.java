/*
Console application implementing both spotify and twitter APIs
*/

import org.json.JSONObject;
import org.json.JSONArray;

public class twittify{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        spotify_groundwork sg = new spotify_groundwork();

        //Display and retrieve user search option
        String[] searchoptions = {"track","artist","album"};
        int user_option = menu.create("Search spotify for a", searchoptions);

        //Retrieve user search term
        String user_searchterm = menu.create("Enter a search term: ");

        //Query Spotify API for results and print
        sg.print_spotify_search(user_option, user_searchterm);


        //Or return JSON object and print that separately (for use later with twitter implemented)
        //JSONObject test = sg.return_spotify_search(user_option, user_searchterm);
        //sg.print_spotify_JSON(test);
    }
}
