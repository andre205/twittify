//Console application implementing both spotify and twitter APIs
import java.util.Scanner;

public class twittify{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        spotify_groundwork sg = new spotify_groundwork();

        //Display and retrieve user search option
        String[] searchoptions = {"track","artist","album"};
        int user_option = menu.create("Search spotify for a", 3, searchoptions);

        //MOVE THIS TO MENU CLASS EVENTUALLY
        //Retrieve user search term
        System.out.println("Enter a search term: ");
        Scanner input = new Scanner(System.in);
        String user_searchterm = input.nextLine();

        //Query Spotify API for results and print
        sg.getJSON(user_option, user_searchterm);
    }
}
