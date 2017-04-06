//Console application implementing both spotify and twitter APIs
public class twittify{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        spotify_groundwork sg = new spotify_groundwork();

        int response = menu.prompt();
        sg.getJSON(response);
    }
}
